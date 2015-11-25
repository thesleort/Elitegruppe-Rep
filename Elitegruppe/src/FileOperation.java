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
	public ArrayList FileRead(String fileName) throws IOException {
		File file = new File(fileName);
		FileInputStream FiStream;
		ArrayList<String> namesToSort = new ArrayList<String>();
		try {
			FileInputStream fiStream = new FileInputStream(file);
			DataInputStream diStream = new DataInputStream(fiStream);
			BufferedReader br = new BufferedReader(new InputStreamReader(diStream));

			String currentLine;

			while ((currentLine = br.readLine()) != null) {
				// spilts each line into a first and last name.
				String[] parts = currentLine.split(" ");
				// spilts the first name into letters
				String[] partname = currentLine.split("");
				// stores the first letter of the name in "firstname"
				String firstname = partname[1];
				// stores the last name in the string "lastname"
				String lastname = parts[1];
				// combines the string and prints it.
				System.out.println(firstname + ". " + lastname);
				// debudding line
				// System.out.println(strline);
				currentLine = firstname + ". " + lastname;
				namesToSort.add(currentLine);

			}
			diStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("There where no file with the name " + fileName);
			e.printStackTrace();
		}
		return (namesToSort);
	}

	public ArrayList<String> Sort(ArrayList<String> listToSort) {
		Collections.sort(listToSort);
		return listToSort;

	}

	public void FileWriteArray(ArrayList<String> arrayOfNames, String fileName)
			throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		for (int i = 0; i < arrayOfNames.size(); i++) {
			writer.println(arrayOfNames.get(i));
		}
		writer.close();
	}
}