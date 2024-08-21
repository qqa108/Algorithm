import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int arr[][];
    static boolean visit[][];
    static int di[] = {
            0,
            -1,
            0,
            1,
            0
    };
    static int dj[] = {
            0,
            0,
            1,
            0,
            -1
    };
    static int answer, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;
        sum = 0;
        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int idx) {
        if (idx == 3) {
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    boolean check = true;

                    for (int d = 0; d < 5; d++) {
                        int nx = i + di[d];
                        int ny = j + dj[d];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny]) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        for (int d = 0; d < 5; d++) {
                            int nx = i + di[d];
                            int ny = j + dj[d];
                            visit[nx][ny] = true;
                            sum = sum + arr[nx][ny];
                        }
                        dfs(idx + 1);
                        for (int d = 0; d < 5; d++) {
                            int nx = i + di[d];
                            int ny = j + dj[d];
                            visit[nx][ny] = false;
                            sum = sum - arr[nx][ny];
                        }
                    }
                }
            }
        }
    }
}