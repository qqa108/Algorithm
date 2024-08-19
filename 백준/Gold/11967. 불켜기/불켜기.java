import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean visit[][];
	static boolean on[][];
	static List<Point> arr[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int answer = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1][N + 1];
		visit = new boolean[N + 1][N + 1];
		on = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int fromx = Integer.parseInt(st.nextToken());
			int fromy = Integer.parseInt(st.nextToken());
			int tox = Integer.parseInt(st.nextToken());
			int toy = Integer.parseInt(st.nextToken());
			arr[fromx][fromy].add(new Point(tox, toy));
		}
		bfs();
		System.out.println(answer);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(1, 1));
		visit[1][1] = true;
		on[1][1] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int i = 0; i < arr[now.x][now.y].size(); i++) {
				Point next = arr[now.x][now.y].get(i);

				if (!on[next.x][next.y]) {
					on[next.x][next.y] = true;

					for (int d = 0; d < 4; d++) {
						int nx = next.x + di[d];
						int ny = next.y + dj[d];
						if (nx > 0 && nx <= N && ny > 0 && ny <= N && visit[nx][ny]) {
							queue.add(new Point(next.x, next.y));
							visit[next.x][next.y] = true;
							break;
						}
					}
					answer++;
				}
			}

			for (int d = 0; d < 4; d++) {
				int nx = now.x + di[d];
				int ny = now.y + dj[d];
				if (nx > 0 && nx <= N && ny > 0 && ny <= N && on[nx][ny] && !visit[nx][ny]) {
					queue.add(new Point(nx, ny));
					visit[nx][ny] = true;
				}
			}
		}
	}
}