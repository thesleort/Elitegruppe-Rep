package ui;

import java.io.File;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;

public class FileSelector extends JFrame {

	private static final long serialVersionUID = 1L;
	public static File chosenFile;

	public FileSelector() {
		JFileChooser fileChooser = new JFileChooser();
		// Programmet leder efter filer der slutter med .ff
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Family Tree files, .ff", "ff");

		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(null);
		// Hvis der bliver trykket cancel, retunerer programmet ikke noget.
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// Da swing ikke tillader multi-threading, venter fileChooser her
			// på, at man vælger en fil vha. APPROVE_OPTION.
			chosenFile = fileChooser.getSelectedFile();
			// til debugging
			System.out.println("You chose to open this file: " + fileChooser.getSelectedFile());

		} else if (returnVal == JFileChooser.CANCEL_OPTION) {
			System.out.println("Cancel was selected");
			chosenFile = null;
		}
	}

}
