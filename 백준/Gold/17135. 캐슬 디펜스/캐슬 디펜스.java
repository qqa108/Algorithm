import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int D;
	static int arr[][];
	static int copy[][];
	static int result[];
	static int di[] = { -1, 0, 0 };
	static int dj[] = { 0, 1, -1 };
	static int enemy = 0;
	static int remain = 0;
	static int kill = 0;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M];
		result = new int[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					enemy++;
				}
			}
		}
		comb(0, 0);
		System.out.println(answer);
	}

	static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.y == o.y) {
				return this.x - o.x;
			}
			else {
				return this.y - o.y;
			}
		}
	}

	static void comb(int idx, int start) {
		if (idx == 3) {
			remain = enemy;
			kill = 0;
			int count = 0;
			int up = 0;
			copy = new int[N + 1][M];
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					copy[i][j] = arr[i][j];
				}
			}

			while (true) {
				if (remain <= 0 || N - up <= 0) {
					break;
				}
				bfs(N - up, result[0]);
				bfs(N - up, result[1]);
				bfs(N - up, result[2]);

				for (int i = 0; i <= N - up; i++) {
					for (int j = 0; j < M; j++) {
						if (i == N - up && copy[i][j] == 1) {
							remain--;
						}
						if (copy[i][j] == 2) {
							kill++;
							remain--;
							copy[i][j] = 0;
						}
						else if (copy[i][j] == 1) {
							count++;
						}
					}
				}
				if (count == 0) {
					break;
				}
				up++;
			}
			answer = Math.max(answer, kill);

			return;
		}
		for (int i = start; i < M; i++) {
			result[idx] = i;
			comb(idx + 1, i + 1);
		}
	}

	static void bfs(int T, int b) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(T, b));
		boolean visit[][] = new boolean[T][M];

		int dis = 0;

		while (!queue.isEmpty()) {
			if (dis > D) {
				break;
			}

			PriorityQueue<Point> ene = new PriorityQueue<>();
			int size = queue.size();

			for (int q = 0; q < size; q++) {
				Point now = queue.poll();

				if (copy[now.x][now.y] == 1 || copy[now.x][now.y] == 2) {
					ene.add(new Point(now.x, now.y));
				}

				for (int i = 0; i < 3; i++) {
					int nexti = now.x + di[i];
					int nextj = now.y + dj[i];
					if (nexti >= 0 && nexti < T && nextj >= 0 && nextj < M && !visit[nexti][nextj]) {
						queue.add(new Point(nexti, nextj));
						visit[nexti][nextj] = true;
					}
				}

			}
			if (!ene.isEmpty()) {
				Point target = ene.poll();
				copy[target.x][target.y] = 2;
				break;
			}
			dis++;
		}

	}
}