import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K;
	static int N;
	static int M;
	static int arr[][];
	static boolean visit[][][];
	static int di[] = { -1, 0, 1, 0, -2, -1, 1, 2, 2, 1, -1, -2 };
	static int dj[] = { 0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1 };
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[K + 1][N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}

	static class Point {
		int x;
		int y;
		int horse;

		public Point(int x, int y, int horse) {
			this.x = x;
			this.y = y;
			this.horse = horse;
		}
	}

	static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0, 0, K));
		visit[K][0][0] = true;
		int count = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				if (now.x == N - 1 && now.y == M - 1) {
					answer = count;
					return;
				}

				for (int i = 0; i < 12; i++) {
					int nextx = now.x + di[i];
					int nexty = now.y + dj[i];
					if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M && arr[nextx][nexty] == 0) {
						if (i < 4 && !visit[now.horse][nextx][nexty]) {
							queue.add(new Point(nextx, nexty, now.horse));
							visit[now.horse][nextx][nexty] = true;
						}
						else if (now.horse > 0 && !visit[now.horse - 1][nextx][nexty]) {
							queue.add(new Point(nextx, nexty, now.horse - 1));
							visit[now.horse - 1][nextx][nexty] = true;
						}
					}
				}
			}
			if (answer != Integer.MAX_VALUE) {
				break;
			}
			count++;
		}
	}
}