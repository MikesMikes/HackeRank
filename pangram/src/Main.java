import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = "We promptly judged antique ivory buckles for the next prize\n" +
                "\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        main(byteArrayInputStream);

    }

    public static String pangrams(String s) {
        // Write your code here
        char[] chars = s.toLowerCase().replace(" ", "").toCharArray();
        Set<Character> uniqueChars = new HashSet<>();
        for (char i : chars) {
            uniqueChars.add(i);
        }

        if (uniqueChars.size() == 26) {
            return "pangram";
        }

        return "not pangram";
    }

    public static void main(ByteArrayInputStream args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(args));

        String s = bufferedReader.readLine();

        String result = pangrams(s);

        bufferedReader.close();
    }
}