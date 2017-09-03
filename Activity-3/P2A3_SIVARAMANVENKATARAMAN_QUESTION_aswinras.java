/*
Author Name: Aswin ram S.V.

Creation Date: 07/14/2017

Modification Date: 07/15/2017

Description: 1) The below class is used to create the question object which is needed to play the game
			 2)	Each question has a question and a hint attached to it.
			 3) We also use a string builder named input, which used to display the letters guessed by the players so far.
*/
public class P2A3_SIVARAMANVENKATARAMAN_QUESTION_aswinras
{
	String question;

	String hint;

	StringBuilder input=new StringBuilder();

	public P2A3_SIVARAMANVENKATARAMAN_QUESTION_aswinras()
	{

	}

	

	public P2A3_SIVARAMANVENKATARAMAN_QUESTION_aswinras(String question,String hint)
	{
		this.question=question;

		this.hint=hint;
	}
	
	/* 
		Function Name: public void setQuestion(String question)

		Description: The below function is used to set the source for question
	*/

	public void setQuestion(String question)
	{
		this.question=question;
	}

	/* 
		Function Name: public void setHint(String hint)

		Description: The below function is used to set hint for the question
	*/

	public void setHint(String hint)
	{
		this.hint=hint;
	}

	/* 
		Function Name: public String getQuestion()

		Description: The below function is used to fetch the question
	*/

	public String getQuestion()
	{
		return question;
	}

	/* 
		Function Name: public String getHint()

		Description: The below function is used to fetch the hint for question
	*/

	public String getHint()
	{
		return hint;
	}


	/* 
		Function Name: public void setInput(String question)

		Description: 1) The below function is used to set the input, which displays question in form of dashes to the user.

					 2)  The Number of dashes displayed depends on the length of the question 		
	*/

	public void setInput(String question)
	{
		input.setLength(0);
		
		for(int i=0;i<question.length();i++)
		{
			input.append('_');
		}

	}

	/*
	Function Name: public void updateInput(char c)

		Description: After every input provided by user, the content of input is varied by this function, depending on whether
					 the character is present in the question. 	
	*/

	public void updateInput(char c)
	{
		for(int i=0;i<input.length();i++)
	    {
	    	if(question.charAt(i)==c && input.charAt(i)=='_')
	    		input.setCharAt(i,c);
	    }	
		  	
	}

	/* 
		Function Name: public String getInput()

		Description: The below function is used to get the input provided by the user so far.
	*/

	public String getInput()
	{
		return input.toString();
	}	

	/* 
		Function Name: public void display()

		Description: The below function is used to display the question along with hint.
	*/

	public void display()
	{

		System.out.print("Question:\t");

		for(int j=0;j<input.length();j++)
		{
			System.out.print(input.charAt(j)+"\t");
		}	

		System.out.print("\n");	

		System.out.println("\nHint:"+hint);

		
	}
}