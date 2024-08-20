import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int x = 0;
	static int y = 0;
	static int dir = 0;
	static char arr[][];

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		int di[] = { -1, 1, 0, 0 };
		int dj[] = { 0, 0, -1, 1 };
		char shape[] = { '^', 'v', '<', '>' };

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arr = new char[N][M];
			x = 0;
			y = 0;
			dir = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				arr[i] = s.toCharArray();

				for (int j = 0; j < M; j++) {
					getIndex(i, j, arr[i][j], '^', 'v', '<', '>');
				}
			}

			st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			char command[] = s.toCharArray();

			for (int i = 0; i < C; i++) {
				getIndex(x, y, command[i], 'U', 'D', 'L', 'R');

				if (command[i] == 'S') {
					for (int j = 1; j <= 20; j++) {
						if (x + j * di[dir] < 0
								|| x + j * di[dir] >= N || y + j * dj[dir] < 0 || y + j * dj[dir] >= M) {
							break;
						} else if (arr[x + j * di[dir]][y + j * dj[dir]] == '*') {
							arr[x + j * di[dir]][y + j * dj[dir]] = '.';
							break;
						} else if (arr[x + j * di[dir]][y + j * dj[dir]] == '#') {
							break;
						}
					}
				} else {
					if (x + di[dir] >= 0 && x + di[dir] < N && y + dj[dir] >= 0 && y + dj[dir] < M
							&& arr[x + di[dir]][y + dj[dir]] == '.') {
						x = x + di[dir];
						y = y + dj[dir];
					}
				}
			}

			arr[x][y] = shape[dir];
			sb.append("#" + test_case + " ");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}

	static void getIndex(int i, int j, char now, char u, char d, char l, char r) {
		if (now == u || now == d || now == l || now == r) {
			x = i;
			y = j;
			arr[x][y] = '.';
		}
		if (now == u) {
			dir = 0;
		} else if (now == d) {
			dir = 1;
		} else if (now == l) {
			dir = 2;
		} else if (now == r) {
			dir = 3;
		}
	}
}