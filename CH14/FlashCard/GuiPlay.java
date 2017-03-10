import javax.swing.*;
import java.awt.*;

public class GuiPlay extends JPanel{

	private JPanel north;
	private JPanel center;
	private JPanel south;
	private JPanel controlPanel;
	private JPanel feedbackPanel;
	private JButton showAnswerButton;
	private JButton skipButton;
	private JButton correctButton;
	private JButton wrongButton;
	private JButton quitButton;
	private JTextArea questionArea;
	private JTextArea answerArea;
	private JLabel doneCount;			// numerator of progress fraction
	private JLabel totalCardNum;		// denominator of progress fraction
	private JLabel slash;				// for the progress fraction
	private JLabel correctLabel;		// shown as in Correct: (num)
	private JLabel correctCount;		// shown as in Correct: (num)
	private JLabel wrongLabel;			// shown as in Wrong: (num)
	private JLabel wrongCount;			// shown as in Wrong: (num)

	public GuiPlay(){
		Font dialogPlain20 = new Font(Font.DIALOG, Font.PLAIN, 20);
		this.setLayout(new BorderLayout());


		// init north
		this.north = new JPanel();
		this.north.setLayout(new BoxLayout(this.north, BoxLayout.X_AXIS));
		this.north.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		this.add(BorderLayout.NORTH, this.north);

		this.doneCount = new JLabel("0");
		this.slash = new JLabel(" / ");
		this.totalCardNum = new JLabel();
		this.correctLabel = new JLabel("Correct: ");
		this.correctCount = new JLabel("0");
		this.wrongLabel = new JLabel("Wrong: ");
		this.wrongCount = new JLabel("0");
		this.north.add(Box.createHorizontalGlue());

		this.north.add(this.doneCount);
		this.north.add(this.slash);
		this.north.add(this.totalCardNum);
		this.north.add(Box.createHorizontalGlue());
		this.north.add(this.correctLabel);
		this.north.add(this.correctCount);
		this.north.add(Box.createHorizontalGlue());
		this.north.add(this.wrongLabel);
		this.north.add(this.wrongCount);
		this.north.add(Box.createHorizontalGlue());

		// init center
		this.center = new JPanel();
		this.center.setLayout(new BoxLayout(this.center, BoxLayout.Y_AXIS));
		this.add(BorderLayout.CENTER, this.center);

		this.questionArea = new JTextArea(10,30);
		this.questionArea.setLineWrap(true);
		this.questionArea.setEditable(false);
		this.questionArea.setFont(dialogPlain20);
		this.answerArea = new JTextArea(10,30);
		this.answerArea.setLineWrap(true);
		this.answerArea.setEditable(false);
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
		this.south.setLayout(new BorderLayout());
		this.south.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		this.add(BorderLayout.SOUTH, this.south);

		this.controlPanel = new JPanel();
		this.controlPanel.setLayout(new BoxLayout(this.controlPanel, BoxLayout.X_AXIS));
		this.feedbackPanel = new JPanel();
		this.feedbackPanel.setLayout(new BoxLayout(this.feedbackPanel, BoxLayout.X_AXIS));

		this.showAnswerButton = new JButton("Show Answer");
		this.skipButton = new JButton("Skip");
		this.correctButton = new JButton("Correct");
		this.wrongButton = new JButton("Wrong");
		this.quitButton = new JButton("Quit");

		this.controlPanel.add(Box.createHorizontalGlue());
		this.controlPanel.add(this.showAnswerButton);
		this.controlPanel.add(Box.createHorizontalGlue());
		this.controlPanel.add(this.skipButton);
		this.controlPanel.add(Box.createHorizontalGlue());
		this.controlPanel.add(this.quitButton);
		this.controlPanel.add(Box.createHorizontalGlue());

		this.feedbackPanel.add(Box.createHorizontalGlue());
		this.feedbackPanel.add(this.correctButton);
		this.feedbackPanel.add(Box.createHorizontalGlue());
		this.feedbackPanel.add(this.wrongButton);
		this.feedbackPanel.add(Box.createHorizontalGlue());

		this.south.add(this.controlPanel);

		// --- debug ---
		// System.out.println(this.questionArea.getFont().getName());
		// System.out.println(this.questionArea.getFont().getSize());
		// System.out.println(this.questionArea.getFont().getStyle());
		this.questionArea.setText("question area\nquestion area\nquestion area\nquestion area\nquestion area\nquestion area\nquestion area\nquestion area\nquestion area\nquestion area\nquestion area\nquestion area\nquestion area\nquestion area\n");
		this.answerArea.setText("answer area\nanswer area\nanswer area\nanswer area");
		// -------------
	}
}
