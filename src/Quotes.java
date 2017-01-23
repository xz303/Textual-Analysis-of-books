/**
 * This is a method to retrieve all the quotations from the book
 * as well as count the frequency
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Quotes {
	// call FileReader class to read in the book data
	FileReader fl;
	ArrayList<String> arr;
	HashMap<String, Integer> quotation;
	
	public Quotes(){
		//initialize instance variables in constructor 
		fl = new FileReader("tale-of-two-cities.txt");	
		arr = new ArrayList<String>();
	}
	
	/**
	 * This is a method to retrieve all the quotations in the book;
	 * @return remove all the non-alphabetic symbols
	 */
	public HashMap<String, Integer> sparseData(){
	
		ArrayList<String> str = new ArrayList<String>();
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		
		arr = fl.getLines();
		
		for(int i = 0; i<arr.size(); i++){
		// using regex to match the pattern 	
			//Pattern p = Pattern.compile(".*\\\"(.*)\\\".*");
			Pattern p = Pattern.compile("\"([^\"]*)\"");
			Matcher m = p.matcher(arr.get(i));
			
			while(m.find()){
				m.group();
				// remove all the non-alphabetic symbols and split
				String [] a =m.group().replaceAll("[^\\w]", "").toLowerCase().split(" ");	
		// put the words and frequncy into a hashmap
			for(int j = 0; j< a.length; j++){
					
					list.put(a[j], a[j].length());
			}
		}
	}
		return list;
}
	/**
	 * This is a method to get the top 10 quotations
	 * @return
	 */
	
	public HashMap<String, Integer> getTop10(){
		
		HashMap<String, Integer> hm2 = sparseData();
ArrayList fq = new ArrayList<>();
		
		HashMap<String, Integer> top10 = new HashMap<String, Integer>();
		
		for(String key : hm2.keySet()){
			
				
			fq.add(hm2.get(key));
		
		}
		Collections.sort(fq);
     	Collections.reverse(fq);
     	
     	for(int i = 0; i<11; i++){
     		
     		for(String key : hm2.keySet()){
     		
     		if(hm2.get(key) == fq.get(i) && !key.equals(" ") ){
     			if (top10.size()<10){
     		 top10.put(key, hm2.get(key));
     				
     		}
     		}
     	}	
	}
		return top10;
	}
	/**
	 * This method is to get botom 10 quotations.
	 * @return
	 */
	
public HashMap<String, Integer> getBottom10(){
		
		HashMap<String, Integer> hm2 = sparseData();
ArrayList fq = new ArrayList<>();
		
		HashMap<String, Integer> Bottom10 = new HashMap<String, Integer>();
		
		for(String key : hm2.keySet()){
			
				
			fq.add(hm2.get(key));
		
		}
		Collections.sort(fq);
     	
     	for(int i = 0; i<11; i++){
     		
     		for(String key : hm2.keySet()){
     		
     		if(hm2.get(key) == fq.get(i) && !key.equals("") ){
     		if (Bottom10.size()<10){
     		 Bottom10.put(key, hm2.get(key));
   			
     		}
     	}	
     		}
	}
		return Bottom10;
	}
	
}
	
