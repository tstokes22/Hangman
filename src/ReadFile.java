import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    public void readFile(ArrayList<String> wordsArray, File myFile){
        try(Scanner myReader = new Scanner(myFile) ){
            while(myReader.hasNextLine()){
                String words = myReader.nextLine();
                wordsArray.add(words);
            }
        } catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
