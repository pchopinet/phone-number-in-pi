import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class Pi {

    ArrayList<String> st = new ArrayList<>();
    ArrayList<Integer> pi = new ArrayList<>();

    public Pi(String file) {
        Path path = Paths.get(file);
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

        for (int i = 0; i < pi.size(); i++) {
            if (pi.get(i) == 0 && pi.get(i + 1) != 0) {
                StringBuilder s = new StringBuilder();
                for (int j = i; j < i + 10; j++) {
                    s.append(pi.get(j));
                }
                st.add(s.toString());
            }
        }

    }

    public boolean check_number(String number) {
        return st.contains(number);
    }


    public static void main(String[] args) {
        System.out.println("Creating index...");
        Pi p = new Pi("pi.txt");

        Scanner sc = new Scanner(System.in);
        String line;
        do {
            System.out.println("Enter a number");
            line = sc.nextLine();
            if (line.length() == 10 && line.charAt(0) == '0') {
                System.out.println(p.check_number(line));
            } else {
                System.out.println("Not a phone number");
            }
        } while (!line.equals("q"));
    }
}
