import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        String arr[] = new String[10];
        arr[3] = "1+2-3\n";
        arr[4] = "1-2-3+4\n";
        arr[5] = "1 2-3-4-5\n";
        arr[6] = "1 2+3-4-5-6\n";
        arr[7] = "1+2-3+4-5-6+7\n" +
                "1+2-3-4+5+6-7\n" +
                "1-2 3+4+5+6+7\n" +
                "1-2 3-4 5+6 7\n" +
                "1-2+3+4-5+6-7\n" +
                "1-2-3-4-5+6+7\n";
        arr[8] = "1 2-3 4-5 6+7 8\n" +
                "1+2 3-4 5+6+7+8\n" +
                "1+2+3+4-5-6-7+8\n" +
                "1+2+3-4+5-6+7-8\n" +
                "1+2-3+4+5+6-7-8\n" +
                "1+2-3-4-5-6+7+8\n" +
                "1-2 3-4+5+6+7+8\n" +
                "1-2+3-4-5+6-7+8\n" +
                "1-2-3+4+5-6-7+8\n" +
                "1-2-3+4-5+6+7-8\n";
        arr[9] = "1 2+3 4-5 6-7+8+9\n" +
                "1 2+3+4-5-6-7+8-9\n" +
                "1 2+3-4 5+6+7+8+9\n" +
                "1 2+3-4+5-6+7-8-9\n" +
                "1 2-3+4+5 6-7 8+9\n" +
                "1 2-3+4+5+6-7-8-9\n" +
                "1 2-3-4-5+6-7-8+9\n" +
                "1 2-3-4-5-6+7+8-9\n" +
                "1+2-3 4-5 6+7 8+9\n" +
                "1-2 3-4-5 6-7+8 9\n" +
                "1-2-3 4+5+6+7+8+9\n";

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(arr[N]).append('\n');
        }
        System.out.print(sb);
    }
}