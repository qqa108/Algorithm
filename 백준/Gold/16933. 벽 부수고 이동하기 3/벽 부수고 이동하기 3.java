import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static char arr[][];
	static boolean visit[][][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new boolean[K + 1][N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();
		}
		bfs();
		System.out.println(answer);
	}

	static class Point {
		int x, y, w, count;

		public Point(int x, int y, int w, int count) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.count = count;
		}
	}

	static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		visit[K][0][0] = true;
		queue.add(new Point(0, 0, 1, K));

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			if (now.x == N - 1 && now.y == M - 1) {
				answer = now.w;
				return;
			}

			boolean check = false;
			for (int i = 0; i < 4; i++) {
				int nx = now.x + di[i];
				int ny = now.y + dj[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (now.w % 2 == 1) {
						if (now.count > 0 && !visit[now.count - 1][nx][ny] && arr[nx][ny] == '1') {
							visit[now.count - 1][nx][ny] = true;
							queue.add(new Point(nx, ny, now.w + 1, now.count - 1));
						}
						else if (!visit[now.count][nx][ny] && arr[nx][ny] == '0') {
							visit[now.count][nx][ny] = true;
							queue.add(new Point(nx, ny, now.w + 1, now.count));
						}
					}
					else {
						if (now.count > 0 && arr[nx][ny] == '1') {
							check = true;
						}
						if (!visit[now.count][nx][ny] && arr[nx][ny] == '0') {
							visit[now.count][nx][ny] = true;
							queue.add(new Point(nx, ny, now.w + 1, now.count));
						}
					}
				}
			}
			if (check) {
				queue.add(new Point(now.x, now.y, now.w + 1, now.count));
			}
		}
	}
}