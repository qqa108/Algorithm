import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean visit[];
    static int result[];
    static boolean num[];
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visit = new boolean[10];
        result = new int[10];
        num = new boolean[10];
        Arrays.fill(num, true);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                num[tmp] = false;
            }
        }

        answer = Integer.MAX_VALUE;
        subset(0);
        System.out.println(answer);
    }

    static void subset(int idx) {
        if (idx == 6) {
            int sum = 0;
            int count = 0;
            boolean check = false;

            for (int i = 0; i < 10; i++) {
                if (visit[i]) {
                    check = true;
                    sum = (10 * sum) + result[i];
                    count++;
                }
            }
            if (!check) {
                long dif = Math.abs(N - 100);
                answer = Math.min(answer, dif);
                return;
            }
            long dif = Math.abs(N - sum) + count;
            answer = Math.min(answer, dif);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (num[i]) {
                visit[idx] = true;
                result[idx] = i;
                subset(idx + 1);
            }
            visit[idx] = false;
            result[idx] = 0;
            subset(idx + 1);
        }
    }
}