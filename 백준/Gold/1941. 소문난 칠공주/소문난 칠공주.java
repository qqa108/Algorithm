import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char arr[][] = new char[5][5];
	static int visit[][] = new int[5][5];
	static int result[] = new int[7];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();
		}

		comb(0, 0);

		System.out.println(answer);
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
		if (idx == 7) {
			int s = 0;
			int e = 0;
			visit = new int[5][5];
			for (int i = 0; i < idx; i++) {
				if (i == 0) {
					s = result[i] / 5;
					e = result[i] % 5;
				}
				visit[result[i] / 5][result[i] % 5] = 1;
			}
			bfs(s, e);
			return;
		}

		for (int i = start; i < 25; i++) {
			result[idx] = i;
			comb(idx + 1, i + 1);
		}
	}

	static void bfs(int x, int y) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(x, y));
		visit[x][y]++;
		int Y = 0;
		int count = 1;

		if (arr[x][y] == 'Y') {
			Y++;
		}

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextx = now.x + di[i];
				int nexty = now.y + dj[i];
				if (nextx >= 0 && nextx < 5 && nexty >= 0 && nexty < 5 && visit[nextx][nexty] == 1) {
					queue.add(new Point(nextx, nexty));
					visit[nextx][nexty]++;
					if (arr[nextx][nexty] == 'Y') {
						Y++;
					}
					if (Y > 3) {
						return;
					}
					count++;
				}
			}
		}
		if (count == 7) {
			answer++;
		}
	}
}