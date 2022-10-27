import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws IOException {

        String string = "4\n" +
                "73\n" +
                "67\n" +
                "38\n" +
                "33";
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(string.getBytes());
        read(arrayInputStream);
    }

    private static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> results = new ArrayList<>();
        for (int i : grades) {
            if (i < 38) {
                results.add(i);
            } else if ((i + 1) % 5 == 0) {
                results.add(i + 1);
            } else if ((i + 2) % 5 == 0) {
                results.add(i + 2);
            } else {
                results.add(i);
            }
        }

        return results;
    }


    public static void read(ByteArrayInputStream input) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = gradingStudents(grades);




        bufferedReader.close();
    }


}