import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int arr[][];
	static int tmp[][];
	static int count;
	static int tmpcount;
	static int visit[];
	static int di[] = { 0, -1, 0, 1 };
	static int dj[] = { 1, 0, -1, 0 };
	static Queue<Point> queue = new ArrayDeque<>();
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		tmp = new int[N][M];
		visit = new int[3];
		count = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 0) {
					count++;
				}
			}
		}

		comb(0, 0);

		System.out.println(max);
		br.close();
	}

	static void comb(int idx, int start) {
		if (idx == 3) {
			tmpcount = count - 3;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					tmp[i][j] = arr[i][j];
					if (arr[i][j] == 2) {
						queue.add(new Point(i, j));
					}
				}
			}

			for (int i = 0; i < 3; i++) {
				tmp[visit[i] / M][visit[i] % M] = 1;
			}

			bfs();

			if (max < tmpcount) {
				max = tmpcount;
			}

			return;
		}

		for (int i = start; i < N * M; i++) {
			if (arr[i / M][i % M] != 0) {
				continue;
			}
			visit[idx] = i;
			comb(idx + 1, i + 1);
		}
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
		while (true) {
			if (queue.isEmpty()) {
				break;
			}

			Point now = queue.poll();

			for (int i = 0; i < 4; i++) {
				if (now.x + di[i] >= 0 && now.x + di[i] < N && now.y + dj[i] >= 0 && now.y + dj[i] < M
						&& tmp[now.x + di[i]][now.y + dj[i]] == 0) {
					tmp[now.x + di[i]][now.y + dj[i]] = 2;
					tmpcount--;
					queue.add(new Point(now.x + di[i], now.y + dj[i]));
				}
			}
		}
	}
}