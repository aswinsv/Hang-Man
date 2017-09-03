/*
Author Name: Aswin ram S.V.

Creation Date: 07/14/2017

Modification Date: 07/15/2017

Description: 1) The purpose of this class is to start ChipARoonie game in manual mode
			 2)	We can create a set of players who are going to play this game in this class
			 3) We can read a file specified by the user and set question for the game.
			 4) It displays instructions for the game
*/

import java.io.*;

import java.util.*;


public class P2A3_SIVARAMANVENKATARAMAN_GAME_aswinras
{

	List<String> lines = new ArrayList<String>();

	// Each game has a question object in it

	P2A3_SIVARAMANVENKATARAMAN_QUESTION_aswinras question=new P2A3_SIVARAMANVENKATARAMAN_QUESTION_aswinras();

	// Each game is played by a set of players

	P2A3_SIVARAMANVENKATARAMAN_PLAYER_aswinras[] players;

	String fileName;

	int numPlayers;

	boolean gameEnded;

	public P2A3_SIVARAMANVENKATARAMAN_GAME_aswinras()
	{

	}

	/*
		Function Name: public void setFileName()

		Description: 1) The function below is used to set the filename, from which we are going to set the question for game.

					 2) The filename has to be INPUTFILE.txt, otherwise the program will throw an error.

	*/


	public void setFileName()
	{
		Scanner sc=new Scanner(System.in);

		boolean correctFileName=false;

				while(!correctFileName)
			 {		
				System.out.println("Enter the filename to be used as input file name along with Extension:");

				fileName=sc.nextLine();

				if(fileName.equals("INPUTFILE.txt"))
					correctFileName=true;
				
				else
				
					System.out.println("\n Please enter the correct filename (Hint: INPUTFILE.txt)!!");
					

			}	
		
	}

	/*
		Function Name: public void setNumPlayers()

		Description: 1) The function below is used to set the number of players who are going to play the game.

					 2) The number of players in the game has to be a number between 1-5.

	*/

	public void setNumPlayers()
	{

		Scanner sc=new Scanner(System.in);

		boolean correctInput=false;

		while(!correctInput)
		{
			System.out.println("Enter the number of players");

			numPlayers=sc.nextInt();

			if(numPlayers<=0 || numPlayers > 5)
			{
				System.out.println("Please enter a valid number of players (Between 1-5)");
			}	

			else 
		  {
			this.players=new P2A3_SIVARAMANVENKATARAMAN_PLAYER_aswinras[numPlayers];

			correctInput=true;
		  }
	    }	

		

	}	


	/*
		Function Name: public void createQuestion()

		Description: 1) The function below is used to set question for the game.

					 2) It reads a random line from the file name specified and extracts the question and hint from it.

	*/
		
		

	public void createQuestion()
	{
		String line=getRandomLine();

		String[] questionContent = line.split(",");

		question.setQuestion(questionContent[0]);

		question.setHint(questionContent[1]);

		question.setInput(questionContent[0]);

	}

	/*
		Function Name: public void displayInstructions()

		Description: The function below is used to display rules for the game.

	*/


	public void displayInstructions()
	{
		System.out.println("****************************************************** INSTRUCTIONS **************************************************************************************************************************************");
		System.out.println("1) If the guessed letter is contained in the secret word, the player has won that round, and the guessed word thus far is printed (consisting of blank underscores and corrrectly guessed letters).");

		System.out.println("2) If the player's guessed letter is not in the secret word, the guessed word thus far is printed (consisting of blank underscores and any correctly guessed letters), and the player earns a tick.");

		System.out.println("\t2.1) The ticks add up. A player can only accumulate 6 incorrect ticks or he loses the game and the bomb goes off.");

		System.out.println("\t2.2) For each round that the player guesses a letter incorrectly, you should also print out the color that the player has failed thus far, based on how many ticks the player has:");

		System.out.println("\t\t2.2.1) Each tick will correspond to the bomb exploding sooner, for each incorrectly guessed letter:");

		System.out.println("\t\t\t2.2.1.1) 1 tick = red");

		System.out.println("\t\t\t2.2.1.2) 2 ticks = orange");

		System.out.println("\t\t\t2.2.1.3) 3 ticks = yellow");		

		System.out.println("\t\t\t2.2.1.4) 4 ticks = green");

		System.out.println("\t\t\t2.2.1.5) 5 ticks = blue");

		System.out.println("\t\t\t2.2.1.6) 6 ticks = purple BOOM!!!");

		System.out.println("\n The player wins by guessing all of the correct letters in the secret word.");
		System.out.println("\n When the player wins the game, you should print to the console that he has won, along with the secret word \n");

		System.out.println("***************************************************************************************************************************************************************************************");


	}

