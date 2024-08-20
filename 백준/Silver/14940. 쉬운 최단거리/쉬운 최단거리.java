import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int arr[][];
    static Queue<Point> queue = new ArrayDeque<>();
    static boolean visit[][];
    static int answer[][];
    static int di[] = {
            -1,
            0,
            1,
            0
    };
    static int dj[] = {
            0,
            1,
            0,
            -1
    };

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M];
        answer = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    queue.add(new Point(i, j));
                    visit[i][j] = true;
                }
            }
        }
        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visit[i][j] && arr[i][j] == 1) {
                    sb.append(-1 + " ");
                }
                else {
                    sb.append(answer[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + di[i];
                    int ny = now.y + dj[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 1 && !visit[nx][ny]) {
                        answer[nx][ny] = answer[nx][ny] + count;
                        queue.add(new Point(nx, ny));
                        visit[nx][ny] = true;
                    }
                }
            }
            count++;
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}