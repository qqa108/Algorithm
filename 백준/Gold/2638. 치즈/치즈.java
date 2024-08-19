import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int arr[][];
	static int visit[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int remain = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					remain++;
				}
			}
		}

		int day = 0;
		while (true) {
			if (remain == 0) {
				break;
			}
			visit = new int[N][M];
			bfs();
			day++;
		}
		System.out.println(day);
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0, 0));
		visit[0][0] = 1;

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextx = now.x + di[i];
				int nexty = now.y + dj[i];
				if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M) {
					if (visit[nextx][nexty] == 0 && arr[nextx][nexty] == 0) {
						queue.add(new Point(nextx, nexty));
						visit[nextx][nexty]++;
					}
					else if (arr[nextx][nexty] == 1) {
						visit[nextx][nexty]++;
						if (visit[nextx][nexty] >= 2) {
							arr[nextx][nexty] = 0;
							remain--;
							if (remain == 0) {
								return;
							}
						}
					}
				}
			}
		}
	}
}