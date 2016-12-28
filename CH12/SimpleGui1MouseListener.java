import javax.swing.*;
import java.awt.event.*;
import java.awt.Container;

public class SimpleGui1MouseListener implements MouseListener{
	JButton button;

	public static void main(String[] args){
		SimpleGui1MouseListener gui = new SimpleGui1MouseListener();
		gui.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		button = new JButton("click me");

		button.addMouseListener(this);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		pane.add(button);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	// This overlaps mouseReleased method.
	// This isn't called if mouse pointer moves outside the button before mouse is released.
	public void mouseClicked(MouseEvent event){
		// button.setText("click");
	}

	public void mouseEntered(MouseEvent event){
		button.setText("Hello");
	}

	public void mouseExited(MouseEvent event){
		button.setText("Bye");
	}

	public void mousePressed(MouseEvent event){
		button.setText("You are so... hea...vy...");
	}

	public void mouseReleased(MouseEvent event){
		button.setText("phew, I thought I'd die.");
	}

}
