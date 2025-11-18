import java.util.ArrayList;

public class Draw {
    public void drawHangMan(int livesAmount){
        switch(livesAmount) {
            case 8:
                System.out.println();
                System.out.println("   |------|");
                System.out.println("   |      |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("     -----|-----");
                break;

            case 7:
                System.out.println();
                System.out.println("   |------|");
                System.out.println("   |      |");
                System.out.println("   O      |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("     -----|-----");
                break;

            case 6:
                System.out.println();


                System.out.println("   |------|");
                System.out.println("   |      |");
                System.out.println("   O      |");
                System.out.println("   |      |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("     -----|-----");
                break;
            case 5:
                System.out.println();


                System.out.println("   |------|");
                System.out.println("   |      |");
                System.out.println("   O      |");
                System.out.println("   |\\     |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("     -----|-----");
                break;
            case 4:
                System.out.println();


                System.out.println("   |------|");
                System.out.println("   |      |");
                System.out.println("   O      |");
                System.out.println("  /|\\     |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("     -----|-----");
                break;
            case 3:
                System.out.println();


                System.out.println("   |------|");
                System.out.println("   |      |");
                System.out.println("   O      |");
                System.out.println("  /|\\     |");
                System.out.println("    \\     |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("     -----|-----");
                break;
            case 2:
                System.out.println();


                System.out.println("   |------|");
                System.out.println("   |      |");
                System.out.println("   O      |");
                System.out.println("  /|\\     |");
                System.out.println("  / \\     |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("     -----|-----");
                break;
            case 1:
                System.out.println();


                System.out.println("   |------|");
                System.out.println("   |      |");
                System.out.println("   O      |");
                System.out.println("  /|\\     |");
                System.out.println(" _/ \\     |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("     -----|-----");
                break;
            case 0:
                System.out.println();


                System.out.println("   |------|");
                System.out.println("   |      |");
                System.out.println("   O      |");
                System.out.println("  /|\\     |");
                System.out.println(" _/ \\_    |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("     -----|-----");
                break;
            default:
                break;
        }
    }
    public void drawAlphabet(ArrayList<String> guessedLetters, ArrayList<String> alphabetLetters, String ANSI_WHITE_BOLD, String ANSI_RESET){
        for(int i = 0; i < 10; i++){
            if(guessedLetters.contains(alphabetLetters.get(i))){
                System.out.print(ANSI_WHITE_BOLD + " " + alphabetLetters.get(i) + ANSI_RESET);
            }else{
                System.out.print(" " + alphabetLetters.get(i));
            }
        }

        System.out.println();
        System.out.print(" ");

        for(int i = 10; i < 19; i++){
            if(guessedLetters.contains(alphabetLetters.get(i))){
                System.out.print(ANSI_WHITE_BOLD + " " + alphabetLetters.get(i) + ANSI_RESET);
            }else{
                System.out.print(" " + alphabetLetters.get(i));
            }
        }

        System.out.println();
        System.out.print("   ");

        for(int i = 19; i < 26; i++){
            if(guessedLetters.contains(alphabetLetters.get(i))){
                System.out.print(ANSI_WHITE_BOLD + " " + alphabetLetters.get(i) + ANSI_RESET);
            }else{
                System.out.print(" " + alphabetLetters.get(i));
            }
        }

        System.out.println();
    }
}
