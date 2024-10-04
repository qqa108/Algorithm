import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N + 1][M];
        int start[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            start[i] = 0;
        }

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int i = x; i <= N; i = i + x) {
                if (d == 0) {
                    start[i] = (start[i] + M - k) % M;
                } else {
                    start[i] = (start[i] + k) % M;
                }
            }
            Queue<Point> queue = new ArrayDeque<>();
            double sum = 0;
            int sumcount = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < M; j++) {
                    int now = (start[i] + j) % M;
                    int right = (now + 1) % M;
                    int up = (start[(i + 1) % (N + 1)] + j) % M;
                    sum = sum + arr[i][now];
                    if (arr[i][now] != 0) {
                        sumcount++;
                    }

                    if (arr[i][now] != 0) {
                        if (arr[i][now] == arr[i][right]) {
                            queue.add(new Point(i, now));
                            queue.add(new Point(i, right));
                        }
                        if (i != N && arr[i][now] == arr[i + 1][up]) {
                            queue.add(new Point(i, now));
                            queue.add(new Point(i + 1, up));
                        }
                    }
                }
            }

            if (queue.isEmpty()) {
                sum = sum / sumcount;
                for (int i = 1; i <= N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (arr[i][j] != 0) {
                            if (arr[i][j] > sum) {
                                arr[i][j]--;
                            } else if (arr[i][j] < sum) {
                                arr[i][j]++;
                            }
                        }
                    }
                }
            } else {
                while (!queue.isEmpty()) {
                    Point p = queue.poll();
                    arr[p.x][p.y] = 0;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                answer = answer + arr[i][j];
            }
        }
        System.out.println(answer);
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}