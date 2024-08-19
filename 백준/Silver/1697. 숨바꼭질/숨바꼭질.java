import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static boolean visit[];
	static int delta[] = { N, 1, -1 };
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new boolean[100001];
		bfs();

		System.out.println(answer);

		sc.close();
	}

	static class Num {
		int num;
		int count;

		public Num(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}

	static void bfs() {
		Queue<Num> queue = new ArrayDeque<>();
		queue.add(new Num(N, 0));
		visit[N] = true;

		while (true) {
			if (queue.isEmpty()) {
				break;
			}

			Num now = queue.poll();
			if (now.num == M) {
				answer = now.count;
				break;
			}
			delta[0] = now.num;
			for (int i = 0; i < 3; i++) {
				if (now.num + delta[i] >= 0 && now.num + delta[i] <= 100000 && !visit[now.num + delta[i]]) {
					visit[now.num + delta[i]] = true;
					queue.add(new Num(now.num + delta[i], now.count + 1));
				}
			}
		}
	}
}