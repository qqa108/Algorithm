import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int T;
	static int arr[][];
	static boolean visit[][][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int count = 0;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit = new boolean[2][N][M];

		bfs();

		if (answer == Integer.MAX_VALUE) {
			System.out.println("Fail");
		}
		else {
			System.out.println(answer);
		}

	}

	static class Point {
		int x;
		int y;
		int item;

		public Point(int x, int y, int item) {
			this.x = x;
			this.y = y;
			this.item = item;
		}
	}

	static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0, 0, 0));
		visit[0][0][0] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				if(arr[now.x][now.y]== 2 ) {
					now.item = 1;
				}

				if (now.x == N - 1 && now.y == M - 1 && count <= T) {
					answer = count;
					return;
				}

				for (int i = 0; i < 4; i++) {
					int nextx = now.x + di[i];
					int nexty = now.y + dj[i];
					if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M) {
						if (now.item == 0 && !visit[0][nextx][nexty] && arr[nextx][nexty] != 1) {
							queue.add(new Point(nextx, nexty, 0));
							visit[0][nextx][nexty] = true;
						}
						else if (now.item == 1 && !visit[1][nextx][nexty]) {
							queue.add(new Point(nextx, nexty, 1));
							visit[1][nextx][nexty] = true;
						}
					}
				}
			}
			count++;
		}
	}
}