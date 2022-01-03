package project4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import java.util.Scanner;



public class Testmain {
	
	public static void main(String[] args) {
		  System.out.println("press 11 if you want to create a test bank or add questions for Maths");
          System.out.println("press 12 if you want to create a test bank or add questions for Science");
          System.out.println("press 13 if you want to create a test bank or add questions for History");
           System.out.println("press 21 to take a Maths test ");
           System.out.println("press 22 to take a Science test ");
           System.out.println("press 23 to take a History test ");
           
		
		String filepathquestionscountermaths="questions counter maths.txt";
		String filepathquestionscounterscience="questions counter science.txt";
		String filepathquestionscounterhistory="questions counter history.txt";
		String filepathtestscounter="tests counter.txt";
		String filepathtestscountermaths="tests counter maths.txt";
		String filepathtestscounterscience="tests counter science.txt";
		String filepathtestscounterhistory="tests counter history.txt";
		String Averagetime="Average time.txt";
		
		 int testscounter=Functions.Read_Counters(filepathtestscounter);
		 int mathstests=Functions.Read_Counters(filepathtestscountermaths);
		 int sciencetests=Functions.Read_Counters(filepathtestscounterscience);
		 int historytests=Functions.Read_Counters(filepathtestscounterhistory);
		
		
	int y,z;
			Scanner input = new Scanner(System.in);
            WorkingWithFiles Math = new WorkingWithFiles("MathQuestions.txt","MathAnswers.txt");
			WorkingWithFiles Science  = new WorkingWithFiles("ScienceQuestions.txt","ScienceAnswers.txt");
			WorkingWithFiles History = new WorkingWithFiles("HistoryQuestions.txt","HistoryAnswers.txt");

	
                        
			int x=input.nextInt();
			
			
			ArrayList<String> questions = new ArrayList<>();
            ArrayList<String> answers = new ArrayList<>();
            int numofquestions;
 			int questionscounter;
                                                StopWatch stopwatch= new StopWatch();

             switch (x) {
                 case 11:
                     
                	 System.out.println("how many questions will you enter ");
         			numofquestions=input.nextInt();
         			questionscounter=Functions.Read_Counters(filepathquestionscountermaths);
         			questionscounter+=numofquestions;
         			Functions.Write_Counters(questionscounter, filepathquestionscountermaths);
         			Functions.fillArrayList_TestBank(questions, answers, numofquestions);
         		
         			Functions.copy_arraylist_to_files_append(questions,answers, numofquestions,Math.getFilepathQ(),Math.getFilepathA());
                         break;    
                              
                     case 12:
                    	 System.out.println("how many questions will you enter ");
              			numofquestions=input.nextInt();
              			questionscounter=Functions.Read_Counters(filepathquestionscounterscience);
              			questionscounter+=numofquestions;
              			Functions.Write_Counters(questionscounter, filepathquestionscounterscience);
              			Functions.fillArrayList_TestBank(questions, answers, numofquestions);
                       Functions.copy_arraylist_to_files_append(questions,answers,numofquestions ,Science.getFilepathQ(),Science.getFilepathA());
                       break;
                               
                     case 13:
                    	 System.out.println("how many questions will you enter ");
               			numofquestions=input.nextInt();
               			questionscounter=Functions.Read_Counters(filepathquestionscounterhistory);
               			questionscounter+=numofquestions;
               			Functions.Write_Counters(questionscounter, filepathquestionscounterhistory);
               			Functions.fillArrayList_TestBank(questions, answers, numofquestions);
                        Functions.copy_arraylist_to_files_append(questions,answers,numofquestions,History.getFilepathQ(),History.getFilepathA());
                              break;
                               
                                 
                   
                    
                 case 21:
                
                	 testscounter++;
                	 Functions.Write_Counters(testscounter, filepathtestscounter);
                	                                          stopwatch.start();

                	 mathstests++;
                	 Functions.Write_Counters(mathstests, filepathtestscountermaths);
                	 Functions.Exam(Math.getFilepathQ(), Math.getFilepathA(),Functions.Read_Counters(filepathquestionscountermaths));
                         stopwatch.stop();
                    	 stopwatch.elapsed();
                         System.out.println("The time taken to complete the current test is\n");
                         System.out.println(stopwatch.toString());
                	 System.out.println("total number of exams taken is "+Functions.Read_Counters(filepathtestscounter));
                	 System.out.println("number of maths exams taken is "+Functions.Read_Counters(filepathtestscountermaths));
                	
                                   break;
                                  
                  case 22:
                	 
                	  testscounter++;
                                          	                                          stopwatch.start();

           			Functions.Write_Counters(testscounter, filepathtestscounter);
           		 
            	 sciencetests++;
            	 Functions.Write_Counters(sciencetests, filepathtestscounterscience);
                  	 Functions.Exam(Science.getFilepathQ(), Science.getFilepathA(),Functions.Read_Counters(filepathquestionscounterscience));
                          stopwatch.stop();
                          stopwatch.elapsed();
                         System.out.println("The time taken to complete the current test is\n");
                         System.out.println(stopwatch.toString());
                  	 System.out.println("total number of exams taken is "+Functions.Read_Counters(filepathtestscounter));
                  	 System.out.println("number of science exams taken is "+Functions.Read_Counters(filepathtestscounterscience));
                  	
                                   break;
                                   
                  case 23:
                	
                	  testscounter++;
                                                                    	                                          stopwatch.start();

           			Functions.Write_Counters(testscounter, filepathtestscounter);
           		
            	 historytests++;
            	 Functions.Write_Counters(historytests, filepathtestscounterhistory);
                  	 Functions.Exam(History.getFilepathQ(), History.getFilepathA(),Functions.Read_Counters(filepathquestionscounterhistory));
                           stopwatch.stop();
                     	  stopwatch.elapsed();
                      /*  double  totaltime = Functions.Read_time(Averagetime);
                        
                        totaltime+= stopwatch.elapsed();
                        Functions.Write_time(totaltime,Averagetime);
                       double averagetime=(Functions.Read_time(Averagetime)/Functions.Read_Counters(filepathtestscounterhistory));
                       
                       System.out.println("average time for history test is "+averagetime);*/
                         System.out.println("The time taken to complete the current test is\n");
                         System.out.println(stopwatch.toString());
                  	 System.out.println("Total number of exams taken is "+Functions.Read_Counters(filepathtestscounter));
                  	 System.out.println("number of history exams taken is "+Functions.Read_Counters(filepathtestscounterhistory));
                  
                                   break;
                                   
                                   default:
                                       System.out.println("wrong number");
                                       break;
               
                   
             }
            

             
             
}	
}