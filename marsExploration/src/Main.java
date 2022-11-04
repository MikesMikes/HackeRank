import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = "SOSSPSSQSSOR";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        main(byteArrayInputStream);

    }

    public static int marsExploration(String s) {
        // Write your code here
        String mod = "";
        int changedLetters = 0;
        for (int i = 0; i < s.length(); i++) {
            mod += s.charAt(i);
            if (mod.length() % 3 == 0) {
                if (!mod.equals("SOS")) {
                    if (mod.charAt(0) != 'S') {
                        changedLetters++;
                    }
                    if (mod.charAt(1) != 'O') {
                        changedLetters++;
                    }
                    if (mod.charAt(2) != 'S') {
                        changedLetters++;
                    }
                }
                mod = "";
            }
        }
        return changedLetters;
    }

    public static void main(ByteArrayInputStream args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(args));


        String s = bufferedReader.readLine();

        int result = marsExploration(s);
        System.out.println(result);

        bufferedReader.close();
    }
}
