import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class pi {

    public static void main(String[] args) {
        Set<String> st = new TreeSet<>();
        Path path = Paths.get("./pi.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.readLine();
            reader.readLine();
            int a;
            while ((a = Character.getNumericValue((char) reader.read())) != -1) {
               if (a == 0){
                   a = Character.getNumericValue((char) reader.read());
                   if (a!=0) {
                       StringBuilder s = new StringBuilder();
                       s.append(0);
                       s.append(a);
                       for (int i = 0; i < 8; i++) {
                           s.append(Character.getNumericValue((char) reader.read()));
                       }
                       //System.out.println(s.toString());
                       st.add(s.toString());
                   }
               }
            }
            System.out.println(a);
        } catch (IOException ex) {
            ex.printStackTrace(); //handle an exception here
        }
        System.out.println(st.size());
        Iterator itr = st.iterator();
        System.out.println(itr.next());

    }
}
