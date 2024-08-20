import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static int arr[][];
	static boolean visit[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int maxhome = 0;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			maxhome = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visit = new boolean[N][N];
					bfs(i, j);
				}
			}
			sb.append("#" + test_case + " " + maxhome + "\n");
		}
		System.out.println(sb);

		br.close();
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
		int idx = 0;
		int home = 0;
		if (arr[x][y] == 1) {
			home++;
		}
		queue.add(new Point(x, y, 1));
		visit[x][y] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			if (now.count > idx) {
				idx++;
				int sum = home * M - (idx * idx + (idx - 1) * (idx - 1));
				if (sum >= 0 && home > maxhome) {
					maxhome = home;
				}
			}

			for (int i = 0; i < 4; i++) {
				int nextx = now.x + di[i];
				int nexty = now.y + dj[i];
				if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < N && !visit[nextx][nexty]) {
					if (arr[nextx][nexty] == 1) {
						home++;
					}
					queue.add(new Point(nextx, nexty, now.count + 1));
					visit[nextx][nexty] = true;
				}
			}
		}
	}
}