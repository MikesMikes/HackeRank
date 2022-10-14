import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = "4\n" +
                "aba\n" +
                "baba\n" +
                "aba\n" +
                "xzxb\n" +
                "3\n" +
                "aba\n" +
                "xzxb\n" +
                "ab";
        ByteArrayInputStream inputByteArr = new ByteArrayInputStream(input.getBytes());
        read(inputByteArr);
    }

    private static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

        List<Integer> matches = new ArrayList<>();

        for (String i : queries) {
            int match = 0;
            for (String j : strings){
                if (i.equals(j)){
                    match++;
                }
            }
            matches.add(match);
        }

        return matches;
    }


    public static void read(ByteArrayInputStream args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(args));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> res = matchingStrings(strings, queries);


        bufferedReader.close();
    }

}