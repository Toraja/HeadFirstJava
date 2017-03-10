import java.io.Serializable;

public class FlashCard implements Serializable{

	private String question;
	private String answer;

	public FlashCard(String question, String answer){
		this.question = question;
		this.answer = answer;
	}

	public String getQuestion(){
		return this.question;
	}

	public String getAnswer(){
		return this.answer;
	}

}
