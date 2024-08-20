import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int K;
	static int N;
	static int M;
	static int arr_c[][];
	static int arr[][];
	static int top_c[];
	static int top[];
	static int result[];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int remain_c;
	static int remain;
	static int answer;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			arr_c = new int[N][M];
			arr = new int[N][M];
			result = new int[K];
			top_c = new int[M];
			top = new int[M];

			remain_c = N * M;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr_c[i][j] = Integer.parseInt(st.nextToken());
					if (arr_c[i][j] == 0) {
						top_c[j] = i + 1;
						remain_c--;
					}
				}
			}
			answer = remain_c;

			for (int j = 0; j < M; j++) {
				top[j] = top_c[j];
				for (int i = 0; i < N; i++) {
					arr[i][j] = arr_c[i][j];
				}
			}
			perm(0);

			sb.append('#').append(test_case).append(' ').append(answer).append('\n');
		}
		System.out.println(sb);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void perm(int idx) {
		if (idx == K) {
			for (int j = 0; j < M; j++) {
				top[j] = top_c[j];
				for (int i = 0; i < N; i++) {
					arr[i][j] = arr_c[i][j];
				}
			}

			remain = remain_c;

			for (int i = 0; i < K; i++) {
				if (top[result[i]] < N) {
					bfs(top[result[i]], result[i]);
					remain--;
				}
			}
			answer = Math.min(answer, remain);
			return;
		}
		for (int i = 0; i < M; i++) {
			result[idx] = i;
			perm(idx + 1);
		}
	}

	static void bfs(int x, int y) {
		Queue<Point> queue = new ArrayDeque<>();
		Queue<Point> remove = new ArrayDeque<>();
		boolean visit[][] = new boolean[N][M];
		queue.add(new Point(x, y));
		remove.add(new Point(x, y));
		visit[x][y] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < arr[now.x][now.y]; j++) {
					int nextx = now.x + (di[i] * j);
					int nexty = now.y + (dj[i] * j);
					if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M && !visit[nextx][nexty]
							&& arr[nextx][nexty] != 0) {
						queue.add(new Point(nextx, nexty));
						remove.add(new Point(nextx, nexty));
						visit[nextx][nexty] = true;
						remain--;
					}
				}
			}
		}
		while (!remove.isEmpty()) {
			Point now = remove.poll();
			arr[now.x][now.y] = 0;
		}
		drop();
	}

	static void drop() {
		for (int j = 0; j < M; j++) {
			int bottom = N - 1;
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i][j] != 0) {
					int tmp = arr[bottom][j];
					arr[bottom][j] = arr[i][j];
					arr[i][j] = tmp;
					bottom--;
				}
			}
			top[j] = bottom + 1;
		}
	}
}