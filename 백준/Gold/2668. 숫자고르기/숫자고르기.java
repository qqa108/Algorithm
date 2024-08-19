import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int []arr;
    static boolean []visit;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for(int i=1; i<=N; i++) {
            visit = new boolean[N+1];
            visit[i] = true;
            flag = false;
            dfs(i, arr[i]);

            if(flag) {
                count++;
                sb.append(i).append('\n');
            }
        }
        System.out.println(count);
        System.out.print(sb);
    }

    static void dfs(int now, int next) {
        if(now == next) {
            flag = true;
            return;
        }
        if(!visit[next]) {
            visit[next] = true;
            dfs(now, arr[next]);
        }
    }
}