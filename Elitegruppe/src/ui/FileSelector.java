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
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Family Tree files", "ff"); 	//Programmet leder efter filer
		fileChooser.setFileFilter(filter);															//der slutter med .ff
		int returnVal = fileChooser.showOpenDialog(null);	//Hvis der bliver trykket cancel, retunerer programmet ikke noget.						
		if (returnVal == JFileChooser.APPROVE_OPTION) { 	//Da swing ikke tillader multi-threading, venter fileChooser her på,
			chosenFile = fileChooser.getSelectedFile();		//at man vælger en fil.
			System.out.println("You chose to open this file: " + fileChooser.getSelectedFile());	//til debugging
		}
	}

}
