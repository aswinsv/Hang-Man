/*
Author Name: Aswin ram S.V.

Creation Date: 07/14/2017

Modification Date: 07/15/2017

Description: 1) This class is used to create Player objects
				
			 2) The player object has a field named name, which specifies his name
			 
			 3) The player object has a field name numTicks, which counts the number of wrong guesses he makes. 
			 If he makes 6 wrong guesses, he loses the game

			 4) The field gameEnded is used to check if the player is still in the game

			 5) Each player has a field which indicates his bombColor	
*/

public class P2A2_SIVARAMANVENKATARAMAN_PLAYER_aswinras
{
	String name;
	int numTicks=0;
	int totalGuesses=6;
	boolean gameEnded=false;
	String bombColor;

	public P2A2_SIVARAMANVENKATARAMAN_PLAYER_aswinras()
	{

	}

	public P2A2_SIVARAMANVENKATARAMAN_PLAYER_aswinras(String name,int numTicks,int totalGuesses,boolean gameEnded)
	{
		this.name=name;

		this.numTicks=numTicks;

		this.totalGuesses=totalGuesses;

		this.gameEnded=false;
	}

	/* 
		Function: public void resetValues()

		Description: After every game, especially in AutoPlay, we call this function to reset the fields of player

	*/	


	public void resetValues()
	{
		numTicks=0;
		totalGuesses=6;
		gameEnded=false;
		bombColor="";
	}

	/* 
		Function: public void setName()

		Description: We call this function to set name of the player

	*/	

	public void setName(String name)
	{
		this.name=name;
	}

	/* 
		Function: public void updateNumTicks()

		Description: After every wrong guess the player makes, we call this function to update the number of ticks 
					 for each player and the bomb color according to the number of ticks. 

	*/	

	public void updateNumTicks()
	{
		numTicks++;

		switch(numTicks)
		{
			case 1: {
				bombColor="red";
				break;
			}
			
			case 2: {
				bombColor="orange";
				break;
			}

			case 3: {
				bombColor="yellow";
				break;
			}

			case 4: {
				bombColor="green";
				break;
			}

			case 5: {
				bombColor="blue";
				break;
			}

			case 6: {
				bombColor="purple";
				break;
			}	
		}
	}

	/* 
		Function: public void setGameEnded()

		Description: We set the game status for a player using this function. 

	*/	

	public void setGameEnded(boolean flag)
	{
		gameEnded=flag;
	}

	/* 
		Function: public void setBombColor()

		Description: We set the bomb color for a player using this function. 

	*/	

	public void setBombColor(String color)
	{
		this.bombColor=color;
	}

	/* 
		Function: public String getName()

		Description: We get the name of player using this function. 

	*/	

	public String getName()
	{
		return name;
	}

	/* 
		Function: public String getnumTicks()

		Description: We get the number of ticks (i.e. number of wrong guesses) for a player. 

	*/	

	public int getnumTicks()
	{
		return numTicks;
	}

	/* 
		Function: int String getNumGuesses()

		Description: We get the number of guesses remaining for a player. 

	*/	

	public int getNumGuesses()
	{
		return (totalGuesses-numTicks);
	}

	/* 
		Function: public boolean getGameEnded()

		Description: We get to know if the game has ended for a player. 

	*/	

	public boolean getGameEnded()
	{
		return gameEnded;
	}

	/* 
		Function: public String getBombColor()

		Description: We get to know the bomb Color for a player. 

	*/

	public String getBombColor()
	{
		return bombColor;
	}
	
}