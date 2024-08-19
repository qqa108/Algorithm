import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char arr[][];
	static int result[];
	static List<Point> list = new ArrayList<>();
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static boolean end = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new char[N][N];
		result = new int[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				String s = st.nextToken();
				arr[i][j] = s.charAt(0);

				if (arr[i][j] == 'S') {
					list.add(new Point(i, j));
				}
			}
		}
		comb(0, 0);
		if (end) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void comb(int start, int idx) {
		if (idx == 3) {
			for (int i = 0; i < 3; i++) {
				arr[result[i] / N][result[i] % N] = 'O';
			}

			boolean check = true;
			out:
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < 4; j++) {
					int k = 1;
					while (true) {
						int nx = list.get(i).x + (k * di[j]);
						int ny = list.get(i).y + (k * dj[j]);
						if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
							if (arr[nx][ny] == 'T') {
								check = false;
								break out;
							}
							else if (arr[nx][ny] == 'O') {
								break;
							}
						}
						else {
							break;
						}
						k++;
					}
				}
			}
			if (check) {
				end = true;
			}

			for (int i = 0; i < 3; i++) {
				arr[result[i] / N][result[i] % N] = 'X';
			}

			return;
		}
		for (int i = start; i < N * N; i++) {
			if (end) {
				return;
			}
			if (!end && arr[i / N][i % N] == 'X') {
				result[idx] = i;
				comb(i + 1, idx + 1);
			}
		}
	}
}