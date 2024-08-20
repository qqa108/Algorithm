import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int arr[][];
	static boolean visit[][];
	static Queue<Point> queue;
	static int sx, sy;
	static int ex, ey;
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int answer;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			visit = new boolean[N][N];
			queue = new ArrayDeque<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			queue.add(new Point(sx, sy));
			visit[sx][sy] = true;
			st = new StringTokenizer(br.readLine());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());

			answer = -1;
			bfs();
			sb.append('#').append(test_case).append(' ').append(answer).append('\n');
		}
		System.out.println(sb);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void bfs() {
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				if (now.x == ex && now.y == ey) {
					answer = count;
					return;
				}

				for (int i = 0; i < 4; i++) {
					int nextx = now.x + di[i];
					int nexty = now.y + dj[i];
					if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < N) {
						if (arr[nextx][nexty] == 0 && !visit[nextx][nexty]) {
							queue.add(new Point(nextx, nexty));
							visit[nextx][nexty] = true;
						}
						else if (arr[nextx][nexty] == 2) {
							if (count % 3 == 2 && !visit[nextx][nexty]) {
								queue.add(new Point(nextx, nexty));
							}
							else {
								queue.add(now);
							}
						}
					}
				}
			}
			count++;
		}
	}
}