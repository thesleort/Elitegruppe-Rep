package base;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;

public class FileOperation {
	ArrayList<String> namesToSort;

	public ArrayList<String> FileRead(File fileName) throws IOException {

		try {

			namesToSort = new ArrayList<String>();
			FileInputStream fiStream = new FileInputStream(fileName);
			DataInputStream diStream = new DataInputStream(fiStream);
			BufferedReader br = new BufferedReader(new InputStreamReader(diStream));

			String currentLine;

			while ((currentLine = br.readLine()) != null) {
				int lineLength;
				// spilts each line into a first and last name.
				String[] parts = currentLine.split(" ");
				// spilts the first name into letters
				String[] partname = currentLine.split("");
				// stores the first letter of the name in "firstname"
				String firstname = partname[1];
				lineLength = parts.length;
				// stores the last name in the string "lastname"
				String lastname;
				String middlename;
				if (lineLength > 2) {
					middlename = parts[1];
					for (int i = 2; i < lineLength - 1; i++) {
						middlename = middlename + " " + parts[i];
						System.out.println(middlename);

					}
					middlename = middlename + " ";
					lastname = parts[parts.length - 1];
					System.out.println(lastname);
				} else {
					middlename = "";
					lastname = parts[1];
				}
				// combines the string and prints it.
				// System.out.println(firstname + ". " + lastname);
				currentLine = firstname + ". " + middlename +lastname;
				namesToSort.add(currentLine);

			}
			diStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("There where no file with the name " + fileName);
			System.out.println("Shutting program down.");
			e.printStackTrace();
		}
		return namesToSort;
	}

	public ArrayList<String> Sort(ArrayList<String> listToSort) { // Sortering
																	// af liste.
		Collections.sort(listToSort);
		return listToSort;

	}

	public void FileWriteArray(ArrayList<String> arrayOfNames, String fileName) // Skrivning
																				// af
																				// ny
																				// fil.
			throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		for (int i = 0; i > arrayOfNames.size(); i++) {
			writer.println(arrayOfNames.get(i));
		}
		writer.close();
	}
}
