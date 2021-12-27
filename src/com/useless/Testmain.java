package project3;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import java.util.Scanner;

public class Testmain {
	
	public static void main(String[] args) {
		
String FilePathTests=("Number of tests.txt");
String FilePathQuestions=("number of Questions");
		int number_of_tests=Functions.Read_Counters(FilePathTests);
		
		
	int y,z;
			Scanner input = new Scanner(System.in);
            WorkingWithFiles Math = new WorkingWithFiles("MathQuestions.txt","MathAnswers.txt");
			WorkingWithFiles Science  = new WorkingWithFiles("ScienceQuestions.txt","ScienceAnswers.txt");
			WorkingWithFiles History = new WorkingWithFiles("HistoryQuestions.txt","HistoryAnswers.txt");

	
                       System.out.println("press 1 if you want to create a test bank or add questions ");
                        System.out.println("press 2 to take a test ");
                        
			int x=input.nextInt();
			
			
			
		
			
             switch (x) {
                 case 1:
                      ArrayList<String> questions = new ArrayList<>();
                      ArrayList<String> answers = new ArrayList<>();
                      System.out.println("how many questions you want to add");
                      int numOfQuestions=Functions.Read_Counters(FilePathQuestions);
                      numOfQuestions+=input.nextInt();
                      Functions.Write_Counters(numOfQuestions,FilePathQuestions);
                      
                      Functions.fillArrayList_TestBank( questions,answers,Functions.Read_Counters(FilePathQuestions));
                        
                      System.out.println("you have three subjects to choose from them \n");
			System.out.println("press 1 for Maths\n");
                        System.out.println("press 2 for Science \n");
                        System.out.println("press 3 for History \n");
                         
                       
                        y=input.nextInt();
                               switch(y){
                                   case 1:
                                   Functions.copy_arraylist_to_files(questions,answers, Functions.Read_Counters(FilePathQuestions),Math.getFilepathQ(),Math.getFilepathA());
                               break;    
                              
                                   case 2:
                                    Functions.copy_arraylist_to_files(questions,answers, Functions.Read_Counters(FilePathQuestions),Math.getFilepathQ(),Science.getFilepathA());
                               break;
                               
                                   case 3:
                                    Functions.copy_arraylist_to_files(questions,answers, Functions.Read_Counters(FilePathQuestions),History.getFilepathQ(),History.getFilepathA());
                              break;
                               
                                   default:
                                    System.out.println("wrong number");
                              break;
                               }
                   
                     break;
                 case 2:
                	 
                	 number_of_tests+=1;
                	 
                	 Functions.Write_Counters( number_of_tests, FilePathTests);
                	 
                      
                        System.out.println("you have three subjects to choose from them \n");
			System.out.println("press 1 for Maths\n");
                        System.out.println("press 2 for Science \n");
                        System.out.println("press 3 for History \n");
                         
                        z=input.nextInt();
                        
                    
                               switch(z){
                                   case 1:
                                	  
                                       Functions.Exam(Math.getFilepathQ(), Math.getFilepathA(),Functions.Read_Counters(FilePathQuestions));
                                       System.out.println("number of tests taken are"+Functions.Read_Counters(FilePathTests));
                                   break;
                                  
                                   case 2:
                                        Functions.Exam(Science.getFilepathQ(), Science.getFilepathA(),Functions.Read_Counters(FilePathQuestions));
                                        System.out.println("number of tests taken are"+Functions.Read_Counters(FilePathTests));
                                   break;
                                   
                                   case 3:
                                        Functions.Exam(History.getFilepathQ(), History.getFilepathA(),Functions.Read_Counters(FilePathQuestions));
                                        System.out.println("number of tests taken are"+Functions.Read_Counters(FilePathTests));
                                   break;
                                   
                                   default:
                                       System.out.println("wrong number");
                                       break;
                               }
                  break;   
                 default:
                     System.out.println(" wrong number ");
                     break;
                     
                   
             }
            

             
             
}	
}