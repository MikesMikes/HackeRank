import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = "3\n" +
                "11 2 4\n" +
                "4 5 6\n" +
                "10 8 -12";
        ByteArrayInputStream arr = new ByteArrayInputStream(input.getBytes());
        read(arr);
    }

    private static int diagonalDifference(List<List<Integer>> arr) {
        int forwardDiagonal = 0;
        int backwardDiagonal = 0;
        for (int i = 0, k = arr.size()-1; i < arr.size(); i++, k--) {
            for (int j = 0; j < arr.size(); j++) {
                if (j == i) {
                    forwardDiagonal += arr.get(i).get(i);
                    backwardDiagonal += arr.get(i).get(k);
                }
            }
        }

        return Math.abs(forwardDiagonal - backwardDiagonal);
    }

    public static void read(ByteArrayInputStream input) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = diagonalDifference(arr);

        System.out.println(result);

        bufferedReader.close();
    }


}