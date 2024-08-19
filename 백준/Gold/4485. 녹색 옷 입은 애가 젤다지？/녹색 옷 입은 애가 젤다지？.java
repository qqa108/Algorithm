import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static boolean visit[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int answer;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int tc = 1;
		while (true) {
			N = Integer.parseInt(st.nextToken());
			if (N == 0) {
				break;
			}
			arr = new int[N][N];
			visit = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());

			answer = Integer.MAX_VALUE;
			bfs();
			sb.append("Problem ").append(tc).append(": ").append(answer).append('\n');
			tc++;
		}
		System.out.println(sb);
	}

	static class Point implements Comparable<Point> {
		int x, y, sum;

		public Point(int x, int y, int sum) {
			this.x = x;
			this.y = y;
			this.sum = sum;
		}

		@Override
		public int compareTo(Point o) {
			return this.sum - o.sum;
		}
	}

	static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0, 0, arr[0][0]));
		visit[0][0] = true;

		while (!pq.isEmpty()) {
			Point now = pq.poll();
			if (now.x == N - 1 && now.y == N - 1) {
				answer = now.sum;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nextx = now.x + di[i];
				int nexty = now.y + dj[i];
				if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < N && !visit[nextx][nexty]) {
					pq.add(new Point(nextx, nexty, now.sum + arr[nextx][nexty]));
					visit[nextx][nexty] = true;
				}
			}
		}
	}
}