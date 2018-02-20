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
        ArrayList<String> st = new ArrayList<>();
        ArrayList<Integer> pi = new ArrayList<>();

        Path path = Paths.get("./pi.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.readLine();
            reader.readLine();
            int a;
            while ((a = Character.getNumericValue((char) reader.read())) != -1) {
                pi.add(a);
            }
        } catch (IOException ex) {
            ex.printStackTrace(); //handle an exception here
        }
        System.out.println(pi.size());
        for(int i = 0;i<pi.size();i++){
            if (pi.get(i)== 0 && pi.get(i+1)!=0){
                StringBuilder s = new StringBuilder();
                for(int j=i;j<i+10;j++){
                    s.append(pi.get(j));
                }
                st.add(s.toString());
            }
        }
        System.out.println(st.size());
        System.out.println(st.get(0));
    }
}
