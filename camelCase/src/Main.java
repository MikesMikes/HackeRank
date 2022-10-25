import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String line = "C;V;mobile phone";
        line = "C;M;white sheet of paper";
        line = "C;C;coffee machine";
        line = "S;M;plasticCup()";
        line = "S;C;LargeSoftwareBook";
        line = "S;V;pictureFrame";
        line = "S;V;iPad";
        line = "C;M;mouse pad";
        line = "C;C;code swarm";
        line = "S;C;OrangeHighlighter";
        line = "C;V;can of coke";
        format(line);
    }

    private static void format(String line) {

        Scanner scanner = new Scanner(System.in);
        String input = "x";
        while (scanner.hasNext()) {
            input = scanner.nextLine();
            solution(input);
        }
    }

    public static void solution(String input){
        String[] parts = input.split(";");
        String operation = parts[0];
        String stringType = parts[1];
        StringBuilder result = new StringBuilder();

        if (operation.equals("C")) {
            String[] words = parts[2].split(" ");
            result = new StringBuilder(words[0]);

            for (int i = 1; i < words.length; i++) {
                StringBuilder word = new StringBuilder(words[i]);
                word = word.replace(0, 1, word.substring(0, 1).toUpperCase());
                result.append(word);
            }

            if (stringType.equals("C")) {
                result.replace(0, 1, result.substring(0, 1).toUpperCase());
            } else if (stringType.equals("M")) {
                result.append("()");
            }
        }
        if (operation.equals("S")) {
            String word = parts[2];
            char[] inputChars = word.toCharArray();
            List<String> words = new ArrayList<>();
            int startingIndex = 0;
            for (int i = 0; i < inputChars.length; i++) {
                if (Character.isUpperCase(inputChars[i]) && i != 0){
                    words.add(word.substring(startingIndex, i));
                    startingIndex = i;
                } else if (i == inputChars.length - 1) {
                    words.add(word.substring(startingIndex));
                }
            }
            //only M is a special case due to having parenthesis
            if (stringType.equals("M")) {
                String lastWord = words.get(words.size() - 1);
                words.set(words.size() - 1, lastWord.substring(0, lastWord.length() - 2));
            }
            for (String i : words) {
                if (!i.equals(words.get(words.size() - 1))) {
                    result.append(i.toLowerCase() + " ");
                } else {
                    result.append(i.toLowerCase());
                }
            }
        }

        System.out.println(result);
    }
}