import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char arr[][];
	static int visit[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int min = Integer.MAX_VALUE;
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();
		}
		bfs();

		if (min != Integer.MAX_VALUE) {
			answer = min;
		}
		System.out.println(answer);
	}

	static class Point {
		int x;
		int y;
		int wall;
		int count;

		public Point(int x, int y, int wall, int count) {
			this.x = x;
			this.y = y;
			this.wall = wall;
			this.count = count;
		}

	}

	static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0, 0, 2, 1));

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			if (now.x == N - 1 && now.y == M - 1) {
				min = Math.min(min, now.count);
			}

			for (int i = 0; i < 4; i++) {
				int nexti = now.x + di[i];
				int nextj = now.y + dj[i];
				if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M
						&& (visit[nexti][nextj] == 0 || (now.wall == 2 && visit[nexti][nextj] == 1))) {
					visit[nexti][nextj] = now.wall;
					if (arr[nexti][nextj] == '1' && now.wall == 2) {
						queue.add(new Point(nexti, nextj, 1, now.count + 1));
					} else if (arr[nexti][nextj] == '0') {
						queue.add(new Point(nexti, nextj, now.wall, now.count + 1));
					}
				}
			}
		}
	}
}