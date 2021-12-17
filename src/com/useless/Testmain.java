import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
 
public class Testmain {
	 private static final String filepath="C:\\Users\\ahmed alaa\\Desktop\\project\\inputtest.txt";
	 //remember to change the path and just leave the name 
	 
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			
			System.out.println("press 1 if you want to create a test bank or add questions ");
			System.out.println("press 2 to take a test ");
			
			int x=input.nextInt();
			ArrayList<Question> questions = new ArrayList<>();
		if(x==1) {
			//Testmain objectIO = new Testmain();
				System.out.println("how many questions will you enter");
				int numOfQuestions=input.nextInt();
			//	Index_Counter index = new Index_Counter(numOfQuestions);
				fillArrayList_TestBank( questions,numOfQuestions);
				  
				
				try{
				    FileOutputStream writeData = new FileOutputStream(filepath);
				    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

				    writeStream.writeObject(questions);
				    writeStream.flush();
				    writeStream.close();

				}catch (IOException e1) {
				    e1.printStackTrace();

				}
				
				
				/*System.out.println("enter 0 if you want to take a test");
				int y=input.nextInt();
				
				if(y==0) 
					Exam(filepath);*/
				
				
			}
										
		else if (x==2)  
					Exam(filepath);
		else 
				System.out.println(" wrong number ");
		
	
	
	
	}//scanner of main
	}//main function

	/*public static void fillArrayList_ExamQuestions( ) {
		 
			try (Scanner input = new Scanner(System.in)) {
				String question;
				String answer;
				try{
    					FileInputStream readData = new FileInputStream("peopledata.ser");
    					ObjectInputStream readStream = new ObjectInputStream(readData);

    					ArrayList<Question> people2 = (ArrayList<Question>) readStream.readObject();
    					
    					readStream.close();
    				
    					System.out.println(people2.toString());
    					
    				
						}catch (Exception e) {
    						e.printStackTrace();

							}
			}//scanner of function fill array
		}//function fill array
		
	
	/*public static void fillArrayList_TestBank(Index_Counter index, ArrayList<Question> questions,int num_of_question) {
		try (Scanner input = new Scanner(System.in)) {
			
			String question;
			String answer;
			try {
				
				BufferedWriter bw = new BufferedWriter(
						new FileWriter("C:\\Users\\ahmed alaa\\Desktop\\project\\test bank inputfile.txt"));
				//for (int i = (index.getCounter()-index.getnumber_of_questions_entered()); i <index.getCounter(); i++){
					for(int i=0;i<num_of_question;i++) {
					
						System.out.println("type the question "+(i+1));
					System.out.println("press enter to type the answer");
					
					//question= "question "+i; 
				   
					//question.concat(input.nextLine());
					question=input.nextLine();
					bw.write(question);
					
					System.out.println("enter the answer of the question "+(i+1));
					
					//answer="answer %d "+i; 
				 
					//answer.concat(input.nextLine());
					answer=input.nextLine();
					bw.write("\n"+answer);
					
					bw.close();					
					
					//then read till != that keyword  
					questions.add(i, new Question(question, answer));
					
				}//for loop
			}catch(Exception ex) {
				return;
			}//catch

		}//scanner of function fill array
	}//function fill array
	
}//class*/


public static void fillArrayList_TestBank( ArrayList<Question> questions,int num_of_question) {
try (Scanner input = new Scanner(System.in)) {
	
	String question;
	String answer;
	
		//for (int i = (index.getCounter()-index.getnumber_of_questions_entered()); i <index.getCounter(); i++){
			for(int i=0;i<num_of_question;i++) {
			
				System.out.println("type the question "+(i+1));
			System.out.println("press enter to type the answer");
			
			//question= "question "+i; 
		   
			//question.concat(input.nextLine());
			question=input.nextLine();
			question.trim();
			System.out.println("enter the answer of the question "+(i+1));
			
			
			
			answer=input.nextLine();
			answer.trim();
			
			//then read till != that keyword  
			questions.add(i, new Question(question, answer));
			//objectIO.WriteObjectToFile(question.indent(i));
			
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

/*public void WriteObjectToFile(Object serObj) {
	 
    try {

    	FileOutputStream writeData = new FileOutputStream("peopledata.ser");
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

        writeStream.writeObject(serObj);
        writeStream.flush();
        writeStream.close()

    } catch (Exception ex) {
       
    }

}*/
}
