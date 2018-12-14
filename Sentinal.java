//package sentinal;

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
        //File filey = new File(filename);
        File myFile = new File(filename);
        Scanner scan = new Scanner(myFile);

        while(scan.hasNextLine() == true){
            loadSentiment(scan.nextLine(),positive);
        }
    }

    public String sentinalyze (String filename) throws FileNotFoundException {
        File myFile = new File(filename);
        Scanner scan = new Scanner(myFile);
        String[] words;

        int sent = 0;

        while(scan.hasNextLine()){
            String line = scan.nextLine();
            words = line.trim().split(" ");
            String[] current;
            for(int k = 0; k <= posHash.longestLength();k++){
                current = getLonger(words,k);
                for(int i = 0; i < current.length; i++){
                    if(posHash.get(current[i]) != null){
                        sent++;
                    }

                }
            }
            for(int k = 0; k <= negHash.longestLength();k++){
                current = getLonger(words,k);
                for(int i = 0; i < current.length; i++){
                    if(negHash.get(current[i]) != null){
                        sent--;
                    }

                }
            }



        }

        System.out.println(sent);

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
    private String[] getLonger(String[] original, int grouping){
        String[] arrWords = new String[original.length-grouping];
        for(int i = 0; i < arrWords.length;i++){
            arrWords[i] = original[i+grouping];
        }
        return arrWords;
    }
}
