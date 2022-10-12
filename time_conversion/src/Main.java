import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String time = "12:05:45PM";
//        time = "06:40:03AM";
//        time = "12:40:22AM";
        time = "12:45:54PM";
        System.out.println(time);
        time = solution(time);
        System.out.println(time);
    }

    private static String solution(String time) {

        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);
        int sec = Integer.parseInt(times[2].substring(0, 2));
        if (hour == 12) {
            hour = 0;
        }

        if (time.contains("PM")){
            hour += 12;
        }

        if (hour == 24) {
            if (min > 0) {
                hour = 0;
            }
        }


        return (hour < 10 ? "0" + hour : hour) + ":" + (min < 10 ? "0" + min : min) + ":" + (sec < 10 ? "0" + sec : sec);
    }


}