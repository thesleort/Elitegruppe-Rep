

import java.io.*;

public class TeamGUI{
    public static void main(String[] args){
        try{
            File file = new File("names.txt");
            System.out.println(file.getCanonicalPath());
            FileInputStream ft = new FileInputStream(file);

            DataInputStream in = new DataInputStream(ft);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strline;

            while((strline = br.readLine()) != null){
                System.out.println(strline);
            }
            in.close();
        }catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}