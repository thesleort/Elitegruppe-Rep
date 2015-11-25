import java.io.IOException;
import java.util.ArrayList;

import ui.Gui;

public class FamilyTree {

	public static void main(String[] args) {
		System.out.println("Starting program...");
		//Gui gui = new Gui(); Denne er fjernet, da det ikke kører noget brugbart ligenu.
		System.out.println("GUI has started.");
		FileOperation fileop = new FileOperation();
		try {
			ArrayList<String> names = fileop.FileRead("names.txt");
			fileop.FileWrite(names,"SortedName");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
