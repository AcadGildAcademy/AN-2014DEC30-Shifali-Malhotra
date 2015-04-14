/**
 * 
 */
package exercise1;

import java.io.DataInputStream;

/**
 * @author abc
 *
 */
public class votecheck {
		
			/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args)

	{
		// TODO Auto-generated method
		DataInputStream in=new DataInputStream(System.in);
		int age=0;
			try{
		
				System.out.println("enter the age of person");
				age=Integer.parseInt(in.readLine());
				}		
			catch(Exception e)
			{
			}
			if(age>=18)
			{
				System.out.println("Elegible for voting");
			}
			else
			{
				System.out.println("Not Elegible");
			}
			}
	}
	
