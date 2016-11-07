package rest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Details {

	   public static void main(String args[]) {

	      /* This is how to declare HashMap */
	      HashMap<Integer, String> hmap = new HashMap<Integer, String>();

	      /*Adding elements to HashMap*/
	      hmap.put(12, "Chaitanya");
	      hmap.put(2, "Rahul");
	      hmap.put(7, "Singh");
	      hmap.put(49, "Ajeet");
	      hmap.put(3, "Anuj");

	      /* Display content using Iterator*/
	      Set set = hmap.entrySet();
	      System.out.println(set);
	      
	      if (hmap.get(12)==("Chaitanya")){
	    	  
	    	  System.out.println(set);
	      }else{
	        System.out.println("Dont worry about it.");
	      }
	      
	      System.out.println(hmap.get(12));
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
	         System.out.println(mentry.getValue());
	      }
}
}