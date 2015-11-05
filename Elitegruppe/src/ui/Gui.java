package ui;
import java.awt.*;
import javax.swing.*;
import java.awt.Event;

public class Gui {
	public static void startGui() {
		JFrame frame = new JFrame("Family Tree");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	     JLabel emptyLabel = new JLabel("");
	     emptyLabel.setPreferredSize(new Dimension(175, 100));
	     frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
	
	     //Display the window.
	     frame.pack();
	     frame.setVisible(true);
	}
}
