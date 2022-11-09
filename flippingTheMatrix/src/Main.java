import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
//https://www.hackerrank.com/challenges/flipping-the-matrix/problem


public class Main {
    public static void main(String[] args) throws IOException {
        String input = "1\n" +
                "2\n" +
                "112 42 83 119\n" +
                "56 125 56 49\n" +
                "15 78 101 43\n" +
                "62 98 114 108";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        main(byteArrayInputStream);

    }

    /*
    iReverse is the mirror index. i.e. For matrix size = 4. i = 0, iReverse = 3, matrix size max index.
    Traverses one quadrant and checks for a higher number in the other quadrants.
     */
    public static int flippingMatrix(List<List<Integer>> matrix) {

        int quadrantSize = matrix.size() / 2;
        int quadrantSum = 0;
        for (int i = 0, iReverse = matrix.size() - 1; i < quadrantSize; i++, iReverse--) {
            for (int k = 0, kReverse = matrix.size() - 1; k < quadrantSize; k++, kReverse--) {
                int quadrantPiece = matrix.get(i).get(k);
                quadrantPiece = quadrantPiece > matrix.get(i).get(kReverse) ? quadrantPiece : matrix.get(i).get(kReverse);
                quadrantPiece = quadrantPiece > matrix.get(iReverse).get(k) ? quadrantPiece : matrix.get(iReverse).get(k);
                quadrantPiece = quadrantPiece > matrix.get(iReverse).get(kReverse) ? quadrantPiece : matrix.get(iReverse).get(kReverse);
                quadrantSum += quadrantPiece;
            }
        }

        return quadrantSum;
    }

    public static void main(ByteArrayInputStream args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(args));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = flippingMatrix(matrix);

                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}