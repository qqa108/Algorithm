import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, W, L;
    static int arr[];
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        bfs();
        System.out.println(count);
    }

    static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        int sum = 0;
        int i = 0;

        while (true) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Point now = queue.poll();
                if (now.time < W) {
                    queue.add(new Point(now.x, now.time + 1));
                }
                else {
                    sum = sum - arr[now.x];
                }
            }
            if (i < N && sum + arr[i] <= L) {
                queue.add(new Point(i, 1));
                sum = sum + arr[i];
                i++;
            }
            count++;
            if (queue.isEmpty() && i == N) {
                return;
            }
        }
    }

    static class Point {
        int x;
        int time;

        Point(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}