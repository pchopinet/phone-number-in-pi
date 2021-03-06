import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class Pi {

    private Set<Integer> numbers = new TreeSet<>();

    public Pi(String file) {
        Path path = Paths.get(file);

        long debut;
        long fin;

        ArrayList<Byte> pi = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.readLine();
            reader.readLine();

            debut = System.currentTimeMillis();
            System.out.print("Reading Pi...");
            byte a;
            while ((a = (byte) Character.getNumericValue((char) reader.read())) != -1) {
                pi.add(a);
            }
            fin = System.currentTimeMillis();
            System.out.println("Done ! " + (fin - debut) / 1000 + "sec");
        } catch (IOException ex) {
            ex.printStackTrace(); //handle an exception here
        }

        debut = System.currentTimeMillis();
        System.out.print("Finding Phone Number...");
        for (int i = 0; i < pi.size(); i++) {
            if (pi.get(i) == 0 && pi.get(i + 1) != 0) {
                StringBuilder s = new StringBuilder();
                for (int j = i; j < i + 10; j++) {
                    s.append(pi.get(j));
                }
                numbers.add(Integer.parseInt(s.toString()));
            }
        }
        pi.clear();
        fin = System.currentTimeMillis();
        System.out.println("Done ! " + (fin - debut) / 1000 + "sec");
        System.out.println(numbers.size() + " numbers found");

    }

    public boolean check_number(Integer number) {
        return numbers.contains(number);
    }


    public static void main(String[] args) {
        Pi p = new Pi("pi.txt");

        Scanner sc = new Scanner(System.in);
        String line;
        do {
            System.out.println("Enter a number");
            line = sc.nextLine();
            if (line.length() == 10 && line.charAt(0) == '0') {
                System.out.println(p.check_number(Long.parseLong(line)));
            } else {
                System.out.println("Not a phone number");
            }
        } while (!line.equals("q"));
    }
}
