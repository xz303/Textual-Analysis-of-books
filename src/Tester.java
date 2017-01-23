/**
 * This is a tester to print out all the answers to the questions.
 */

import java.util.HashMap;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//call the classes with method.
		
        LetterFrequency l = new LetterFrequency();
        WordFrequency a = new WordFrequency();
        StopList s = new StopList();
        Quotes q = new Quotes();
        WildCard w = new WildCard();
        
        System.out.println("The top-10 most frquent letters in this book are: ");
        HashMap<Character,Integer>newHm1 = l.getOrder();
	
            for (char key:newHm1.keySet()){
		
             System.out.println(key);
             System.out.println(newHm1.get(key));
	      }
    
            
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX ");       
            
        System.out.println("The top-10 most frequent words in this book are: ");
            
        HashMap<String,Integer>newHm = a.getOrder();
		
			for (String key:newHm.keySet()){
				System.out.println(key);
				System.out.println(newHm.get(key));
		
		 }
			
	    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX "); 
        
        System.out.println("The top-10 most frequent words excluding stoplist words in this book are: ");
        HashMap<String,Integer>newHm8 = s.getOrder();
        
                    for (String key:newHm8.keySet()){       		
                     System.out.println(key);
                     System.out.println(newHm8.get(key));
        	      }
                    
      System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX "); 
            
	    
	    System.out.println("The top-10 shortest quotations in this book are: ");
	    
      HashMap<String,Integer>newHm2 =  q.getBottom10();
      for(String key: newHm2.keySet()){     	
      	System.out.println(key);
      	System.out.println(newHm2.get(key));
      }
      
      System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX "); 
      
      System.out.println("The top-10 longest quotations in this book are: ");
      
      HashMap<String,Integer>newHm3 =  q.getTop10();
      for(String key: newHm3.keySet()){     	
      	System.out.println(key);
      	System.out.println(newHm3.get(key));
      }
	    
      System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX "); 
      
      System.out.println("The top-10 words in quotations being used most are: ");
      HashMap<String,Integer>newHm5 = w.getOrder();
       for(String key: newHm5.keySet()){
		System.out.println(key);
        System.out.println(newHm5.get(key));
        }  
	}
}


