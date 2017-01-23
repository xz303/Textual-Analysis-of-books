/**
 * This is a class to count letter frequency and 
 * get the most frequent 10 letter s from this book
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LetterFrequency {
	private ArrayList<String> lines;
	FileReader readData;
	private HashMap<Character, Integer> hm;
	ArrayList<Character> sparse;
	
	public LetterFrequency(){
		lines = new ArrayList<String>();
		readData = new FileReader("tale-of-two-cities.txt");	
		hm = new HashMap<>();
		sparse = new ArrayList<Character>();
	}
	
	/**
	 * This is a method to get a hashmap with key as characters and values as frequency
	 * @return
	 */
public ArrayList<Character> sparse(){
		
		lines = readData.getLines();
		
		 for(int i = 0; i< lines.size(); i++){
			   
			 //Store each line as a string.
			   String eachLine = lines.get(i);
			 //split each character and symbols and store them into an String array.
			   String [] aLine = eachLine.split("\\s+");
			   
			   for(int j = 0; j<aLine.length;j++){
		     //remove all symbols and convert characters to lower case.
		     //convert each string to characters.
		       char [] characters = aLine[j].replaceAll("[^\\w]", "").toLowerCase().toCharArray();
			   
		       for(int m = 0; m< characters.length; m++){
		    	   
		    	   sparse.add(characters[m]);
		       }   
	       }
		 }
		 //return an ArrayList of sparsed data --all of them are lowercase characters.
		return sparse;
}
	      
public HashMap<Character, Integer> getFrequency(){
	
	sparse();
	  
	for (int i = 0; i < sparse.size(); i++){
		if (hm.containsKey(sparse.get(i))){
			int count = hm.get(sparse.get(i));
			hm.put(sparse.get(i), count + 1);
		}else{
			hm.put(sparse.get(i), 1);
		}
	}
	return hm;
	   
   }
/**
 * This is a method to get the 10 most frequent letters from this book.
 * @return
 */

public HashMap<Character, Integer> getOrder(){

	HashMap<Character, Integer> order = getFrequency();
	HashMap<Character, Integer> list = new HashMap<Character, Integer>();
	
	ArrayList<Integer> fq = new ArrayList<>();

	
	for(char key:order.keySet()){
		
		fq.add(order.get(key));
		
	}

	Collections.sort(fq);
	Collections.reverse(fq);
	
	for(int i = 0; i<10; i++){
		
		for(char key:order.keySet()){
		
		if(fq.get(i)==order.get(key)){
	
				list.put(key, order.get(key));
				
			}		
		
		}
		
	}
	
	return list;
}

}

