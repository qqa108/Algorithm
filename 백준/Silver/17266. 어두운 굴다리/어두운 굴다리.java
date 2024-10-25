import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int max = 0;
        int pre = 0;
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (i == 0) {
                max = num;
                pre = num;
                continue;
            }

            max = Math.max(max, (num - pre + 1) / 2);
            pre = num;
        }
        max = Math.max(max, N - pre);
        System.out.println(max);
    }
}