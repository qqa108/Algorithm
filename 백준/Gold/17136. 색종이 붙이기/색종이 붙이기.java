import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int arr[][] = new int[10][10];
	static boolean visit[][] = new boolean[10][10];
	static List<Point> list = new ArrayList<>();
	static int remain[] = { 5, 5, 5, 5, 5 };
	static int sum = 0;
	static int need = 0;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					list.add(new Point(i, j));
					need++;
				}
			}
		}
		dfs(0);

		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static void dfs(int index) {
		if (index == list.size()) {
			if (need == 0) {
				min = Math.min(min, sum);
			}
			return;
		}

		int x = list.get(index).x;
		int y = list.get(index).y;

		if (visit[x][y]) {
			dfs(index + 1);
		}
		else {
			out:
			for (int s = 1; s <= 5; s++) {
				if (remain[s - 1] > 0 && x + s <= 10 && y + s <= 10) {
					for (int i = x; i < x + s; i++) {
						for (int j = y; j < y + s; j++) {
							if (arr[i][j] == 0 || visit[i][j]) {
								break out;
							}
						}
					}

					remain[s - 1]--;
					for (int i = x; i < x + s; i++) {
						for (int j = y; j < y + s; j++) {
							visit[i][j] = true;
							need--;
						}
					}
					sum++;

					dfs(index + 1);

					remain[s - 1]++;
					for (int i = x; i < x + s; i++) {
						for (int j = y; j < y + s; j++) {
							visit[i][j] = false;
							need++;
						}
					}
					sum--;

				}
			}

		}
	}
}