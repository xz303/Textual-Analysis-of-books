/**
 * This class is to get the top 10 most frequent used words in this book
 * FileReader class will be called to read in book data.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class WordFrequency {
	// instance variables. FileReader class will be called to read in book data.
	FileReader wordData;
	ArrayList<String> words;
	ArrayList<String> sparsedWords;

	public WordFrequency(){
		// initialize instance varibales.
		wordData = new FileReader("tale-of-two-cities.txt");
		words = new ArrayList<String>();
		sparsedWords = new ArrayList<String>();	
		
	}
	
	/**
	 * This is a method is to get a hashmap of all the words and 
	 * @return its frequency in the text.
	 */
	public HashMap<String, Integer> getHashMap(){
		HashMap <String, Integer> hm1 = new HashMap <String, Integer>();
		//get each line of the book and store it as an arrayList
		words = wordData.getLines();
	    
		for(int i =0; i<words.size(); i++){
			 
			String[] aLine = words.get(i).split(" ");
			
			for(int j = 0; j<aLine.length; j++){
				
				// convert all upper case to lower case & remove all non-alphabetic symbols;
					
				sparsedWords.add(aLine[j].toLowerCase().replaceAll("[^\\w]", ""));
			}
		}
		//put in key and value in hashmap
		for(int key = 0; key < sparsedWords.size(); key++){
			
			if (hm1.containsKey(sparsedWords.get(key))){
				int count = hm1.get(sparsedWords.get(key));
				hm1.put(sparsedWords.get(key), count + 1);
			}else{
				hm1.put(sparsedWords.get(key), 1);
			}
		}
		return hm1;
		   	
		}
/**
 * This method is to get the order of top 10 words
 * @return
 */
	
	public HashMap<String, Integer> getOrder(){
		
		HashMap<String, Integer> hm2 = getHashMap();
	
		ArrayList fq = new ArrayList<>();
		
		HashMap<String, Integer> top10 = new HashMap<String, Integer>();
		
		for(String key : hm2.keySet()){
			
			fq.add(hm2.get(key));
		}
		// use Collection to get the order of frequency
		Collections.sort(fq);
     	Collections.reverse(fq);
     	
     	for(int i = 0; i<11; i++){
     		
     		for(String key : hm2.keySet()){
     		// make sure the word not equals to balck space
     		if(hm2.get(key) == fq.get(i) && !key.equals("") ){
     			
     		 top10.put(key, hm2.get(key));
     				
     		}
     	}	
	}
		return top10;
	}
	}
	
