

import java.io.Serializable;
public class Question implements Serializable {
	
	
	private String question;
	private String answer;
	public static int questionCounter;
	
	public Question(String question,String answer){
		this.question=question;
		this.answer=answer;
		questionCounter++;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public static int getQuestionCounter() {
		return questionCounter;
	}

	@Override
	public String toString() {
		return "Question [question=" + question + ", answer=" + answer + "]";
	}

	
	
	
}
