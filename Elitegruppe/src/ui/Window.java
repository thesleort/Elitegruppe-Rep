package ui;

import javax.swing.JFrame;

public class Window extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Window() {
		JFrame window = new JFrame("Family Tree");
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.add(new Gui());
		window.pack();
		window.setVisible(true);
	}

}
