import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, D;
    static Point arr[];
    static boolean visit[];
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new Point[N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr[i] = new Point(s, e, d);
        }
        Arrays.sort(arr);
        answer = Integer.MAX_VALUE;
        dfs(0, -1);
        System.out.println(answer);
    }

    static void dfs(int idx, int end) {
        if (idx == N) {
            int sum = D;
            for (int i = 0; i < N; i++) {
                if (visit[i]) {
                    sum = sum - (arr[i].e - arr[i].s) + arr[i].d;
                }
            }
            answer = Math.min(answer, sum);
            return;
        }
        if (arr[idx].e <= D && end <= arr[idx].s) {
            visit[idx] = true;
            dfs(idx + 1, arr[idx].e);
        }
        visit[idx] = false;
        dfs(idx + 1, end);
    }

    static class Point implements Comparable<Point> {
        int s, e, d;

        public Point(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Point o) {
            if (this.s == o.s) {
                if (this.e == o.e) {
                    return this.d - o.d;
                }
                return this.e - o.e;
            }
            return this.s - o.s;
        }
    }
}