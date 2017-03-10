import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;
import java.util.Enumeration;

public class RadioButton1{

	public static void main(String[] args){
		RadioButton1 rb = new RadioButton1();
		rb.go();
	}

	void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel background = new JPanel();
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		frame.getContentPane().add(background);

		JRadioButton rb1 = new JRadioButton("Set 1");
		rb1.setSelected(true);
		JRadioButton rb2 = new JRadioButton("Set 2");
		JRadioButton rb3 = new JRadioButton("Set 3");
		JRadioButton rb4 = new JRadioButton("Set 4");
		JRadioButton rb5 = new JRadioButton("Set 5");
		ButtonGroup bgrp = new ButtonGroup();
		bgrp.add(rb1);
		bgrp.add(rb2);
		bgrp.add(rb3);
		bgrp.add(rb4);
		bgrp.add(rb5);
		background.add(rb1);
		background.add(rb2);
		background.add(rb3);
		background.add(rb4);
		background.add(rb5);

		JTextField text = new JTextField(10);
		JButton button = new JButton("Click");
		button.addActionListener(event -> text.setText(getSelectedButton(bgrp).getText()));
		background.add(button);
		background.add(text);

		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	AbstractButton getSelectedButton(ButtonGroup bgrp){
		for(Enumeration<AbstractButton> buttons = bgrp.getElements(); buttons.hasMoreElements();){
			AbstractButton button = buttons.nextElement();
			if(button.isSelected()){
				return button;
			}
		}

		return null;
	}
}
