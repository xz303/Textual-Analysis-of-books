import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class StopList {

	FileReader stopListData;
	ArrayList<String> stopList;
	WordFrequency words;
	HashMap<String, Integer> hm1;

	public StopList() {

		stopListData = new FileReader("stop-list.txt");
		stopList = new ArrayList<String>();
		words = new WordFrequency();
		hm1 = new HashMap<String, Integer>();
	}

	
	public HashMap<String, Integer> getNewHashMap() {
		// read the "stop-list" file and store each line(word) into an arraylist.
		stopList = stopListData.getLines();
		// call the getHashMap() method, getting a hashmap of key = word, value = frequency.
		HashMap<String, Integer> hm = words.getHashMap();
		
		for (String key : hm.keySet()) {
			
			if(!stopList.contains(key)) {
				hm1.put(key, hm.get(key));
			}
			}
			

		return hm1;
	}
	
public HashMap<String, Integer> getOrder(){
		
		HashMap<String, Integer> hm2 = getNewHashMap();
	
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

