
package project4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class Functions {

	static String FilePathPass=("Number of passes.txt");
	static String FilePathFail=("Number of fails.txt");
     


	public static void fillArrayList_TestBank( ArrayList<String> questions,ArrayList<String> answers,int num_of_question) {
		try (Scanner input = new Scanner(System.in)) {
			
			String question;
			String answer;
			
				
					for(int i=0;i<num_of_question;i++) {
					
					System.out.println("type the question "+(i+1));
					System.out.println("press enter to type the answer");
					
					question=input.nextLine();
					question.trim();
					
					questions.add(i,question);
					System.out.println("enter the answer of the question "+(i+1));
					
					
					
					answer=input.nextLine();
					answer.trim();
					answers.add(i,answer);
					
					
				}//for loop
			
		}//scanner of function fill array
		}//function fill array
	
	
public static void copy_arraylist_to_files_append(ArrayList<String> questions,ArrayList<String> answers,int num_of_question,String filepathquestions,String filepathanswers) {
	
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
public static void copy_arraylist_to_files_overwrite(ArrayList<String> questions,ArrayList<String> answers,int num_of_question,String filepathquestions,String filepathanswers) {
	
	try{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(filepathquestions));
	    
	    for(int i=0;i<num_of_question;i++) {
	    
	    	  bw.write(questions.get(i));
	    		bw.write("\n");
	    	  
	    }
	   
	    bw.close();

	}catch (Exception e1) {
		return ;

	}
try{

		BufferedWriter bw = new BufferedWriter(new FileWriter(filepathanswers));
	    
	    for(int i=0;i<num_of_question;i++) {
	    	  bw.write(answers.get(i));
	    		bw.write("\n");
	    	  
	    }
	   
	    bw.close();

	}catch (Exception e1) {
		return ;

	}
}
	public static void Exam(String filepathquestions,String filepathanswers,int num_of_question) {
		
		int passCounter=Read_Counters(FilePathPass);
		int failCounter=Read_Counters(FilePathFail);	
		@SuppressWarnings("resource")

			Scanner input2=new Scanner (System.in);

			ArrayList<String> questionsRead = new ArrayList<>();
			ArrayList<String> answersRead = new ArrayList<>();

	try{
	   
			BufferedReader br = new BufferedReader(new FileReader(filepathquestions));
	  
		for(int i=0;i<num_of_question;i++) {
			
		    questionsRead.add(i,br.readLine());
		    
		  }
		br.close();
	}catch (Exception e1) {
		return ;

		}
	try{
		   
		BufferedReader br = new BufferedReader(new FileReader(filepathanswers));

	for(int i=0;i<num_of_question;i++) {
	 
		 answersRead.add(i,br.readLine());
	  }

	br.close();
	}catch (Exception e1) {
		return ;

	}
	if(num_of_question<10) {
		System.out.println("their are less than 10 questions ");  
		int seed = (int)Math.floor(Math.random()*(100-50+1)+50);
		   
        Collections.shuffle( questionsRead,new Random(seed));
    Collections.shuffle( answersRead,new Random(seed));
   
    double correct_counter=0;
 
   
  for(int i =0;i<num_of_question;i++) {
    
    		System.out.println(questionsRead.get(i));
    		System.out.println("Enter the answer for the question ");
    
    		String answer_std=input2.nextLine();
    		answer_std.trim();
    
    if(answersRead.get(i).equalsIgnoreCase(answer_std)) {
    	correct_counter++;
    }
    
   }
   
if (correct_counter>=(double)(num_of_question/2)) {
	   System.out.println("you passed this exam\n ");
passCounter+=1;
	Write_Counters(passCounter,FilePathPass);
}
else { 
	System.out.println("you failed this exam \n"+"\nyou got only "+correct_counter );
	
	failCounter+=1;
	Write_Counters(failCounter,FilePathFail);
	
}
	for(int i=0;i<num_of_question;i++) {
	
		System.out.println("the question is \n\n"+questionsRead.get(i));

	
		System.out.println("the correct answer is \n\n"+answersRead.get(i));

		

}
	System.out.println("number of passes are  "+Read_Counters(FilePathPass));
	System.out.println("number of fails are  "+Read_Counters(FilePathFail));
	}
else {
	int seed = (int)Math.floor(Math.random()*(100-50+1)+50);
	   
            Collections.shuffle( questionsRead,new Random(seed));
	    Collections.shuffle( answersRead,new Random(seed));
	   
	    int correct_counter=0;
	 
	   
	  for(int i =0;i<10;i++) {
	    
	    		System.out.println(questionsRead.get(i));
	    		System.out.println("Enter the answer for the question ");
	    
	    		String answer_std=input2.nextLine();
	    		answer_std.trim();
	    
	    if(answersRead.get(i).equalsIgnoreCase(answer_std)) {
	    	correct_counter++;
	    }
	    
	   }
	   
	if (correct_counter>=5) {
		   System.out.println("you passed this exam\n ");
	passCounter+=1;
		Write_Counters(passCounter,FilePathPass);
	}
	else { 
		System.out.println("you failed this exam \n"+"\nyou got only "+correct_counter );
		failCounter+=1;
		Write_Counters(failCounter,FilePathFail);
		
	}
		for(int i=0;i<10;i++) {
		
			System.out.println("the question is \n\n"+questionsRead.get(i));

		
			System.out.println("the correct answer is \n\n"+answersRead.get(i));

			

	}
		System.out.println("number of passes are  "+Read_Counters(FilePathPass));
		System.out.println("number of fails are  "+Read_Counters(FilePathFail));
	}
}
	public static void Write_Counters(int count,String FilePath) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(FilePath));
			bw.write(count++);
			bw.close();
		}catch(Exception e){
			return ;
		}
	}
		
	public static int Read_Counters(String FilePath) {
			int count=0;
			try {
			BufferedReader br=new BufferedReader(new FileReader(FilePath)) ;
				count = br.read();
				br.close();
			
		}catch(Exception e) {
		System.out.println("");
		}
		return count;
		}


	
}

