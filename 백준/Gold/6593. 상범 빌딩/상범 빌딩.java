import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int H;
	static int N;
	static int M;
	static char arr[][][];
	static boolean visit[][][];
	static Queue<Point> queue;
	static Point E;
	static int di[] = { -1, 0, 1, 0, 0, 0 };
	static int dj[] = { 0, 1, 0, -1, 0, 0 };
	static int dk[] = { 0, 0, 0, 0, 1, -1 };
	static int answer;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if (H == 0 && N == 0 && M == 0) {
				break;
			}

			queue = new ArrayDeque<>();
			arr = new char[H][N][M];
			visit = new boolean[H][N][M];
			for (int k = 0; k < H; k++) {
				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(br.readLine());
					String s = st.nextToken();
					arr[k][i] = s.toCharArray();
					for (int j = 0; j < M; j++) {
						if (arr[k][i][j] == 'S') {
							queue.add(new Point(i, j, k));
							visit[k][i][j] = true;
						}
						else if (arr[k][i][j] == 'E') {
							E = new Point(i, j, k);
						}
					}
				}
				st = new StringTokenizer(br.readLine());
			}
			answer = -1;
			bfs();
			if (answer == -1) {
				sb.append("Trapped!").append('\n');
			}
			else {
				sb.append("Escaped in ").append(answer).append(" minute(s).").append('\n');
			}
		}
		System.out.println(sb);
	}

	static class Point {
		int x, y, z;

		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static void bfs() {
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				if (now.x == E.x && now.y == E.y && now.z == E.z) {
					answer = count;
					return;
				}

				for (int i = 0; i < 6; i++) {
					int nextx = now.x + di[i];
					int nexty = now.y + dj[i];
					int nextz = now.z + dk[i];

					if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M && nextz >= 0 && nextz < H
							&& !visit[nextz][nextx][nexty] && arr[nextz][nextx][nexty] != '#') {
						queue.add(new Point(nextx, nexty, nextz));
						visit[nextz][nextx][nexty] = true;

					}
				}
			}
			count++;
		}
	}
}