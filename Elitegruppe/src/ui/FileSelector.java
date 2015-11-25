package ui;

import java.io.File;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;

public class FileSelector extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static File chosenFile;

	public FileSelector() {

		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Family Tree files", "ff");
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			chosenFile = fileChooser.getSelectedFile();
			System.out.println("You chose to open this file: " + fileChooser.getSelectedFile());
		}
	}

}
