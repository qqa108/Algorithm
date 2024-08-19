import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int H;
	static int arr[][][];
	static int di[] = { 0, 0, 0, 0, 1, -1 };
	static int dj[] = { 0, 0, -1, 1, 0, 0 };
	static int dk[] = { -1, 1, 0, 0, 0, 0 };
	static int max = 0;
	static Queue<Point> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[N][M][H];

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if (arr[i][j][k] == 1) {
						queue.add(new Point(i, j, k, 0));
					}
				}
			}
		}
		bfs();

		int answer = max;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j][k] == 0) {
						answer = -1;
						break;
					}
				}
				if (answer == -1) {
					break;
				}
			}
			if (answer == -1) {
				break;
			}
		}

		System.out.println(answer);

		br.close();
	}

	static class Point {
		int x;
		int y;
		int z;
		int count;

		public Point(int x, int y, int z, int count) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.count = count;
		}
	}

	static void bfs() {
		while (true) {
			if (queue.isEmpty()) {
				break;
			}
			Point now = queue.poll();

			if (max < now.count) {
				max = now.count;
			}

			for (int i = 0; i < 6; i++) {
				if (now.x + di[i] >= 0 && now.x + di[i] < N && now.y + dj[i] >= 0 && now.y + dj[i] < M
						&& now.z + dk[i] >= 0 && now.z + dk[i] < H
						&& arr[now.x + di[i]][now.y + dj[i]][now.z + dk[i]] == 0) {
					arr[now.x + di[i]][now.y + dj[i]][now.z + dk[i]] = 1;
					queue.add(new Point(now.x + di[i], now.y + dj[i], now.z + dk[i], now.count + 1));
				}
			}
		}
	}
}