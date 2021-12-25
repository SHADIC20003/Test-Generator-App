import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class WorkingWithFiles {
    private String filepathQ;
    private String filepathA;

    WorkingWithFiles(String filepathQ,String filepathA){
        this.filepathQ = filepathQ;
        this.filepathA = filepathA;

    }


    public String getFilepathQ() {
        return filepathQ;
    }

    public void setFilepathQ(String filepathQ) {
        this.filepathQ = filepathQ;
    }

    public String getFilepathA() {
        return filepathA;
    }

    public void setFilepathA(String filepathA) {
        this.filepathA = filepathA;
    }



    public static void inputting(ArrayList<String> questions,ArrayList<String> answers,String FilepathQ, String FilepathA,int numOfQuestions){
        try{

            BufferedWriter bw = new BufferedWriter(new FileWriter(FilepathQ,true));

            for(int i=0;i<numOfQuestions;i++) {

                bw.write(questions.get(i));
                bw.write("\n");

            }

            bw.close();

        }catch (Exception e1) {
            return ;

        }
        try{

            BufferedWriter bw = new BufferedWriter(new FileWriter(FilepathA,true));

            for(int i=0;i<numOfQuestions;i++) {
                bw.write(answers.get(i));
                bw.write("\n");

            }

            bw.close();

        }catch (Exception e1) {
            return ;

        }
    }

    public static void Exam(String filePathQuestions, String filePathAnswers) {


        @SuppressWarnings("resource")

        Scanner input=new Scanner (System.in);

        ArrayList<String> questionsRead = new ArrayList<>();
        ArrayList<String> answersRead = new ArrayList<>();

        try{

            BufferedReader br = new BufferedReader(new FileReader(filePathQuestions));

            for(int i=0;i<10;i++) {

                questionsRead.add(i,br.readLine());

            }
            br.close();
        }catch (Exception e1) {
            return ;

        }
        try{

            BufferedReader br = new BufferedReader(new FileReader(filePathAnswers));

            for(int i=0;i<10;i++) {

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

        for(int i =0;i<10;i++) {

            System.out.println(questionsRead.get(i));
            System.out.println("Enter the answer for the question ");

            String answer_std=input.nextLine();

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
