import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = "100\n" +
                "63 25 73 1 98 73 56 84 86 57 16 83 8 25 81 56 9 53 98 67 99 12 83 89 80 91 39 86 76 85 74 39 25 90 59 10 94 32 44 3 89 30 27 79 46 96 27 32 18 21 92 69 81 40 40 34 68 78 24 87 42 69 23 41 78 22 6 90 99 89 50 30 20 1 43 3 70 95 33 46 44 9 69 48 33 60 65 16 82 67 61 32 21 79 75 75 13 87 70 33";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        read(byteArrayInputStream);
    }

    private static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> list = new ArrayList<>(Collections.nCopies(100, 0));

        for (int i = 0; i < arr.size(); i++) {
            int arrValue = arr.get(i);
            list.set(arrValue, list.get(arrValue) + 1);
        }

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int listIndexValue = list.get(i);
            if (listIndexValue > 0) {
                values.add(i);
            }
        }
        Collections.sort(values);

//        System.out.println(values);
//        System.out.println(list);
        return list;
    }

    public static void read(ByteArrayInputStream input) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = countingSort(arr);


        bufferedReader.close();

    }
}