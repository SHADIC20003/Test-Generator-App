/*import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
 
class Main{
	 private static final String filepath="inputTest.txt";
	 private static final String filepath2="stats.txt";
	 //remember to change the path and just leave the name 
	 
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			
			System.out.println("press 1 if you want to create a test bank or add questions ");
			System.out.println("press 2 to take a test ");
			
			int x=input.nextInt();
			ArrayList<Question> questions = new ArrayList<>();
		if(x==1) {

			System.out.println("how many questions will you enter");
			int numOfQuestions = input.nextInt();

			fillArrayList_TestBank(questions, numOfQuestions);


			try {
				FileOutputStream writeData = new FileOutputStream(filepath);
				ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

				writeStream.writeObject(questions);
				writeStream.flush();
				writeStream.close();

			} catch (IOException e1) {
				e1.printStackTrace();

			}

		}
				/*System.out.println("enter 0 if you want to take a test");
				int y=input.nextInt();
				
				if(y==0) 
					Exam(filepath);*/
/*try {
					
					BufferedWriter bw = new BufferedWriter(
							new FileWriter(filepath));
					
					
						bw.append((CharSequence) questions);
						
						bw.close();					
						
				}catch(Exception ex) {
					return;
				}//catch
			}
				
				
			}
										
		else if (x==2)  
					Exam(filepath);
		else 
				System.out.println(" wrong number ");
		
	
	
	
	}//scanner of main
	}//main function

	

public static void fillArrayList_TestBank( ArrayList<Question> questions,int num_of_question) {
try (Scanner input = new Scanner(System.in)) {
	
	String question;
	String answer;
	
	
			for(int i=0;i<num_of_question;i++) {
			
				System.out.println("type the question "+(i+1));
			System.out.println("press enter to type the answer");
			
			question=input.nextLine();
			question.trim();
			System.out.println("enter the answer of the question "+(i+1));
			
			
			
			answer=input.nextLine();
			answer.trim();
			
			
			questions.add(i, new Question(question, answer));
			
			
		}//for loop
	
}//scanner of function fill array
}//function fill array

public static void Exam(String filepath) {
	@SuppressWarnings("resource")
	Scanner input=new Scanner (System.in);
	try{
	    FileInputStream readData = new FileInputStream( filepath);
	    ObjectInputStream readStream = new ObjectInputStream(readData);

	   ArrayList<Question> people2 = (ArrayList<Question>) readStream.readObject();
	    readStream.close();
	    Collections.shuffle(people2,new Random());
	    int correct_counter=0;
	   for(int i =0;i<5;i++) {
	    System.out.println(people2.get(i).getQuestion());
	    System.out.println("Enter the answer for the question ");
	    String answer_std=input.nextLine();
	    if(people2.get(i).getAnswer().equalsIgnoreCase(answer_std)) {
	    	correct_counter++;
	    }
	    
	   }
	   
	if (correct_counter>=5) 
		   System.out.println("you passed this exam ");
	else 
		System.out.println("you failed this exam "+"\nyou got only "+correct_counter );
	  System.out.println(people2);
	}catch (Exception e) {
	    e.printStackTrace();
	    }
	

}


}*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

class Main {

	 private static final String filepathquestions="questions.txt";
	 private static final String filepathanswers="answers.txt";
	
	public static void main(String[] args) {


			WorkingWithFiles Math = new WorkingWithFiles("MathQuestions.txt","MathAnswers.txt");
			WorkingWithFiles Science  = new WorkingWithFiles("ScienceQuestions.txt","ScienceAnswers.txt");
			WorkingWithFiles History = new WorkingWithFiles("HistoryQuestions.txt","HistoryAnswers.txt");


			try (Scanner input = new Scanner(System.in)) {

			System.out.println("press 1 if you want to create a test bank or add questions ");
			System.out.println("press 2 to take a test ");
			
			int x=input.nextInt();
			
			ArrayList<String> questions = new ArrayList<>();
			ArrayList<String> answers = new ArrayList<>();
			
		if(x==1) {
			//Testmain objectIO = new Testmain();
				System.out.println("how many questions will you enter");
				int numOfQuestions=input.nextInt();
			//	Index_Counter index = new Index_Counter(numOfQuestions);
				fillArrayList_TestBank( questions,answers,numOfQuestions);
			System.out.println("Which topic do you want to talk about");
			System.out.println("press 1 for Math");
			System.out.println("press 2 for Science");
			System.out.println("press 3 for History");

			//int ChoosingTopic = input.nextInt();
				  WorkingWithFiles.inputting(questions,answers,filepathquestions,filepathanswers,numOfQuestions);


				}
		else if (x==2)  {
			WorkingWithFiles.Exam(filepathquestions,filepathanswers);
		}
			else 
		System.out.println(" wrong number ");

}	
}

public static void fillArrayList_TestBank( ArrayList<String> questions,ArrayList<String> answers,int num_of_question) {
try (Scanner input = new Scanner(System.in)) {
	
	String question;
	String answer;
	
		//for (int i = (index.getCounter()-index.getnumber_of_questions_entered()); i <index.getCounter(); i++){
			for(int i=0;i<num_of_question;i++) {
			
				System.out.println("type the question "+(i+1));
			System.out.println("press enter to type the answer");
			
			question=input.nextLine();
			
			questions.add(i,question);
			System.out.println("enter the answer of the question "+(i+1));
			
			
			
			answer=input.nextLine();
			
			answers.add(i,answer);
			//then read till != that keyword  
			
			
			//saveTofile( filepath,questions.get(i),true);
			//objectIO.WriteObjectToFile(question.indent(i));
			
		}//for loop
	
}//scanner of function fill array
}//function fill array


}