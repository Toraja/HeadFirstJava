import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GuiSelectCard extends JPanel{
	private JPanel center;
	private JPanel south;
	private JButton editButton;
	private JButton deleteButton;
	private ButtonGroup cardRadioButtons;

	public GuiSelectCard(ArrayList<FlashCard> cardset){
		this.setLayout(new BorderLayout());

		// init center (radio button)
		this.center = new JPanel();
		this.center.setLayout(new GridLayout(8, 2, 20, 20));
		this.center.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		this.add(BorderLayout.CENTER, this.center);
		this.cardRadioButtons = new ButtonGroup();
		// TODO reverse the order of cardsets
		cardset.stream().forEachOrdered(card ->{
			final String question = card.getQuestion();
			final String displayText = (question.length() > 35) ? question.substring(0, 32) + "..." : question;
			final JRadioButton rb = new JRadioButton(displayText);
			rb.setBackground(new Color(200, 200, 200));
			this.cardRadioButtons.add(rb);
			this.center.add(rb);
		});

		// init south (buttons)
		this.south = new JPanel();
		this.south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
		this.add(BorderLayout.SOUTH, this.south);

		this.editButton = new JButton("Edit");
		this.deleteButton = new JButton("Delete");

		this.south.add(Box.createHorizontalGlue());
		this.south.add(BorderLayout.SOUTH, editButton);
		this.south.add(Box.createHorizontalGlue());
		this.south.add(BorderLayout.SOUTH, deleteButton);
		this.south.add(Box.createHorizontalGlue());
	}
}
