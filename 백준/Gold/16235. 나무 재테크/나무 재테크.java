import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int di[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dj[] = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][N];
        int plus[][] = new int[N][N];
        Deque<Tree> queue = new ArrayDeque<>();
        Queue<Tree> dead = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], 5);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                plus[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            queue.add(new Tree(x, y, age));
        }

        for (int k = 0; k < K; k++) {

            int size = queue.size();   //봄
            for (int s = 0; s < size; s++) {
                Tree now = queue.poll();
                if (arr[now.x][now.y] < now.age) {
                    dead.add(now);
                } else {
                    arr[now.x][now.y] = arr[now.x][now.y] - now.age;
                    queue.add(new Tree(now.x, now.y, now.age + 1));
                }
            }

            size = dead.size();   //여름
            for (int s = 0; s < size; s++) {
                Tree now = dead.poll();
                arr[now.x][now.y] = arr[now.x][now.y] + now.age / 2;
            }

            size = queue.size();   //가을
            Queue<Tree> tmp = new ArrayDeque<>();
            for (int s = 0; s < size; s++) {
                Tree now = queue.poll();
                if (now.age % 5 == 0) {
                    tmp.add(now);
                }
                queue.add(now);
            }
            while (!tmp.isEmpty()) {
                Tree now = tmp.poll();
                for (int d = 0; d < 8; d++) {
                    int x = now.x + di[d];
                    int y = now.y + dj[d];
                    if (x >= 0 && x < N && y >= 0 && y < N) {
                        queue.addFirst(new Tree(x, y, 1));
                    }
                }
            }

            for (int i = 0; i < N; i++) {   //겨울
                for (int j = 0; j < N; j++) {
                    arr[i][j] = arr[i][j] + plus[i][j];
                }
            }
        }
        System.out.println(queue.size());
    }

    static class Tree implements Comparable<Tree> {
        int x, y, age;

        Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
}