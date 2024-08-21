import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Food arr[];
    static boolean visit[];
    static StringBuilder sb;
    static int mp, mf, ms, mv, mc;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        arr = new Food[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] = new Food(p, f, s, v, c);
        }

        mc = Integer.MAX_VALUE;
        dfs(0);

        if (mc == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(mc);
            System.out.println(sb);
        }
    }

    static void dfs(int idx) {
        if (idx == N) {
            StringBuilder tmp = new StringBuilder();
            int p = 0, f = 0, s = 0, v = 0, c = 0;
            for (int i = 0; i < N; i++) {
                if (visit[i]) {
                    p = p + arr[i].p;
                    f = f + arr[i].f;
                    s = s + arr[i].s;
                    v = v + arr[i].v;
                    c = c + arr[i].c;
                    tmp.append(i + 1).append(' ');
                }
            }
            if (p >= mp && f >= mf && s >= ms && v >= mv) {
                if (mc > c || (mc == c && sb.toString().compareTo(tmp.toString()) > 0)) {
                    sb.setLength(0);
                    sb = tmp;
                    mc = c;
                }
            }
            return;
        }
        visit[idx] = true;
        dfs(idx + 1);
        visit[idx] = false;
        dfs(idx + 1);
    }

    static class Food {
        int p;
        int f;
        int s;
        int v;
        int c;

        Food(int p, int f, int s, int v, int c) {
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.c = c;
        }
    }
}