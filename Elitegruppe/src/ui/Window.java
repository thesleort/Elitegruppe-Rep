package ui;

import javax.swing.JFrame;

public class Window extends JFrame{
	public Window() {
		JFrame window = new JFrame("Family Tree");
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.add(new Gui());
		window.pack();
		window.setVisible(true);
	}

}
