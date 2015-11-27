package base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
				// splits each line into a first and last name.
				String[] parts = currentLine.split(" ");
				// splits the first name into letters
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
				} else {
					middlename = "";
					lastname = parts[1];
				}
				// Kombinerer det hele til én streng.
				currentLine = firstname + ". " + middlename + lastname;
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

	public ArrayList<String> Sort(ArrayList<String> listToSort) {
		// Sortering af liste.
		Collections.sort(listToSort);
		return listToSort;

	}

	public void FileWriteArray(ArrayList<String> arrayOfNames, File fileName)
			throws FileNotFoundException, UnsupportedEncodingException {
		// Skrivning af ny fil.
		System.out.println(arrayOfNames);

		try {
			FileWriter writer = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(writer);
			for (int i = 0; i < arrayOfNames.size(); i++) {
				bw.write(arrayOfNames.get(i));
				System.out.println(arrayOfNames.get(i));
				bw.newLine();
			}
			bw.flush();
			bw.close();
			writer.close();

			System.out.println("Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// fiStream.println(arrayOfNames.get(i));
	}

}
