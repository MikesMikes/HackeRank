import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/three-month-preparation-kit-divisible-sum-pairs/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-one

public class Main {
    public static void main(String[] args) throws IOException {
        String input = "6 3\n" +
                "1 3 2 6 1 2";
        ByteArrayInputStream byteArrInput = new ByteArrayInputStream(input.getBytes());
        read(byteArrInput);
    }

    private static int divisibleSumPairs(int n, int k, List<Integer> ar) {

        int pair = 0;

        for (int i = 0; i < ar.size(); i++) {
            int j = i + 1;
            while (j < ar.size()) {
                if ((ar.get(i) + ar.get(j)) % k == 0) {
                    pair++;
                }
//                System.out.println(ar.get(i) + " " + ar.get(j) + ": " + ((ar.get(i) + ar.get(j)) % k == 0));
                j++;
            }
        }
        System.out.println(pair);
        return pair;
    }

    public static void read(ByteArrayInputStream args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(args));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());


        int result = divisibleSumPairs(n, k, ar);

        bufferedReader.close();
    }


}