import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author MikesMikes
 * @problem https://www.hackerrank.com/challenges/maximum-perimeter-triangle/problem
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String input = "50\n" +
                "585864 30960 397193 982469 275301 815633 500552 1980053 4956083 563585 619528 879603 467531 927141 393527 917709 350333 54529145 7932125 963208 520081 142767080 499865 582730 512174 20820393 575285 592595 33708702 364190 289354 351506 995836 228962 326149 2975979 420118 984155 620289 508798 199101 517109 12888237 88237927 928368 137821 825743 274447 411970 951836";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        main(byteArrayInputStream);

    }

    /**
     * sort it in natural order.
     * traverse the list from the end looking for a + b > c 
     * @param sticks
     * @return array of a + b > c or array[-1]
     */
    private static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        sticks.sort(Comparator.naturalOrder());
        for (int i = sticks.size() - 1; i >= 0; i--) {
            if (i - 2 >= 0) {
                int num1 = sticks.get(i - 2);
                int num2 = sticks.get(i - 1);
                if (num1 + num2 > sticks.get(i)){
                    return new ArrayList<>(Arrays.asList(num1, num2, sticks.get(i)));
                }
            }

        }
        return new ArrayList<>(Arrays.asList(-1));
    }

    public static void main(ByteArrayInputStream args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(args));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = maximumPerimeterTriangle(sticks);

        bufferedReader.close();
    }

}