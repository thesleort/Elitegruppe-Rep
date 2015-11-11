//import libs needed
import java.awt.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

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
            FileInputStream ft = new FileInputStream(file);
            DataInputStream in = new DataInputStream(ft);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            //processing part
            //defines the string for storing the line in 
   /*         String strline;
    * while((strline = br.readLine()) != null){
            while((strline = br.readLine()) != null){
            	//spilts each line into a first and last name.
               	String[] parts = strline.split(" ");
               	//spilts the first name into letters
               	String[] partname = strline.split("");
               	//stores the first letter of the name in "firstname"
               	String firstname = partname[0];
               	//stores the last name in the string "lastname"
               	String lastname = parts[1];
               	//combines the string and prints it.
                System.out.println(firstname+". "+lastname);	
                //debudding line
            //    System.out.println(strline);
            }
    */        
            String strline;
            ArrayList thingtosort = new ArrayList();
            while((strline = br.readLine()) != null){
            	thingtosort.add(strline);
            	System.out.println(thingtosort);
            }
            Collections.sort(thingtosort);
            System.out.println(thingtosort);
            in.close();
            
            PrintWriter writer = new PrintWriter("sortedname.txt", "UTF-8");
            writer.println(thingtosort);
            writer.close();
            
        }catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}