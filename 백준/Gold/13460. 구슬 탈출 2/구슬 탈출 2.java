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
	static boolean visit[][][][];
	static Queue<Point> queue = new ArrayDeque<>();
	static int hx, hy;
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new boolean[N][M][N][M];
		Point start = new Point(0, 0, 0, 0);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 'R') {
					start.rx = i;
					start.ry = j;
					arr[i][j] = '.';
				}
				else if (arr[i][j] == 'B') {
					start.bx = i;
					start.by = j;
					arr[i][j] = '.';
				}
				else if (arr[i][j] == 'O') {
					hx = i;
					hy = j;
				}
			}
		}
		queue.add(start);
		visit[start.rx][start.ry][start.bx][start.by] = true;
		bfs();
		System.out.println(answer);
	}

	static class Point {
		int rx, ry, bx, by;

		public Point(int rx, int ry, int bx, int by) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
		}
	}

	static void bfs() {
		int count = 1;
		while (!queue.isEmpty()) {
			if (count > 10) {
				answer = -1;
				return;
			}
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nextrx = now.rx;
					int nextry = now.ry;
					int nextbx = now.bx;
					int nextby = now.by;
					boolean rhole = false;
					boolean bhole = false;

					while (true) {
						boolean check = false;
						if (!rhole && arr[nextrx + di[i]][nextry + dj[i]] == '.'
								&& (nextrx + di[i] != nextbx || nextry + dj[i] != nextby)) {
							nextrx = nextrx + di[i];
							nextry = nextry + dj[i];
							check = true;
						}
						else if (!rhole && arr[nextrx + di[i]][nextry + dj[i]] == 'O') {
							nextrx = nextrx + di[i];
							nextry = nextry + dj[i];
							rhole = true;
						}
						if (!bhole && arr[nextbx + di[i]][nextby + dj[i]] == '.'
								&& (nextrx != nextbx + di[i] || nextry != nextby + dj[i])) {
							nextbx = nextbx + di[i];
							nextby = nextby + dj[i];
							check = true;
						}
						else if (!bhole && arr[nextbx + di[i]][nextby + dj[i]] == 'O') {
							nextbx = nextbx + di[i];
							nextby = nextby + dj[i];
							bhole = true;
						}

						if (!check) {
							break;
						}
					}
					if (rhole && !bhole) {
						answer = count;
						return; // win
					}
					if (!visit[nextrx][nextry][nextbx][nextby] && !bhole) {
						queue.add(new Point(nextrx, nextry, nextbx, nextby));
						visit[nextrx][nextry][nextbx][nextby] = true;
					}
				}

			}

			count++;
		}
	}

}