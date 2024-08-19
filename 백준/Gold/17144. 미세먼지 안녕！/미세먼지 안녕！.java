import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int T;
	static int arr[][];
	static Queue<Point> queue = new ArrayDeque<>();
	static int clean1 = -1;
	static int clean2 = -1;
	static int remain;
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		remain = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > 0) {
					remain = remain + arr[i][j];
					if (arr[i][j] >= 5) {
						queue.add(new Point(i, j, arr[i][j]));
					}
				}
				else if (arr[i][j] == -1) {
					if (clean1 == -1) {
						clean1 = i;
					}
					else {
						clean2 = i;
					}
				}
			}
		}
		bfs();

		if (remain < 0) {
			remain = 0;
		}
		System.out.println(remain);
	}

	static class Point {
		int x;
		int y;
		int val;

		public Point(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	static void bfs() {
		int count = 0;
		while (true) {
			if (count == T) {
				return;
			}
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nextx = now.x + di[i];
					int nexty = now.y + dj[i];
					if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M && arr[nextx][nexty] != -1) {
						arr[now.x][now.y] = arr[now.x][now.y] - (now.val / 5);
						arr[nextx][nexty] = arr[nextx][nexty] + (now.val / 5);
					}
				}
			}
			count++;
			spin(0, clean1, 0);
			spin(clean2, N - 1, 1);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] >= 5) {
						queue.add(new Point(i, j, arr[i][j]));
					}
				}
			}
		}
	}

	static void spin(int start, int end, int dre) {
		int index = 0;
		int x = 0;
		int y = 0;
		int count = 0;

		if (dre == 0) {
			x = end - 1;
			index = 0;
		}
		else {
			x = start + 1;
			index = 2;
		}
		remain = remain - arr[x][y];

		while (true) {
			if (x + di[index] >= start && x + di[index] <= end && y + dj[index] >= 0 && y + dj[index] < M) {
				if (count == 3 && arr[x + di[index]][y + dj[index]] == -1) {
					arr[x][y] = 0;
					break;
				}
				arr[x][y] = arr[x + di[index]][y + dj[index]];
				x = x + di[index];
				y = y + dj[index];
			}
			else {
				if (dre == 0) {
					index = (index + 1) % 4;
				}
				else {
					index = (index + 3) % 4;
				}
				count++;
			}
		}
	}
}