import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int di[] = {0, 0, 1, 1, 2, 2};
    static int dj[] = {1, 2, 0, 2, 0, 1};
    static int dk[] = {2, 1, 2, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        Queue<Point> queue = new ArrayDeque<>();
        boolean visit[][] = new boolean[1501][1501];
        int answer = 0;
        queue.add(new Point(A, B, C));
        visit[A][B] = true;
        visit[A][C] = true;
        visit[B][A] = true;
        visit[B][C] = true;
        visit[C][A] = true;
        visit[C][B] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int arr[] = {now.x, now.y, now.z};

            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                answer = 1;
                break;
            }
            for (int i = 0; i < 6; i++) {
                int x = arr[di[i]];
                int y = arr[dj[i]];
                if (x < y && y - x >= 0 && !visit[x + x][y - x]) {
                    queue.add(new Point(x + x, y - x, arr[dk[i]]));
                    visit[x + x][y - x] = true;
                }
            }
        }

        System.out.println(answer);

        sc.close();
    }

    static class Point {
        int x, y, z;

        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}