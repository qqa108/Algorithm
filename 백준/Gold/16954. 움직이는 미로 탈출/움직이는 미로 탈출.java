import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char arr[][] = new char[8][8];
	static Queue<Point> wall = new ArrayDeque<>();
	static int di[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dj[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 8; i++) {
			String s = st.nextToken();
			arr[i] = s.toCharArray();
			for (int j = 0; j < 8; j++) {
			}
			if (i == 7) {
				break;
			}
			st = new StringTokenizer(br.readLine());
		}
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				if (arr[i][j] == '#') {
					wall.add(new Point(i, j));
				}
			}
		}
		bfs();
		System.out.println(answer);
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
		boolean visit[][] = new boolean[8][8];
		queue.add(new Point(7, 0));
		visit[7][0] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				if (now.x == 0 && now.y == 7) {
					answer = 1;
					return;
				}
				for (int i = 0; i < 8; i++) {
					int nx = now.x + di[i];
					int ny = now.y + dj[i];
					if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && !visit[nx][ny] && arr[nx][ny] != '#') {
						if (nx == 0 || (nx - 1 >= 0 && arr[nx - 1][ny] != '#')) {
							visit[nx][ny] = true;
							queue.add(new Point(nx, ny));
						}
					}
				}
				if (now.x == 0 || (now.x - 1 >= 0 && arr[now.x - 1][now.y] != '#')) {
					queue.add(new Point(now.x, now.y));
				}
			}
			size = wall.size();
			for (int s = 0; s < size; s++) {
				Point now = wall.poll();
				if (now.x + 1 < 8) {
					wall.add(new Point(now.x + 1, now.y));
					arr[now.x][now.y] = '.';
					arr[now.x + 1][now.y] = '#';
				}
				else if (now.x + 1 == 8) {
					arr[now.x][now.y] = '.';
				}
			}
		}
	}

	static void print() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println("--------");
	}
}