import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static int arr[][];
	static int remain = 0;
	static Queue<Point> queue = new ArrayDeque<>();
	static boolean visit[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					remain++;
				} else if (arr[i][j] == 1) {
					visit[i][j] = true;
					queue.add(new Point(i, j));
				}
			}
		}
		bfs();
		System.out.println(answer);
		br.close();
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void bfs() {
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int q = 0; q < size; q++) {
				Point now = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nexti = now.x + di[i];
					int nextj = now.y + dj[i];
					if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < M && !visit[nexti][nextj]
							&& arr[nexti][nextj] == 0) {
						visit[nexti][nextj] = true;
						remain--;
						queue.add(new Point(nexti, nextj));
					}
				}
			}
			count++;
		}
		if (remain != 0) {
			answer = -1;
		} else {
			answer = count - 1;
		}
	}
}