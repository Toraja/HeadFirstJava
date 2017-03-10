import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

public class FlashCardManager{

	private JFrame frame;
	private JPanel background;
	private static Map<String, ArrayList<FlashCard>> cardsets = new HashMap<String, ArrayList<FlashCard>>();

	public static void main(String[] args){
		FlashCardManager manager = new FlashCardManager();
		manager.initGui();

		manager.testGui(new GuiPlay());
		ArrayList<FlashCard> cards = new ArrayList<FlashCard>();
		cards.add(new FlashCard("Test Question", "Test Answer"));
		cards.add(new FlashCard("Test QuestionTest QuestionTest QuestionTest QuestionTest Question", "Test Answer"));
		try{
			FlashCardManager.addCardsetUniquely("TestSet1", cards);
			FlashCardManager.addCardsetUniquely("TestSet2", cards);
			FlashCardManager.addCardsetUniquely("TestSet3", cards);
			FlashCardManager.addCardsetUniquely("TestSet4", cards);
			FlashCardManager.addCardsetUniquely("TestSet5", cards);
			FlashCardManager.addCardsetUniquely("TestSet6", cards);
			FlashCardManager.addCardsetUniquely("TestSet7", cards);
			FlashCardManager.addCardsetUniquely("TestSet8", cards);
			FlashCardManager.addCardsetUniquely("TestSet9", cards);
			FlashCardManager.addCardsetUniquely("TestSet10", cards);
			FlashCardManager.addCardsetUniquely("TestSet11", cards);
			FlashCardManager.addCardsetUniquely("TestSet12TestSet12TestSet12TestSet12", cards);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		manager.testGui(new GuiSelectCardSet());
		manager.testGui(new GuiSelectCard(cardsets.get("TestSet11")));
		manager.testGui(new GuiWriteCard());
	}

	// only for development
	private void testGui(JPanel gui){
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
		}
		this.background.removeAll();
		this.background.add(BorderLayout.CENTER, gui);
		this.frame.validate();
	}

	private void initGui(){
		this.frame = new JFrame();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setTitle("Be Smarter");
		this.background = new JPanel();
		this.background.setLayout(new BorderLayout());
		this.background.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.frame.getContentPane().add(BorderLayout.CENTER, background);
		// this.background.add(new GuiTop().initGui());
		this.background.add(new GuiTop());

		// this.frame.pack();
		this.frame.setSize(700, 610);
		this.frame.setVisible(true);
	}

	public JFrame getFrame(){
		return this.frame;
	}

	public void setFrame(JFrame frame){
		this.frame = frame;
	}

	public JPanel getBackground(){
		return this.background;
	}

	public void setBackground(JPanel background){
		this.background = background;
	}

	public static Map<String, ArrayList<FlashCard>> getCardsets(){
		return FlashCardManager.cardsets;
	}

	// Don't set cardsets
	// public void setCardsets(Map<String, ArrayList<FlashCard>> cardsets){
		// this.cardsets = cardsets;
	// }

	public static void addCardsetUniquely(String setTitle, ArrayList<FlashCard> cardset) throws Exception{
		if(FlashCardManager.cardsets.containsKey(setTitle)){
			throw new Exception("Cardsets with the title already exists.");
		}
		FlashCardManager.cardsets.put(setTitle, cardset);
	}


	// try{
		// this.cardsets = (Map)new ObjectInputStream(new FileInputStream("cardsets.ser"));

	// }
	// catch(FileNotFoundException ex){
		// System.out.println();
	// }
}
