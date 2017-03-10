import javax.swing.*;
import java.awt.*;

public class GuiSelectCardSet extends JPanel{
	private JPanel center;
	private JPanel south;
	private JButton addCardsButton;
	private JButton editCardsetButton;
	private JButton deleteCardsetsButton;
	private ButtonGroup cardsetRadioButtons;

	public GuiSelectCardSet(){
		this.setLayout(new BorderLayout());

		this.center = new JPanel();
		this.center.setLayout(new GridLayout(8, 2, 20, 20));
		this.center.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		this.south = new JPanel();
		this.south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
		this.add(BorderLayout.CENTER, this.center);
		this.add(BorderLayout.SOUTH, this.south);

		this.cardsetRadioButtons = new ButtonGroup();
		this.addCardsButton = new JButton("Add Card");
		this.editCardsetButton = new JButton("Edit Cardset");
		this.deleteCardsetsButton = new JButton("Delete Cardset");

		// TODO reverse the order of cardsets
		FlashCardManager.getCardsets().keySet().stream().forEachOrdered(key ->{
			final JRadioButton rb = new JRadioButton(key);
			rb.setHorizontalAlignment(SwingConstants.CENTER);
			rb.setBackground(new Color(200, 200, 200));
			this.cardsetRadioButtons.add(rb);
			this.center.add(rb);
		});

		this.south.add(Box.createHorizontalGlue());
		this.south.add(BorderLayout.SOUTH, addCardsButton);
		this.south.add(Box.createHorizontalGlue());
		this.south.add(BorderLayout.SOUTH, editCardsetButton);
		this.south.add(Box.createHorizontalGlue());
		this.south.add(BorderLayout.SOUTH, deleteCardsetsButton);
		this.south.add(Box.createHorizontalGlue());
	}
}
