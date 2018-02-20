import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class Pi {

    Set<String> st = new TreeSet<>();
    ArrayList<Integer> pi = new ArrayList<>();

    public Pi(String file) {
        Path path = Paths.get(file);
        System.out.print("Openning file...");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            System.out.println("Done !");
            reader.readLine();
            reader.readLine();
            System.out.print("Reading Pi...");
            int a;
            while ((a = Character.getNumericValue((char) reader.read())) != -1) {
                pi.add(a);
            }
            System.out.println("Done !");
        } catch (IOException ex) {
            ex.printStackTrace(); //handle an exception here
        }
        System.out.print("Finding Phone Number...");
        for (int i = 0; i < pi.size(); i++) {
            if (pi.get(i) == 0 && pi.get(i + 1) != 0) {
                StringBuilder s = new StringBuilder();
                for (int j = i; j < i + 10; j++) {
                    s.append(pi.get(j));
                }
                st.add(s.toString());
            }
        }
        System.out.println("Done !");
        System.out.println(st.size() + " numbers found");

    }

    public boolean check_number(String number) {
        return st.contains(number);
    }


    public static void main(String[] args) {
        System.out.println("Creating index...");
        Pi p = new Pi("pi2.txt");

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
