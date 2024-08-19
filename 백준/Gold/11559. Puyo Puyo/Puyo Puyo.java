import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char arr[][] = new char[12][6];
	static boolean visit[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 12; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();
		}

		int count = 0;

		while (true) {
			check = false;
			visit = new boolean[12][6];
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (!visit[i][j] && arr[i][j] != '.') {
						bfs(i, j, arr[i][j]);
					}
				}
			}
			for (int j = 0; j < 6; j++) {
				int bottom = 11;
				for (int i = 11; i >= 0; i--) {
					if (arr[i][j] != '.') {
						char tmp = arr[bottom][j];
						arr[bottom][j] = arr[i][j];
						arr[i][j] = tmp;
						bottom--;
					}
				}
			}
			if (!check) {
				break;
			}
			else {
				count++;
			}
		}
		System.out.println(count);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void bfs(int x, int y, char color) {
		Queue<Point> queue = new ArrayDeque<>();
		Queue<Point> same = new ArrayDeque<>();
		queue.add(new Point(x, y));
		visit[x][y] = true;
		same.add(new Point(x, y));
		int count = 1;

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextx = now.x + di[i];
				int nexty = now.y + dj[i];
				if (nextx >= 0 && nextx < 12 && nexty >= 0 && nexty < 6 && !visit[nextx][nexty]
						&& arr[nextx][nexty] == color) {
					queue.add(new Point(nextx, nexty));
					same.add(new Point(nextx, nexty));
					visit[nextx][nexty] = true;
					count++;
				}
			}
		}
		while (count >= 4 && !same.isEmpty()) {
			check=true;
			Point now = same.poll();
			arr[now.x][now.y] = '.';
		}
	}

	static void print() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println("-----");
	}
}