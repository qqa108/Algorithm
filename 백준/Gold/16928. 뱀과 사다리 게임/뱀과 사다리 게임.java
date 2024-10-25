import java.util.*;
import java.io.*;

public class Main {
    static int arr[];
    static int answer;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[101];
        for (int i = 1; i <= 100; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from] = to;
        }
        answer = 0;
        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[101];
        queue.add(1);
        visit[1] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                int now = queue.poll();

                for (int i = 1; i <= 6; i++) {
                    if (now + i >= 100 || (now + i < 100 && arr[now + i] >= 100)) {
                        answer = count;
                        return;
                    }
                    if (!visit[arr[now + i]]) {
                        queue.add(arr[now + i]);
                        visit[arr[now + i]] = true;
                    }
                }
            }
            count++;
        }
    }
}