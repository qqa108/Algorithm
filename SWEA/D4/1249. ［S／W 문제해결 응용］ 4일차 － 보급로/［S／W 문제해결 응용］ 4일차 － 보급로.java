import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int arr[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int answer;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				for (int j = 0; j < N; j++) {
					arr[i][j] = s.charAt(j) - '0';
				}
			}
			answer = Integer.MAX_VALUE;
			bfs();
			sb.append('#').append(test_case).append(' ').append(answer).append('\n');
		}
		System.out.println(sb);
	}

	static class Point {
		int x, y, time;

		public Point(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

	}

	static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		int visit[][] = new int[N][N];
		queue.add(new Point(0, 0, 0));
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(visit[i], Integer.MAX_VALUE);
		}
		visit[0][0] = 0;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			if (now.x == N - 1 && now.y == N - 1) {
				answer = Math.min(answer, visit[N - 1][N - 1]);
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nx = now.x + di[i];
				int ny = now.y + dj[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && visit[nx][ny] > now.time + arr[nx][ny]) {
					visit[nx][ny] = now.time + arr[nx][ny];
					queue.add(new Point(nx, ny, visit[nx][ny]));
				}
			}
		}
	}
}