import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char arr[][];
	static boolean visit[][];
	static int result[][];
	static Queue<Point> queue = new ArrayDeque<>();
	static Queue<Point> wall = new ArrayDeque<>();
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new boolean[N][M];
		result = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[i][j] = (int) arr[i][j] - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && arr[i][j] == '0') {
					visit[i][j] = true;
					queue.add(new Point(i, j));
					bfs();
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(result[i][j]%10);
			}
			sb.append('\n');
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
		int count = 1;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + di[i];
				int ny = now.y + dj[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
					if (arr[nx][ny] == '0') {
						visit[nx][ny] = true;
						queue.add(new Point(nx, ny));
						count++;
					} else if (arr[nx][ny] == '1') {
						visit[nx][ny] = true;
						wall.add(new Point(nx, ny));
					}
				}
			}
		}
		while (!wall.isEmpty()) {
			Point now = wall.poll();
			result[now.x][now.y] = result[now.x][now.y] + count;
			visit[now.x][now.y] = false;
		}
	}
}