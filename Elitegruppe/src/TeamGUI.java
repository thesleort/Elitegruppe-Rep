//import libs needed
import java.io.*;

//defines the class
public class TeamGUI{
	//defines the void
    public static void main(String[] args){
    	//try (says what it does itself
        try{
        	//opens the file with the names in it
            File file = new File("names.txt");
            //prints the path to the file
            System.out.println(file.getCanonicalPath());
            //loads the file into 
            FileInputStream fileinnputstream = new FileInputStream(file);
            DataInputStream innputstream = new DataInputStream(fileinnputstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(innputstream));
            String strline;
            //processes the file
            while((strline = br.readLine()) != null){
               	String[] parts = strline.split(" ");
               	String[] partname = strline.split("");
               	String firstname = partname[0];
               	String lastname = parts[1];
                System.out.println(firstname+". "+lastname);	
            //    System.out.println(strline);
            }
            in.close();
        }catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}