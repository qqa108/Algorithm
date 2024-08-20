import java.util.*;

public class Solution {

    static int[][] arr;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int startRoom;
    static int minRoom;
    static int maxCnt;
    static int moveCnt; //이동할 수 있는 방의 개수

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {

            N = sc.nextInt();

            arr = new int[N][N];
//            list = new ArrayList<>();
//            result = new Info(Integer.MAX_VALUE, Integer.MIN_VALUE);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            maxCnt = 0;
            minRoom = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    moveCnt = 1;

                    startRoom = arr[i][j];    //시작하는 방번호 가지고 있기.

                    bfs(i, j);

                    if (moveCnt > maxCnt) {
                        maxCnt = moveCnt;
                        minRoom = startRoom;
                    } else if (moveCnt == maxCnt) {
                        if (minRoom > startRoom) {
                            minRoom = startRoom;
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + minRoom + " " + maxCnt);

        }
    }

    public static void bfs(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int d = 0; d < dx.length; d++) {
                int nexti = point.i + dx[d];
                int nextj = point.j + dy[d];
                int num = arr[point.i][point.j];

                if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N &&
                        arr[nexti][nextj] == (num + 1)) {
                    queue.add(new Point(nexti, nextj));
                    moveCnt++;
                }
            }
        }
    }
    public static class Point {
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}