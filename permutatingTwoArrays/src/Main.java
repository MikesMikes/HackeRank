import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = "2\n" +
                "3 10\n" +
                "2 1 3\n" +
                "7 8 9\n" +
                "4 5\n" +
                "1 2 2 1\n" +
                "3 3 3 4";

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        main(byteArrayInputStream);
    }

    public static String twoArrays(int k, List<Integer> a, List<Integer> b) {

        a.sort(Integer::compareTo);
        b.sort(Collections.reverseOrder());

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) + b.get(i) < k){
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(ByteArrayInputStream args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(args));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = twoArrays(k, A, B);
                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }


}