//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


public class Main {

    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    // Custom declaration
    public static final String ANSI_WHITE_BOLD = "\033[1;30m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        File actionWords = new File("src/words.txt");
        File alphabet = new File("src/alphabet.txt");

        ReadFile readfile = new ReadFile();
        Random r = new Random();
        Draw draw = new Draw();

        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> letters = new ArrayList<String>();
        ArrayList<String> guessContainer = new ArrayList<String>();
        ArrayList<String> guessedLetters = new ArrayList<String>();
        ArrayList<String> alphabetLetters = new ArrayList<String>();

        readfile.readFile(words,actionWords);
        readfile.readFile(alphabetLetters,alphabet);

        String guess;
        String randomWord;

        boolean won = true;
        int count = 0;
        int livesAmount = 9;

        // Random word selection
        int r1 = r.nextInt(words.size());
        randomWord = words.get(r1);

        for(int i = 0; i < randomWord.length(); i++){
            guessContainer.add("_");
            letters.add("" + randomWord.charAt(i));
        }

        System.out.print("Welcome to hangman, try and guess the word. \n");

        do {
            draw.drawAlphabet(guessedLetters, alphabetLetters, ANSI_WHITE_BOLD, ANSI_RESET);
            System.out.print("Word Characters: ");

            for(int i = 0; i < randomWord.length(); i++){
                System.out.print(" " + guessContainer.get(i));
            }

            System.out.print("\nPlease enter your guess: ");
            guess = sc.nextLine();


            System.out.print("\033[H\033[2J");
            System.out.flush();

            for(int i = 0; i < guess.length(); i++){
                if (!letters.contains(String.valueOf(guess.charAt(i))) & !letters.contains(String.valueOf(guess.toUpperCase().charAt(i))) & !guessedLetters.contains(String.valueOf(guess.charAt(i)))){
                    livesAmount--;
                    System.out.print("Wrong letter " + "[" + guess.charAt(i) + "]" + " doesn't exist in the word. \n");
                } else if (guessedLetters.contains(String.valueOf(guess.charAt(i))))
                {
                    System.out.print("Already guessed that letter(s): " + guess.charAt(i) + '\n');
                }
                guessedLetters.add(String.valueOf(guess.charAt(i)));
            }

            for (int i = 0; i < randomWord.length(); i++) {
                for (int j = 0; j < guess.length(); j++) {
                    if (randomWord.charAt(i) == guess.charAt(j) & letters.contains(String.valueOf(guess.charAt(j))) | randomWord.charAt(i) == guess.toUpperCase().charAt(j) & letters.contains(String.valueOf(guess.toUpperCase().charAt(j)))) {
                        count++;
                        guessContainer.set(i, String.valueOf(randomWord.charAt(i)));
                        letters.set(i, "_");
                        //System.out.println("Guess was lower case: " + guess.charAt(j));
                        break;
                    }
                }
            }


            //System.out.print("\nGuessed: " + guessedLetters);

            draw.drawHangMan(livesAmount);

            if (livesAmount == 0 | count == randomWord.length()) {
                won = false;
            }
        } while (won);

        if(livesAmount <= 0){
            System.out.println("\nYou were hung! The word was " + randomWord);
        }else
        {
            System.out.println("\nYou won! The word was " + randomWord);
        }

    }
}
