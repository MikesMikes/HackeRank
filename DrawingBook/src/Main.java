import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author MikesMikes
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String input = "6\n" +
                "5";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        main(byteArrayInputStream);
    }

    /**
     * i.e. n = 10, p = 4
     * 0    1     2     3   4    5  -- page turns
     * 0.1, 2.3, 4.5, 6.7, 8.9, 10.0  -- page numbers
     * answer: to get to pages 4.5 you have to turn 2 pages. pages 2.3 needs 1-page turn. That means p/2 for p<= n/2.
     * i.e. n = 10, p =6, 9
     * p > n/2 = true
     * n/2 = 5
     * p/2 = 3, 4
     * answer: to get to page 3 you need to 1-page turns. page 4 you need 2-page turns. n-p is true for both.
     */
    public static int pageCount(int n, int p) {
        // Write your code here
        if (p<n/2){ //minimum page turns is always p/2.
            return p / 2;
        } else {
            return (n/2) - (p/2);
        }
    }

    public static void main(ByteArrayInputStream args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(args));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = pageCount(n, p);

        bufferedReader.close();
    }
}