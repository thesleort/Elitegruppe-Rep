package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui extends JFrame implements ActionListener {
	JButton btn1 = new JButton("Button 1");
	JButton btn2 = new JButton("Button 2");
	JButton btn3 = new JButton("Vis billede");
	JLabel label = new JLabel("No buttons have been clicked", JLabel.CENTER);
	public Gui() {
		// Window properties
		setLayout(new FlowLayout());
		setSize(300, 100);
		setTitle("Family Tree");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Actions
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn2.addActionListener(this);
		
		// Buttons
		add(btn1);
		add(btn2);
		add(btn3);
		add(label);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			label.setText("btn1 was clicked");
		} else if (e.getSource() == btn2) {
			label.setText("btn2 was clicked");
		} else if (e.getSource() == btn3) {
			
			
		}
	}
}
