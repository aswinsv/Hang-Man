/*
Author Name: Aswin ram S.V.

Creation Date: 07/14/2017

Modification Date: 07/14/2017

Description: 1) This class is used to start the game in automatic mode
			 2) Based on the number of players specified by the user, that many players are created
			 3) Based on the number of games specified by the user, that many games is played by the computer
			 4) The question for the game is read from the file specified by the user
			 5) This class is inherited from P2A3_SIVARAMANVENKATARAMAN_GAME_aswinras class
*/

import java.io.*;

import java.util.*;


public class P2A3_SIVARAMANVENKATARAMAN_AUTOPLAY_aswinras extends P2A3_SIVARAMANVENKATARAMAN_GAME_aswinras
{

	public P2A3_SIVARAMANVENKATARAMAN_AUTOPLAY_aswinras()
	{

	}

	/*

		Function Name: public void start()
		Description: 1) The function below overrides the start function in P2A3_SIVARAMANVENKATARAMAN_GAME_aswinras class
					 2)	The number of times, the game is to be played and the number of players is decided by the user
					 3) The input for each guess is provided by a random generator, which generates a character between (a-z)
					 4) The function below has overriden the start method of P2A3_SIVARAMANVENKATARAMAN_GAME_aswinras class

	*/				 

	@Override
	public void start()
	{
		
		System.out.println("\n\n****************************************************************************");

		System.out.println("Game Begins");

		System.out.println("****************************************************************************");

		String question_String=question.getQuestion();

		char answer;
		
		int playerGameEnded=0;

		Random r = new Random();
	
		resetPlayerValues();

		gameEnded=false;


		while(!gameEnded &&  playerGameEnded != numPlayers)
{
		


		for(int i=0;i<numPlayers;i++)
		{

			
			
			if(!players[i].getGameEnded())
		{



			question.display();

			answer=(char)(r.nextInt(26) + 'a');

			System.out.println(players[i].getName()+" guessed the character "+answer);


			
						int index=question_String.indexOf(answer);

						if(index >=0)
						{
							System.out.println("\nCongratulations,"+players[i].getName()+" you have won the round!!");

							question.updateInput(answer);

							if(question.getInput().equals(question_String))
							{
								gameEnded=true;

								System.out.println("Congratulations "+players[i].getName()+", you have won the game!!");

								System.out.println("\n The Secret word was:"+question_String+"\n");

								playerGameEnded++;

								break;
							}	

						}

						else
						{
							System.out.println(players[i].getName()+", Your guess was wrong!!");

							players[i].updateNumTicks();

							if(players[i].getBombColor().equals("purple"))
							{
								
								System.out.println("Bomb color: "+players[i].getBombColor());

								System.out.println("BOOM!!!");

								System.out.println("Game over for "+players[i].getName()+"\n");

								players[i].setGameEnded(true);

								playerGameEnded++;

								continue;


  					         }

  					        System.out.println(players[i].getName()+"'s bomb color: "+players[i].getBombColor());

							System.out.println(players[i].getName()+" has "+players[i].getNumGuesses()+" guesses left");

						}	
					}

					
					
			

		} // for loop


	}	// end of while	

	
 } // end of autoplay
} // end of public class


	