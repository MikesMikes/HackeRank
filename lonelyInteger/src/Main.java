import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = "3\n" +
                "1 1 2";
        ByteArrayInputStream inputByteArr = new ByteArrayInputStream(input.getBytes());
        read(inputByteArr);
    }

    public static int lonelyinteger(List<Integer> a) {
        Map<Integer, Integer> map = new HashMap<>();
        int lonely = 0;
        for (int i : a) {
            int val = map.getOrDefault(i, 0);
            map.put(i, val + 1);
        }
        for (Map.Entry i : map.entrySet()){
            int val = (int) i.getValue();
            if (val == 1){
                lonely = (int) i.getKey();
            }
        }

        return lonely;
    }

    public static void read(ByteArrayInputStream args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(args));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = lonelyinteger(a);

        bufferedReader.close();
    }


}