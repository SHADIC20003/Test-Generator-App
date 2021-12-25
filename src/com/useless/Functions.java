package project3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.lang.IndexOutOfBoundsException;

public class Functions {
	 private final static String filepathquestions="C:\\Users\\ahmed alaa\\Desktop\\project\\questions.txt";
	 private final static String filepathanswers="C:\\Users\\ahmed alaa\\Desktop\\project\\answers.txt";
	 int num_of_question;

	public static void fillArrayList_TestBank( ArrayList<String> questions,ArrayList<String> answers,int num_of_question) {
		try (Scanner input = new Scanner(System.in)) {
			
			String question;
			String answer;
			
				
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
	
	
public static void copy_arraylist_to_files(ArrayList<String> questions,ArrayList<String> answers,int num_of_question) {
	
	try{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(filepathquestions,true));
	    
	    for(int i=0;i<num_of_question;i++) {
	    
	    	  bw.write(questions.get(i));
	    		bw.write("\n");
	    	  
	    }
	   
	    bw.close();

	}catch (Exception e1) {
		return ;

	}
try{

		BufferedWriter bw = new BufferedWriter(new FileWriter(filepathanswers,true));
	    
	    for(int i=0;i<num_of_question;i++) {
	    	  bw.write(answers.get(i));
	    		bw.write("\n");
	    	  
	    }
	   
	    bw.close();

	}catch (Exception e1) {
		return ;

	}
}
	public static void Exam(String filepathquestions,String filepathanswers,int questions_counter) {
		
		
		@SuppressWarnings("resource")

			Scanner input=new Scanner (System.in);

			ArrayList<String> questionsRead = new ArrayList<>();
			ArrayList<String> answersRead = new ArrayList<>();

	try{
	   
			BufferedReader br = new BufferedReader(new FileReader(filepathquestions));
	  
		for(int i=0;i<questions_counter;i++) {
			
		    questionsRead.add(i,br.readLine());
		    
		  }
		br.close();
	}catch (Exception e1) {
		return ;

		}
	try{
		   
		BufferedReader br = new BufferedReader(new FileReader(filepathanswers));

	for(int i=0;i<questions_counter;i++) {
	 
		 answersRead.add(i,br.readLine());
	  }

	br.close();
	}catch (Exception e1) {
		return ;

	}

	int seed=(int) Math.random();
	   
		Collections.shuffle( questionsRead,new Random(seed));
	    Collections.shuffle( answersRead,new Random(seed));
	   
	    int correct_counter=0;
	   if(questions_counter<10) {
		  
		   System.out.println("there are less than 10 question ");
		  
	   
	   }
	  for(int i =0;i<10;i++) {
	    
	    		System.out.println(questionsRead.get(i));
	    		System.out.println("Enter the answer for the question ");
	    
	    		String answer_std=input.nextLine();
	    		answer_std.trim();
	    
	    if(answersRead.get(i).equalsIgnoreCase(answer_std)) {
	    	correct_counter++;
	    }
	    
	   }
	   
	if (correct_counter>=5) 
		   System.out.println("you passed this exam\n ");
	else 
		System.out.println("you failed this exam \n"+"\nyou got only "+correct_counter );
		for(int i=0;i<10;i++) {
		
			System.out.println("the question is \n\n"+questionsRead.get(i));

		
			System.out.println("the correct answer is \n\n"+answersRead.get(i));


	}

	}
	
}
