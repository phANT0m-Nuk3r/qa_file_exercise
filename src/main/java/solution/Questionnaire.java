package solution;

import java.io.*;
import java.util.Scanner;

public class Questionnaire {

	public static void main(String[] args) throws IOException {

		String fileName = "Results.txt";
		// will need to change first part per machine
		String directoryPath = "C:\\LABS\\14_Working_With_Files\\src\\Resources\\";

		String fullFileName = directoryPath + fileName;
		retrieveData(fullFileName);

		System.out.println("***************************");

		
		int locationofDot = fullFileName.indexOf('.');
		String newFileName = fullFileName.substring(0,locationofDot)+".dat";
		retrieveAndCopyData(fullFileName, newFileName);

		System.out.println("***************************");

		editAndSaveData(fullFileName, newFileName);
		

	}

	static void retrieveData(String fullFileName) throws IOException {
		String name;
		String questionnaireDate;
		String answers;
		BufferedReader bfr = new BufferedReader(
				new FileReader(fullFileName));

		name = bfr.readLine();
		while (name != null) {
			questionnaireDate = bfr.readLine();
			answers = bfr.readLine();

			System.out.printf(
					"%s sat test on %s and gave following responses: %s\n", name,
					questionnaireDate, answers);

			name = bfr.readLine();
		} // end while
		bfr.close();

	} // end 'RetrieveData'

	static void retrieveAndCopyData(String fullFileName, String newFileName)
			                                       throws IOException {
		String name, questionnaireDate, answers;
		BufferedReader bfr = new BufferedReader(
				              new FileReader(fullFileName));
		BufferedWriter bfw = new BufferedWriter(
				              new FileWriter(newFileName));

		name = bfr.readLine();
		while (name != null) {

			questionnaireDate = bfr.readLine();
			answers = bfr.readLine();

			System.out.printf(
					"%s sat test on %s and gave following responses: %s\n",
					name, questionnaireDate, answers);

			bfw.write(name + "\n");
			bfw.write(questionnaireDate + "\n");
			bfw.write(answers + "\n");

			name = bfr.readLine();
		}
		bfr.close();
		bfw.close();

	} // end of 'RetrieveAndCopyData'

	static void editAndSaveData(String fullFileName, String newFileName) 
	throws IOException
	{
		boolean found = false;
		String name = null,questionnaireDate = null,answers = null;

		System.out.println("Who's data would you like to edit?");
		
		

		BufferedReader bfr = new BufferedReader(
				              new FileReader(fullFileName));

		
		BufferedWriter bfw = new BufferedWriter(
				              new FileWriter(newFileName));
		
		Scanner s = new Scanner(System.in);
		String nameToFind = s.nextLine();
		// get next name
		name = bfr.readLine();
		while (name != null) {
			// if match
			if (name.equals(nameToFind)) {
				found = true;
				questionnaireDate = bfr.readLine();
				System.out.println("Which answer between 1 and 10 would you like to edit?");
				String sAnswerToEdit = s.nextLine();
				int answerToEdit = Integer.parseInt(sAnswerToEdit);

				answers = bfr.readLine();
				char[] answerArray = answers.toCharArray();

				answerToEdit--;
				if (answerToEdit >= 0 && answerToEdit < answers.length()) {
					System.out.printf("Current Value is %s\n",
							answers.charAt(answerToEdit));
					System.out.println("Enter your new answer?");
					String answer = s.nextLine();
					char[] chars = new char[] { 'T', 'F' };
					
					
					if (answer.toUpperCase().indexOf(chars[0]) != -1
					 || answer.toUpperCase().indexOf(chars[1]) != -1) {
						
						char newVal;
						if (answer.length() == 1)
						{
							newVal = answer.charAt(0);
							answerArray[answerToEdit] = newVal;
							answers = new String(answerArray);
							System.out.printf("%s sat the test on %s and gave the following responses: %s\n",
											name, questionnaireDate, answers);

						}
						else // answer not a single char
						{
							System.out.println("answer must be a single character");

						}
					}
					else // char not 'T' or 'F'
					{
						System.out.println("answer must be a 'T' or and 'F'");
					}
				}
				else // didn't type 1-10
				{
					System.out.println("number is out of range");
				}
			}
			else 
			{ // not a match 
		      // get persons next 2 lines 
			  // for write out before moving on 
			  // to next name searching for match
				questionnaireDate = bfr.readLine();
				answers = bfr.readLine();
			}
			// write out this person
			bfw.write(name + "\n");
			bfw.write(questionnaireDate + "\n");
			bfw.write(answers + "\n");

			name = bfr.readLine();
		} // end of while
		bfr.close();
		bfw.close();
		if (!found) {
			System.out.printf("%s not found\n", nameToFind);
		}
	} // end of 'EditAndSaveData'
} // end class