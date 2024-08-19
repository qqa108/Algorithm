import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int arr[][];
	static int result[];
	static boolean visit[][];
	static List<Point> list = new ArrayList<>();
	static Queue<Point> queue = new ArrayDeque<>();
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int remain = 0;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		result = new int[M];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					list.add(new Point(i, j));
				}
				else if (arr[i][j] == 1) {
					remain++;
				}
			}
		}
		remain = N * N - remain - M;
		comb(0, 0);
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
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

	static void comb(int idx, int start) {
		if (idx == M) {
			visit = new boolean[N][N];
			for (int i = 0; i < M; i++) {
				queue.add(list.get(result[i]));
				visit[list.get(result[i]).x][list.get(result[i]).y] = true;
			}
			bfs();
			return;
		}
		for (int i = start; i < list.size(); i++) {
			result[idx] = i;
			comb(idx + 1, i + 1);
		}
	}

	static void bfs() {
		int count = 0;
		int rem = remain;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int q = 0; q < size; q++) {
				Point now = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nextx = now.x + di[i];
					int nexty = now.y + dj[i];
					if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < N && !visit[nextx][nexty]
							&& arr[nextx][nexty] != 1) {
						visit[nextx][nexty] = true;
						rem--;
						queue.add(new Point(nextx, nexty));
					}
				}
			}
			count++;
		}
		if (rem == 0) {
			min = Math.min(min, count - 1);
		}
	}
}