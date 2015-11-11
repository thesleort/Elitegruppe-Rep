import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Readfile {
	private String path;
	public Readfile(String file_path) {
		path = file_path;
	}
	
	public String[] OpenFile() throws IOException {
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		int numberOfLines = 3;
		String[] textData = new String[numberOfLines];
		
		int i;
		
		for (i=0; i < numberOfLines; i++) {
				textData[i] = textReader.readLine();
				}
		textReader.close();
		return textData;
	}
	
	//Scanner read = new read("names.txt");
}
