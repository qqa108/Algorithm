import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char arr[][];
	static int visit[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new char[N][N];
		visit = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();
			Arrays.fill(visit[i], Integer.MAX_VALUE);
		}
		bfs();
		System.out.println(visit[N - 1][N - 1]);
	}

	static class Point {
		int x, y, c;

		public Point(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0, 0, 0));
		visit[0][0] = 0;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			if (now.x == N - 1 && now.y == N - 1) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = now.x + di[i];
				int ny = now.y + dj[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && visit[nx][ny] > now.c) {
					if (arr[nx][ny] == '1') {
						queue.add(new Point(nx, ny, now.c));
						visit[nx][ny] = now.c;
					}
					else {
						queue.add(new Point(nx, ny, now.c + 1));
						visit[nx][ny] = now.c + 1;
					}
				}
			}
		}
	}
}