
package cs520.hw1.part1;
import java.util.Scanner;
public class Banking {

	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int num; 
		System.out.println("please enter any number within range of 1 to 999");
	    num = in.nextInt();
	    System.out.println("Requested Amount = " + num);
		int hundred=0, fifty=0, tweenty=0, ten=0, five =0, two =0, one = 0, rem=0;
		if(num>99)
		{
		for(int i=1; i<num; i++)
		{
			
				hundred++;
				rem = num%100;
				hundred = num /100;
				
		}
		}
		System.out.println("Hundreds = "+hundred + "  Remaining Amount = " + rem);
		num = rem;
		if(num>49)
		{
		for(int i=1; i<num; i++)
		{
			
				fifty++;
				rem = num%50;
				fifty = num /50;
				
		}
		}
		System.out.println("Fifties = "+fifty + "  Remaining Amount = " + rem);
		num = rem;
		if(num>19)
		{
		for(int i=1; i<num; i++)
		{
			
				tweenty++;
				rem = num%20;
				tweenty = num /20;
				
		}
		}
		System.out.println("Twenties = "+tweenty + "  Remaining Amount = " + rem);
		num = rem;
		if(num>9)
		{
		for(int i=1; i<num; i++)
		{
			
				ten++;
				rem = num%10;
				ten = num /10;
				
		}
		}
		System.out.println("Tens = "+ten + "  Remaining Amount = " + rem);
		num = rem;
		if(num>4)
		{
		for(int i=1; i<num; i++)
		{
			
				five++;
				rem = num%5;
				five = num /5;
				
		}
		}
		System.out.println("Fives = "+five + "  Remaining Amount = " + rem);
		num = rem;
		if(num>2)
		{
		for(int i=1; i<num; i++)
		{
			
				two++;
				rem = num%2;
				two = num /2;
				
		}
		}
		System.out.println("Twos = "+two + "  Remaining Amount = " + rem);
		num = rem;
		for(int i=0; i<num; i++)
		{
			
				one++;
				
		}
		
		System.out.println("Ones = "+one);
	}

}
