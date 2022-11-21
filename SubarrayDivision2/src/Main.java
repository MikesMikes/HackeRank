import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author MikesMikes
 * @Problem https://www.hackerrank.com/challenges/the-birthday-bar/problem
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String input = "";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        main(byteArrayInputStream);
    }

    /**
     *loop once through s while adding to a LinkedList, list.
     * If the list size matches d perform a check if the sum of the list matches d and
     * if so increment var ways.
     * Using LinkedList.pop removes first element of the list and next iteration will
     * fulfil condition of list.size == d
     *
     * @param s list of unordered integers
     * @param d sum of integers to match
     * @param m limit of numbers to use in order
     * @return int of how many ways we can match d and m using numbers in s
     */
    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int ways = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < s.size(); i++) {
            if (list.size() != m) {
                list.add(s.get(i));
            } else {
                int sum = list.stream()
                        .reduce(Integer::sum)
                        .get();
                if (sum == d) {
                    ways++;
                }
                list.pop();
            }
        }

        return ways;
    }

//    public static int birthday(List<Integer> s, int d, int m) {
//        return (int) IntStream.rangeClosed(0, s.size()-m)
//                .filter(i -> d==IntStream.range(i, i+m).map(s::get).sum())
//                .count();
//    }

    public static void main(ByteArrayInputStream args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] sTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sTemp[i]);
            s.add(sItem);
        }

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = birthday(s, d, m);


        bufferedReader.close();

    }
}