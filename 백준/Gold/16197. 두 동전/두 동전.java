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
	static Queue<Point> queue = new ArrayDeque<>();
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];

		boolean check = false;
		Point p = new Point(0, 0, 0, 0);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 'o') {
					if (!check) {
						p.x1 = i;
						p.y1 = j;
						check = true;
					}
					else {
						p.x2 = i;
						p.y2 = j;
					}
				}
			}
		}
		queue.add(p);
		bfs();
		System.out.println(answer);
	}

	static class Point {
		int x1, y1, x2, y2;

		public Point(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}

	static void bfs() {
		int count = 1;
		while (!queue.isEmpty()) {
			if (count > 10) {
				return;
			}
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nx1 = now.x1 + di[i];
					int ny1 = now.y1 + dj[i];
					int nx2 = now.x2 + di[i];
					int ny2 = now.y2 + dj[i];
					boolean c1 = false;
					boolean c2 = false;

					if (nx1 >= 0 && nx1 < N && ny1 >= 0 && ny1 < M) {
						if (arr[nx1][ny1] == '#') {
							nx1 = now.x1;
							ny1 = now.y1;
						}
					}
					else {
						nx1 = now.x1;
						ny1 = now.y1;
						c1 = true;
					}

					if (nx2 >= 0 && nx2 < N && ny2 >= 0 && ny2 < M) {
						if (arr[nx2][ny2] == '#') {
							nx2 = now.x2;
							ny2 = now.y2;
						}
					}
					else {
						nx2 = now.x2;
						ny2 = now.y2;
						c2 = true;
					}
					if (c1 != c2) {
						answer = count;
						return;
					}
					queue.add(new Point(nx1, ny1, nx2, ny2));
				}
			}
			count++;
		}

	}
}