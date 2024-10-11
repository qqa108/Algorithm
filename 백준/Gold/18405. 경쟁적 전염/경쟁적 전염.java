import java.util.*;
import java.io.*;

public class Main {
    static int N, K, S, X, Y;
    static Point arr[][];
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new Point[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = new Point(val, 0);
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;

        int count = 0;
        for (int c = 0; c < S; c++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j].val != 0 && arr[i][j].cnt == count) {
                        for (int d = 0; d < 4; d++) {
                            int nx = i + di[d];
                            int ny = j + dj[d];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (arr[nx][ny].val == 0) {
                                    arr[nx][ny] = new Point(arr[i][j].val, count + 1);
                                }
                                else {
                                    if (arr[nx][ny].cnt == count + 1 && arr[nx][ny].val > arr[i][j].val) {
                                        arr[nx][ny] = new Point(arr[i][j].val, count + 1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            count++;

        }
        System.out.print(arr[X][Y].val);
    }

    static class Point {
        int val, cnt;

        Point(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
}