import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Point> queue = new ArrayDeque<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if (c == 'O') {
                    arr[i][j] = 1;
                }
            }
        }

        for (int t = 1; t <= T; t++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (t % 2 == 0 && arr[i][j] == 0) {
                        arr[i][j] = 1;
                    }
                    else if (t % 2 != 0 && arr[i][j] >= 3) {
                        queue.add(new Point(i, j));
                    }
                    if (arr[i][j] != 0) {
                        arr[i][j]++;
                    }
                }
            }
            while (!queue.isEmpty()) {
                Point now = queue.poll();
                for (int d = 0; d < 5; d++) {
                    int ni = now.x + di[d];
                    int nj = now.y + dj[d];
                    if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                        arr[ni][nj] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    System.out.print(".");
                }
                else {
                    System.out.print("O");
                }
            }
            System.out.println();
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