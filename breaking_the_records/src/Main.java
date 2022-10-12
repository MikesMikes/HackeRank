import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/three-month-preparation-kit-breaking-best-and-worst-records/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=three-month-preparation-kit&playlist_slugs%5B%5D=three-month-week-one

public class Main {
    public static void main(String[] args) throws IOException {
        String res = "9\n" + "10 5 20 20 4 5 2 25 1\n";
        ByteArrayInputStream arr = new ByteArrayInputStream(res.getBytes());
        read(arr);

    }

    private static List<Integer> breakingRecords(List<Integer> scores) {

        List<Integer> result = new ArrayList<>();

        int less = 0;
        int more = 0;
        int lowest = scores.get(0);
        int highiest = lowest;

        for (int i = 1; i < scores.size(); i++) {
            if (scores.get(i) > highiest) {
                more++;
                highiest = scores.get(i);
            } else if (scores.get(i) < lowest) {
                less++;
                lowest = scores.get(i);
            }
        }

        result.add(more);
        result.add(less);

        System.out.println(result);
        return result;
    }

    public static void read(ByteArrayInputStream args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(args));


        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = breakingRecords(scores);

        bufferedReader.close();

    }

}