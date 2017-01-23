import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class will answer this question:
 * What are the top-10 words in quotations being used most in tale-of-two_cities?
 * @author zhangxiang
 *
 */
public class WildCard {
// call the FileReader to read in book data.
	FileReader fl;
	ArrayList<String> arr;
	HashMap<String, Integer> quotation;
	
	public WildCard(){
		// initialize instance variables in constructor
		fl = new FileReader("tale-of-two-cities.txt");	
		arr = new ArrayList<String>();
	}
/**
 * This is a method to sparse data to get quotations using regex.
 * @return Will return a hashmap with the quotation as key and frquency as value;
 */
	public HashMap<String, Integer> sparseData(){
		
		ArrayList<String> str = new ArrayList<String>();
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		
		arr = fl.getLines();
		for(int i = 0; i<arr.size(); i++){
			//Pattern p = Pattern.compile(".*\\\"(.*)\\\".*");
			Pattern p = Pattern.compile("\"([^\"]*)\"");
			// "\"([^\"]*)\""
			Matcher m = p.matcher(arr.get(i));
			
			while(m.find()){
				
				m.group();
				
				String [] a =m.group().toLowerCase().split(" ");
		
			for(int j = 0; j< a.length; j++){
					
					list.put(a[j], a[j].length());
			}
		}
	}
		return list;
}
	/**
	 * This is a method to get the top 10 frequent used words in quotation.
	 * @return
	 */
public HashMap<String, Integer> getOrder(){
		
		HashMap<String, Integer> hm2 = sparseData();
	
		ArrayList fq = new ArrayList<>();
		
		HashMap<String, Integer> top10 = new HashMap<String, Integer>();
		
		for(String key : hm2.keySet()){	
			fq.add(hm2.get(key));
		
		}
		//using Collection to sort the frequency.
		Collections.sort(fq);
		// reverse it to get decreasing order.
     	Collections.reverse(fq);
     	
     	for(int i = 0; i<11; i++){
     		
     		for(String key : hm2.keySet()){
     		
     		if(hm2.get(key) == fq.get(i) && !key.equals("") ){
     			// make sure the size is less than 10.
     			if(top10.size()<11){
     			
     		 top10.put(key, hm2.get(key));
     				
     		}
     	}	
	}
     	}
		return top10;
	}
}

	
	
	