	/*
		Function Name: public void getRandomLine()

		Description: The function below is used to display rules for the game.

	*/


	public String getRandomLine()
	{
			Random r = new Random();
			String randomLine = lines.get(r.nextInt(lines.size()));

			return randomLine;
				
	}

	/*
		Function Name: public void readFile()

		Description: The function below is used to read content from a file and store it in a arraylist.

	*/

	public void readFile()
	{
		try
		{
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				String line = reader.readLine();

				while (line != null) {
				     lines.add(line);
				     line = reader.readLine();
				}

		}

			catch(IOException ex)
			{
				System.out.println("Please enter the correct filename: INPUTFILE.txt");
			}			
				
				
	}

	/*
		Function Name: public void createPlayers()

		Description: The function below is used to specify number of players who are going to play this game.

	*/

	public void createPlayers()
	{
		String name;

		Scanner sc=new Scanner(System.in);

		for(int i=0;i<numPlayers;i++)
		{
			players[i]=new P2A3_SIVARAMANVENKATARAMAN_PLAYER_aswinras();

			System.out.println("\nPlease enter the player name:\n");

			name=sc.next();

			players[i].setName(name);
		}	
	}

	/*
		Function Name: public void resetPlayerValues()

		Description: The function below is used to reset the values of players before new game starts.

	*/

	public void resetPlayerValues()
	{
		for(int i=0;i<numPlayers;i++)
		{
			players[i].resetValues();
		}	
	}

	/*
		Function Name: public void start()

		Description: The function below is used to start the game.

	*/


	public void start()
	{
		System.out.println("\n\n****************************************************************************");

		System.out.println("Game Begins");

		System.out.println("****************************************************************************");

		String question_String=question.getQuestion();

		

		Scanner sc=new Scanner(System.in);

		String answer;

		
		int playerGameEnded=0;



		while(!gameEnded &&  playerGameEnded != numPlayers)
{
		for(int i=0;i<numPlayers;i++)
		{
			
			if(!players[i].getGameEnded())
		{	

			question.display();

			System.out.println("Hello "+players[i].getName()+", guess a character or the entire word");

			answer=sc.nextLine();

			
				if(answer.length()!=1 && answer.length()!=question_String.length())
				{
						System.out.println("Please enter either a character or length of whole word as input");

						players[i].updateNumTicks();

							
						if(players[i].getBombColor().equals("purple"))
						{
								System.out.println("Bomb color: "+players[i].getBombColor());

								System.out.println("BOOM!!!");

								System.out.println("Game is over!!");

								players[i].setGameEnded(true);

								playerGameEnded++;

								continue;

				        }

				        System.out.println(players[i].getName()+"'s bomb color: "+players[i].getBombColor());

						System.out.println(players[i].getName()+" has "+players[i].getNumGuesses()+" guesses left");
				    }    	

				else
				{
					if(answer.length()==1)
					{
						int index=question_String.indexOf(answer.charAt(0));

						int index_Input=question.getInput().indexOf(answer.charAt(0));

						if(index >=0 && index_Input < 0)
						{
							System.out.println("\nCongratulations, You got the letter right!!");

							question.updateInput(answer.charAt(0));

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
							System.out.println("\n You were wrong!!");

							players[i].updateNumTicks();

							if(players[i].getBombColor().equals("purple"))
							{
								
								System.out.println("Bomb color: "+players[i].getBombColor());

								System.out.println("BOOM!!!");

								System.out.println("Game is over!!");

								players[i].setGameEnded(true);

								playerGameEnded++;

								continue;


  					         }

  					        System.out.println(players[i].getName()+"'s bomb color: "+players[i].getBombColor());

							System.out.println(players[i].getName()+" has "+players[i].getNumGuesses()+" guesses left");

						}	
					}

					else
					{
						if(answer.equals(question_String))
						{
							System.out.println("Congratulations "+players[i].getName()+", you have won the game!!");

							System.out.println("\n The Secret word was:"+question_String+"\n");

							gameEnded=true;

							playerGameEnded++;

							break;
						}

						else
					{
							System.out.println("\n You were wrong!!");

							players[i].updateNumTicks();

							
						if(players[i].getBombColor().equals("purple"))
						{
								
								System.out.println("Bomb color: "+players[i].getBombColor());

								System.out.println("BOOM!!!");

								System.out.println("Game is over!!");

								players[i].setGameEnded(true);

								playerGameEnded++;

								continue;
						}	

							System.out.println(players[i].getName()+"'s bomb color: "+players[i].getBombColor());
							System.out.println("You have "+players[i].getNumGuesses()+" left");
				   }		
				   }	
				}	
					
			

		} // if loop


	}	// end of for	
} // end of while
} // end of start function

}

