import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char arr[] = s.toCharArray();

        int N = arr.length;
        int start = N - 2;
        int answer = (2 * N) - 1;

        for (int i = start; i >= 0; i--) {
            int left = i;
            int right = i + 1;
            boolean check = true;

            while (true) {
                if (right >= N) {
                    break;
                }
                if (left < 0) {
                    check = false;
                    break;
                }
                if (arr[left] != arr[right]) {
                    check = false;
                    break;
                }
                left--;
                right++;
            }

            if (check) {
                answer = Math.min(answer, (i + 1) * 2);
            }

            left = i - 1;
            right = i + 1;
            check = true;

            while (true) {
                if (right >= N) {
                    break;
                }
                if (left < 0) {
                    check = false;
                    break;
                }
                if (arr[left] != arr[right]) {
                    check = false;
                    break;
                }
                left--;
                right++;
            }
            if (check) {
                answer = Math.min(answer, (i * 2) + 1);
            }
        }
        System.out.println(answer);
    }
}