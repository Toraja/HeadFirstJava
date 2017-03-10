import javax.swing.*;
import java.awt.*;

public class GuiTop extends JPanel{

	private JPanel north;
	private JPanel center;
	private JLabel title;
	private JButton playButton;
	private JButton createNewCardsetButton;
	private JButton editCardsetButton;

	public GuiTop(){
		// this.setLayout(new BoxLayout(gui, BoxLayout.Y_AXIS));
		this.setLayout(new BorderLayout());

		this.north = new JPanel();
		this.center = new JPanel();
		this.center.setLayout(new BoxLayout(this.center, BoxLayout.X_AXIS));
		this.add(BorderLayout.NORTH, this.north);
		this.add(BorderLayout.CENTER, this.center);

		// TODO make it look more like title
		this.title = new JLabel("Flash Card");
		this.playButton = new JButton("play");
		this.createNewCardsetButton = new JButton("create new cardset");
		this.editCardsetButton = new JButton("add card to cardset");
		this.north.add(this.title);
		this.center.add(Box.createHorizontalGlue());
		this.center.add(this.playButton);
		this.center.add(Box.createHorizontalGlue());
		this.center.add(this.createNewCardsetButton);
		this.center.add(Box.createHorizontalGlue());
		this.center.add(this.editCardsetButton);
		this.center.add(Box.createHorizontalGlue());
	}
}
