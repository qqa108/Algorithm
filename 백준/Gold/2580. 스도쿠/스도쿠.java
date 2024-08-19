import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int arr[][] = new int[9][9];
	static List<Point> list = new ArrayList<>();
	static boolean visitw[][] = new boolean[9][10];
	static boolean visith[][] = new boolean[9][10];
	static boolean visits[][] = new boolean[9][10];
	static boolean check = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0) {
					visitw[i][arr[i][j]] = true;
					visith[j][arr[i][j]] = true;
					visits[3 * (i / 3) + (j / 3)][arr[i][j]] = true;
				} else {
					list.add(new Point(i, j));
				}
			}
		}
		dfs(0);
		System.out.print(sb);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void dfs(int index) {
		if (index == list.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]).append(' ');
				}
				sb.append('\n');
			}
			check = true;
			return;
		}
		int x = list.get(index).x;
		int y = list.get(index).y;

		for (int i = 1; i <= 9; i++) {
			if (check) {
				return;
			}
			if (!visitw[x][i] && !visith[y][i] && !visits[3 * (x / 3) + (y / 3)][i]) {
				visitw[x][i] = true;
				visith[y][i] = true;
				visits[3 * (x / 3) + (y / 3)][i] = true;
				arr[x][y] = i;
				dfs(index + 1);
				visitw[x][i] = false;
				visith[y][i] = false;
				visits[3 * (x / 3) + (y / 3)][i] = false;
				arr[x][y] = 0;
			}
		}
	}
}