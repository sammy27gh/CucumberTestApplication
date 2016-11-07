package cs520.hw1.part2;

import java.util.*;
public class OddNumbers
{

	public static void main(String[] args) 
	{
		int num1, num2, num3; 
		for(num1 =1; num1<100; num1++)
		{
	    	for(num2=1;num2<100; num2++)
	    	{
	    		for(num3=1;num3<100; num3++)
		    	{
	    			int a= num1, b=num2, c=num3;
	    			if((Math.sqrt(a) + Math.sqrt(b))==Math.sqrt(c))
		    		{
	    				if(a<b)
	    				{
	    					System.out.println(num1 +"  "+ num2 +"   "+ num3);
	    				}
		    		}
		    	}
	    	}
	    
	    	
			
		}

		
	}

}
