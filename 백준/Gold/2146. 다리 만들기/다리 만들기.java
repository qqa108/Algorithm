import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int arr[][];
    static boolean visit[][];
    static Queue<Point> queue = new ArrayDeque<>();
    static int di[] = {-1, 0, 1, 0};
    static int dj[] = {0, 1, 0, -1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[N][N];
        int num = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = num;
                    dfs(i, j, num);
                    num++;
                }
            }
        }

        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] > 1) {
                    queue.clear();
                    visit = new boolean[N][N];
                    queue.add(new Point(i, j, arr[i][j]));
                    visit[i][j] = true;
                    bfs(arr[i][j]);
                }
            }
        }

        System.out.println(answer);
    }

    static class Point {
        int x, y, num;

        public Point(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static void dfs(int x, int y, int num) {
        for (int d = 0; d < 4; d++) {
            int nx = x + di[d];
            int ny = y + dj[d];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny] && arr[nx][ny] == 1) {
                arr[nx][ny] = num;
                visit[nx][ny] = true;
                dfs(nx, ny, num);
            }
        }
    }

    static void bfs(int base) {
        int count = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point now = queue.poll();
                if (now.num != 0 && now.num != base) {
                    answer = Math.min(answer, count);
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = now.x + di[d];
                    int ny = now.y + dj[d];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny] && arr[nx][ny] != base) {
                        queue.add(new Point(nx, ny, arr[nx][ny]));
                        visit[nx][ny] = true;
                    }
                }
            }
            count++;
        }

    }
}