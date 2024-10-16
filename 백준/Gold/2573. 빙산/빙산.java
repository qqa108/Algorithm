import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int arr[][];
    static boolean visit[][];
    static Queue<Point> queue;
    static int di[] = {-1, 0, 1, 0};
    static int dj[] = {0, 1, 0, -1};
    static int count;
    static int ans;
    static int answer;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    queue.add(new Point(i, j));
                }
            }
        }
        ans = 0;
        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Point> melt = new ArrayDeque<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            visit = new boolean[N][M];
            count = 0;
            Point check = queue.peek();
            dfs(check.x, check.y);

            if (size != count) {
                answer = ans;
                return;
            }

            for (int s = 0; s < size; s++) {
                Point now = queue.poll();
                int cnt = 0;

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + di[i];
                    int ny = now.y + dj[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0) {
                        cnt++;
                    }
                }
                int dif = arr[now.x][now.y] - cnt;
                if (dif <= 0) {
                    dif = 0;
                } else {
                    queue.add(new Point(now.x, now.y));
                }
                melt.add(new Point(now.x, now.y, dif));
            }

            while (!melt.isEmpty()) {
                Point tmp = melt.poll();
                arr[tmp.x][tmp.y] = tmp.h;
            }
            ans++;
        }


    }

    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + di[i];
            int ny = y + dj[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny] && arr[nx][ny] != 0) {
                count++;
                visit[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    static class Point {
        int x, y, h;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}