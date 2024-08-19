import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int visit[];
	static int answer = Integer.MAX_VALUE;
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new int[100001];
		Arrays.fill(visit, Integer.MAX_VALUE);
		bfs();

		System.out.println(answer);
		System.out.println(count);

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
		visit[N] = 0;

		while (true) {
			if (queue.isEmpty()) {
				break;
			}

			Num now = queue.poll();
			if (now.num == M) {
				count++;
			}
			if (now.num * 2 <= 100000 && visit[now.num * 2] >= now.count + 1) {
				queue.add(new Num(now.num * 2, now.count + 1));
				visit[now.num * 2] = now.count + 1;
			}
			if (now.num + 1 <= 100000 && visit[now.num + 1] >= now.count + 1) {
				queue.add(new Num(now.num + 1, now.count + 1));
				visit[now.num + 1] = now.count + 1;
			}
			if (now.num - 1 >= 0 && visit[now.num - 1] >= now.count + 1) {
				queue.add(new Num(now.num - 1, now.count + 1));
				visit[now.num - 1] = now.count + 1;
			}
		}
		answer = visit[M];
	}
}