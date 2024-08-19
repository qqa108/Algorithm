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
	static Queue<Point> queue = new ArrayDeque<>();
	static Queue<Point> fire = new ArrayDeque<>();
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 'J') {
					queue.add(new Point(i, j));
					visit[i][j] = true;
				}
				else if (arr[i][j] == 'F') {
					fire.add(new Point(i, j));
				}
			}
		}

		bfs();
		if (answer == -1) {
			System.out.println("IMPOSSIBLE");
		}
		else {
			System.out.println(answer);
		}
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
			int size = fire.size();
			for (int s = 0; s < size; s++) {
				Point now = fire.poll();

				for (int i = 0; i < 4; i++) {
					int nextx = now.x + di[i];
					int nexty = now.y + dj[i];
					if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M && arr[nextx][nexty] == '.') {
						fire.add(new Point(nextx, nexty));
						arr[nextx][nexty] = 'F';
					}
				}
			}

			size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nextx = now.x + di[i];
					int nexty = now.y + dj[i];
					if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M) {
						if (!visit[nextx][nexty] && arr[nextx][nexty] == '.') {
							queue.add(new Point(nextx, nexty));
							visit[nextx][nexty] = true;
						}
					}
					else {
						answer = count;
						return;
					}
				}
			}
			count++;
		}
	}
}