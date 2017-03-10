import javax.swing.*;
import java.awt.*;

public class GuiWriteCard extends JPanel{

	private JPanel center;
	private JPanel south;
	private JButton addButton;
	private JButton quitButton;
	private JTextArea questionArea;
	private JTextArea answerArea;

	public GuiWriteCard(){
		Font dialogPlain20 = new Font(Font.DIALOG, Font.PLAIN, 20);
		this.setLayout(new BorderLayout());

		// init center
		this.center = new JPanel();
		this.center.setLayout(new BoxLayout(this.center, BoxLayout.Y_AXIS));
		this.add(BorderLayout.CENTER, this.center);

		this.questionArea = new JTextArea(10,30);
		this.questionArea.setLineWrap(true);
		this.questionArea.setEditable(true);
		this.questionArea.setFont(dialogPlain20);
		this.answerArea = new JTextArea(10,30);
		this.answerArea.setLineWrap(true);
		this.answerArea.setEditable(true);
		this.answerArea.setFont(dialogPlain20);
		JScrollPane questionScroller = new JScrollPane(this.questionArea);
		questionScroller.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		JScrollPane answerScroller = new JScrollPane(this.answerArea);
		answerScroller.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		questionScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		questionScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		answerScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		answerScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		this.center.add(questionScroller);
		this.center.add(answerScroller);

		// init south
		this.south = new JPanel();
		this.south.setLayout(new BoxLayout(this.south, BoxLayout.X_AXIS));
		this.south.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		this.add(BorderLayout.SOUTH, this.south);

		this.addButton = new JButton("Add");
		this.quitButton = new JButton("Quit");

		this.south.add(Box.createHorizontalGlue());
		this.south.add(this.addButton);
		this.south.add(Box.createHorizontalGlue());
		this.south.add(this.quitButton);
		this.south.add(Box.createHorizontalGlue());
	}
}
