import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N;
	static int M;
	static boolean visit[][] = new boolean[2][500001];
	static int answer;
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		bfs();

		System.out.println(answer);

		sc.close();
	}

	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(N);
		visit[0][N] = true;

		int count = 0;
		int end = M;
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (end > 500000) {
				answer = -1;
				return;
			}

			if (visit[count % 2][end]) {
				answer = count;
				return;
			}
			count++;
			end = end + count;
			for (int s = 0; s < size; s++) {
				int now = queue.poll();
				if (now * 2 <= 500000 && !visit[count % 2][now * 2]) {
					queue.add(2 * now);
					visit[count % 2][now * 2] = true;
				}
				if (now + 1 <= 500000 && !visit[count % 2][now + 1]) {
					queue.add(now + 1);
					visit[count % 2][now + 1] = true;
				}
				if (now - 1 >= 0 && !visit[count % 2][now - 1]) {
					queue.add(now - 1);
					visit[count % 2][now - 1] = true;
				}
			}
		}
	}
}