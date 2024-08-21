import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int di[] = {
            0,
            -1,
            0,
            1
    };
    static int dj[] = {
            1,
            0,
            -1,
            0
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        boolean visit[][] = new boolean[101][101];

        for (int i = 0; i < N; i++) {
            List<Point> point = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            point.add(new Point(x, y));
            visit[x][y] = true;
            point.add(new Point(x + di[d], y + dj[d]));
            visit[x + di[d]][y + dj[d]] = true;

            for (int j = 0; j < age; j++) {
                Point last = point.get(point.size() - 1);
                int size = point.size();

                for (int k = size-2; k >=0; k--) {
                    int nx = point.get(k).y - last.y;
                    int ny = -(point.get(k).x - last.x);

                    point.add(new Point(last.x + nx, last.y + ny));
                    visit[last.x + nx][last.y + ny] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (visit[i][j] && visit[i + 1][j] && visit[i][j + 1] && visit[i + 1][j + 1]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}