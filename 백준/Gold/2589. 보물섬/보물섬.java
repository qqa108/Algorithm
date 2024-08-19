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
	static boolean visit[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 'L') {
					visit = new boolean[N][M];
					bfs(i, j);
				}
			}
		}
		System.out.println(answer);
	}

	static class Point {
		int x;
		int y;
		int count;

		public Point(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	static void bfs(int x, int y) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(x, y, 0));
		visit[x][y] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			boolean check = false;

			for (int i = 0; i < 4; i++) {
				int nextx = now.x + di[i];
				int nexty = now.y + dj[i];
				if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M && !visit[nextx][nexty]
						&& arr[nextx][nexty] == 'L') {
					queue.add(new Point(nextx, nexty, now.count + 1));
					visit[nextx][nexty] = true;
					check = true;
				}
			}
			if (!check) {
				answer = Math.max(answer, now.count);
			}
		}
	}
}