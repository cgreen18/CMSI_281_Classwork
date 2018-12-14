package sentinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sentinal implements SentinalInterface {

    // -----------------------------------------------------------
    // Fields
    // -----------------------------------------------------------

    private PhraseHash posHash, negHash;


    // -----------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------

    Sentinal (String posFile, String negFile) throws FileNotFoundException {
        posHash = new PhraseHash();
        negHash = new PhraseHash();

        loadSentimentFile(posFile,true);
        loadSentimentFile(negFile,false);
    }


    // -----------------------------------------------------------
    // Methods
    // -----------------------------------------------------------

    public void loadSentiment (String phrase, boolean positive) {
        String[] words = phrase.trim().split(" ");
        if(positive){
            for(int i = 0; i< words.length; i++){
                posHash.put(words[i]);
            }
        }
        else{
             for(int i = 0; i< words.length; i++){
                 negHash.put(words[i]);
             }
        }
    }

    public void loadSentimentFile (String filename, boolean positive) throws FileNotFoundException {
        Scanner scan = new Scanner(filename);

        while(scan.hasNextLine() == true){
            loadSentiment(scan.nextLine(),true);
        }
        while(scan.hasNextLine() == false){
            loadSentiment(scan.nextLine(),false);
        }
    }

    public String sentinalyze (String filename) throws FileNotFoundException {
        Scanner scan = new Scanner(filename);
        String[] words;

        int sent = 0;

        while(scan.hasNextLine()){
            words = scan.nextLine().trim().split(" ");
            for(int i = 0; i < words.length; i++){
                if(posHash.get(words[i]) != null){
                    sent++;
                }
                else if(negHash.get(words[i]) != null){
                    sent--;
                }
            }

        }

        if(sent > 0){
            return new String("positive");
        }
        else if(sent < 0){
            return new String("negative");
        }
        return new String("neutral");
    }


    // -----------------------------------------------------------
    // Helper Methods
    // -----------------------------------------------------------

    // TODO: add your helper methods here!

}
