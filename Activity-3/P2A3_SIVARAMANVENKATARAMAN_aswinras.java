/*
Author Name: Aswin ram S.V.

Creation Date: 07/14/2017

Modification Date: 07/14/2017

Description: 1) The below function gives choice to the user to choose between automatic mode or manual mode
			 2) For each mode the user is able to provide the number of players, the file name which act as source of questions
			  for the game	
			 3) The main difference in autoplay mode is that, the user can also specify the number of times the computer has
			 to play the game. 
*/

import java.util.*;

import java.io.*;



public class P2A3_SIVARAMANVENKATARAMAN_aswinras
{
	public P2A3_SIVARAMANVENKATARAMAN_AUTOPLAY_aswinras auto=new P2A3_SIVARAMANVENKATARAMAN_AUTOPLAY_aswinras();

	public P2A3_SIVARAMANVENKATARAMAN_GAME_aswinras game=new P2A3_SIVARAMANVENKATARAMAN_GAME_aswinras();



	public  P2A3_SIVARAMANVENKATARAMAN_aswinras()
	{
		
	}



	public static void main(String[] args)
	{

		P2A3_SIVARAMANVENKATARAMAN_aswinras activity3=new P2A3_SIVARAMANVENKATARAMAN_aswinras();

		String mode=new String();

		int num;

		boolean correctMode=false;

		boolean correctCount=false;

		Scanner sc=new Scanner(System.in);

		while(!correctMode)
	{	
		System.out.println("Please enter the mode you want to play in!! (manual or automatic)");

		mode=sc.nextLine();

		if(mode.equals("manual") || mode.equals("automatic"))
			correctMode=true;
		else
			System.out.println("\n Please enter a valid mode \n");			
	}	

		


		switch(mode)
		{
			
			case "manual" : {

				//P2A3_SIVARAMANVENKATARAMAN_GAME_aswinras game=new P2A3_SIVARAMANVENKATARAMAN_GAME_aswinras();

				activity3.game.displayInstructions();

				activity3.game.setFileName();

				activity3.game.readFile();

				activity3.game.createQuestion();

				activity3.game.setNumPlayers();

				activity3.game.createPlayers();

				activity3.game.start();
						
				break;
			}

			case "automatic" : {

				//P2A3_SIVARAMANVENKATARAMAN_AUTOPLAY_aswinras auto=new P2A3_SIVARAMANVENKATARAMAN_AUTOPLAY_aswinras();

				activity3.auto.displayInstructions();

				activity3.auto.setFileName();

				activity3.auto.setNumPlayers();

				activity3.auto.createPlayers();

				while(!correctCount)
			{		
				System.out.println("Enter the number of times you want the computer to play?");

				int count=sc.nextInt();

				if(count<=0)
					System.out.println("Please enter a count >= 1");
				
				else	
			{		
				int current=1;

				while(current<=count)
				{
					activity3.auto.readFile();
					activity3.auto.createQuestion();
					activity3.auto.start();
					current++;

				}

				correctCount=true;
			}	
		}		

				break;
			}

			
		}
	}
}