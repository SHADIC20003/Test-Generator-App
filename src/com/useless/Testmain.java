package project4;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import java.util.Scanner;



public class Testmain {
	
	public static void main(String[] args) {
		
		String filepathquestionscounter="questions counter.txt";
		String filepathtestscounter="tests counter.txt";
		int testscounter=Functions.Read_Counters(filepathtestscounter);
		
		
	int y,z;
			Scanner input = new Scanner(System.in);
            WorkingWithFiles Math = new WorkingWithFiles("MathQuestions.txt","MathAnswers.txt");
			WorkingWithFiles Science  = new WorkingWithFiles("ScienceQuestions.txt","ScienceAnswers.txt");
			WorkingWithFiles History = new WorkingWithFiles("HistoryQuestions.txt","HistoryAnswers.txt");

	
                       System.out.println("press 11 if you want to create a test bank or add questions for Maths");
                       System.out.println("press 12 if you want to create a test bank or add questions for Science");
                       System.out.println("press 13 if you want to create a test bank or add questions for History");
                        System.out.println("press 21 to take a Maths test ");
                        System.out.println("press 22 to take a Science test ");
                        System.out.println("press 23 to take a History test ");
                        
			int x=input.nextInt();
			
			
			ArrayList<String> questions = new ArrayList<>();
            ArrayList<String> answers = new ArrayList<>();
            int numofquestions;
 			int questionscounter;
             switch (x) {
                 case 11:
                     
                	 System.out.println("how many questions will you enter ");
         			numofquestions=input.nextInt();
         			questionscounter=Functions.Read_Counters(filepathquestionscounter);
         			questionscounter+=numofquestions;
         			Functions.Write_Counters(questionscounter, filepathquestionscounter);
         			Functions.fillArrayList_TestBank(questions, answers, numofquestions);
         		
         			Functions.copy_arraylist_to_files_append(questions,answers, numofquestions,Math.getFilepathQ(),Math.getFilepathA());
                         break;    
                              
                     case 12:
                    	 System.out.println("how many questions will you enter ");
              			numofquestions=input.nextInt();
              			questionscounter=Functions.Read_Counters(filepathquestionscounter);
              			questionscounter+=numofquestions;
              			Functions.Write_Counters(questionscounter, filepathquestionscounter);
              			Functions.fillArrayList_TestBank(questions, answers, numofquestions);
                       Functions.copy_arraylist_to_files_append(questions,answers,numofquestions ,Science.getFilepathQ(),Science.getFilepathA());
                       break;
                               
                     case 13:
                    	 System.out.println("how many questions will you enter ");
               			numofquestions=input.nextInt();
               			questionscounter=Functions.Read_Counters(filepathquestionscounter);
               			questionscounter+=numofquestions;
               			Functions.Write_Counters(questionscounter, filepathquestionscounter);
               			Functions.fillArrayList_TestBank(questions, answers, numofquestions);
                        Functions.copy_arraylist_to_files_append(questions,answers,numofquestions,History.getFilepathQ(),History.getFilepathA());
                              break;
                               
                                 
                   
                    
                 case 21:
                	
                	 testscounter++;
         			Functions.Write_Counters(testscounter, filepathtestscounter);
                	 Functions.Exam(Math.getFilepathQ(), Math.getFilepathA(),Functions.Read_Counters(filepathquestionscounter));
                	 System.out.println("number of exams taken is "+Functions.Read_Counters(filepathtestscounter));
                                   break;
                                  
                  case 22:
                	 
                	  testscounter++;
           			Functions.Write_Counters(testscounter, filepathtestscounter);
                  	 Functions.Exam(Science.getFilepathQ(), Science.getFilepathA(),Functions.Read_Counters(filepathquestionscounter));
                  	 System.out.println("number of exams taken is "+Functions.Read_Counters(filepathtestscounter));
                                   break;
                                   
                  case 23:
                	
                	  testscounter++;
           			Functions.Write_Counters(testscounter, filepathtestscounter);
                  	 Functions.Exam(Science.getFilepathQ(), Science.getFilepathA(),Functions.Read_Counters(filepathquestionscounter));
                  	 System.out.println("number of exams taken is "+Functions.Read_Counters(filepathtestscounter));
                                   break;
                                   
                                   default:
                                       System.out.println("wrong number");
                                       break;
               
                   
             }
            

             
             
}	
}