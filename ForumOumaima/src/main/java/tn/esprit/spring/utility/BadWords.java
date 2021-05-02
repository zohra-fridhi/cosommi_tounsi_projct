package tn.esprit.spring.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
@Service
public class BadWords {
	// this Array will continue the list of bad word read  from csv file 
	 static ArrayList<String> words = new ArrayList<String>();
	 
	    
	    static int largestWordLength = 0;
	    
	   // this method extract the bad word from the csv file and save them in the ArrayList
	    public static void loadConfigs() { 
	        try {
	            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream( ResourceUtils.getFile("classpath:Word_Filter.csv"))));
	            String line = "";
	            int counter = 0;
	            while((line = reader.readLine()) != null) {
	                counter++;
	                String[] content = null;
	               
	                    content = line.split(",");
	                    if(content.length == 0) { // ligne vide
	                        continue;
	                    }
	                   
	                    String word=content[0]; //1ere colonne
						if(word.length() > largestWordLength) { // but savoir le largestWordLength
	                        largestWordLength = word.length();
	                    }
	                    words.add(word.replaceAll(" ", ""));

	                
	            }
	            System.out.println("Loaded " + counter + " words to filter out");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }


	    /**
	     * Iterates over a String input and checks whether a bad word was found in a list,
	     *  then checks if the word should be ignored 
	     */
	     
	    public static ArrayList<String> badWordsFound(String input) {
	        if(input == null) {
	            return new ArrayList<>();
	        }
	        
	        input = input.replaceAll("1","i");
	        input = input.replaceAll("!","i");
	        input = input.replaceAll("3","e");
	        input = input.replaceAll("4","a");
	        input = input.replaceAll("@","a");
	        input = input.replaceAll("5","s");
	        input = input.replaceAll("7","t");
	        input = input.replaceAll("0","o");
	        input = input.replaceAll("9","g");
	        

	        ArrayList<String> badWords = new ArrayList<>();
	        input = input.toLowerCase().replaceAll("[^a-zA-Z]", "");

	        // iterate over each letter in the word 
	        for(int start = 0; start < input.length(); start++) { //compteur 1 in first letter and offset incriment
	            // from each letter, keep going to find bad words until either the end of the sentence is reached, or the max word length is reached. 
	            for(int offset = 1; offset < (input.length()+1 - start) && offset < largestWordLength; offset++)  {
	                String wordToCheck = input.substring(start, start + offset);
	                if(words.contains(wordToCheck)) {
	                        badWords.add(wordToCheck);
	                }
	            }
	        }
	        for(String s: badWords) {
	            System.out.println(s + " qualified as a bad word ");
	        }
	        return badWords;

	    }

	    public static String filterText(String input) throws BadWordException {
	        ArrayList<String> badWords = badWordsFound(input);
	        if(badWords.size() > 0) {
				for (String s : badWords) {
					input = input.replaceAll(s, s.replaceAll(".", "*"));
				}
			}
	        return input;
	    }
}
