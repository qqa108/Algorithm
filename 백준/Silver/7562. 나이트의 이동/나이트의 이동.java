import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean map[][];
	static int si, sj, fi, fj;
	static int di[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int dj[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int answer;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			si = Integer.parseInt(st.nextToken());
			sj = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			fi = Integer.parseInt(st.nextToken());
			fj = Integer.parseInt(st.nextToken());

			answer = 0;
			bfs();
			sb.append(answer).append('\n');
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

	static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		map = new boolean[N][N];
		queue.add(new Point(si, sj));
		map[si][sj] = true;
		int count = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				if (now.x == fi && now.y == fj) {
					answer = count;
					return;
				}
				for (int i = 0; i < 8; i++) {
					int nextx = now.x + di[i];
					int nexty = now.y + dj[i];
					if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < N && !map[nextx][nexty]) {
						queue.add(new Point(nextx, nexty));
						map[nextx][nexty] = true;
					}
				}
			}
			count++;
		}
	}
}