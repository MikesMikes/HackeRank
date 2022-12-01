import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author MikesMikes
 * @Problem https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String input = "5 4\n" +
                "1 2 3 4 5";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        main(byteArrayInputStream);
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here

        for (int i = 0; i < d; i++){
            arr.add(arr.size()-1, arr.remove(0));
        }

        return arr;
    }

    public static void main(ByteArrayInputStream args) throws IOException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(args));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = rotateLeft(d, arr);


        bufferedReader.close();

    }
}