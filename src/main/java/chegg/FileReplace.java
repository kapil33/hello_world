package chegg;

import java.io.*;
import java.util.*;

public class FileReplace {
    List<String> lines = new ArrayList<String>();
    String line = null;

    public void  replace() {
        try {
            File f1 = new File("/Users/kapilchoudhary/IdeaProjects/HelloWorld/src/resources/file.txt");
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                if (line.contains("NY"))
                    line = line.replace("NY", "New York");
                if (line.contains("NJ"))
                    line = line.replace("NJ", "New Jersey");
                if (line.contains("CT"))
                    line = line.replace("CT", "Connecticut");
                lines.add(line);
            }
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(f1);
            BufferedWriter out = new BufferedWriter(fw);
            for(String s : lines) {
                out.write(s);
                out.newLine();
            }
            out.flush();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        FileReplace fr = new FileReplace();
        fr.replace();
    }
}
