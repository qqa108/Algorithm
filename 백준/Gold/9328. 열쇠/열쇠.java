import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char arr[][];
	static char key[];
	static boolean visit[][];
	static Queue<Point> queue = new ArrayDeque<>();
	static Queue<Point> wait = new ArrayDeque<>();
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
			M = Integer.parseInt(st.nextToken());
			arr = new char[N][M];
			key = new char[26];
			visit = new boolean[N][M];
			queue.clear();
			wait.clear();
			answer = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				arr[i] = s.toCharArray();
			}
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (!s.equals("0")) {
				for (int i = 0; i < s.length(); i++) {
					key[s.charAt(i) - 'a'] = 1;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if ((i == 0 || i == N - 1 || j == 0 || j == M - 1) && arr[i][j] != '*') {
						boolean check = false;
						if (arr[i][j] == '.') {
							check = true;
						} else if (arr[i][j] == '$') {
							answer++;
							check = true;
						} else if (arr[i][j] - 'a' < 0) {// 대문자
							if (key[arr[i][j] - 'A'] == 1) {
								check = true;
							} else {
								visit[i][j] = true;
								wait.add(new Point(i, j));
							}
						} else {
							key[arr[i][j] - 'a'] = 1;
							check = true;
						}
						if (check) {
							visit[i][j] = true;
							queue.add(new Point(i, j));
						}

					}
				}
			}

			bfs();
			sb.append(answer).append('\n');

		}
		System.out.println(sb);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static void bfs() {
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nx = now.x + di[i];
					int ny = now.y + dj[i];
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny] && arr[nx][ny] != '*') {
						boolean check = false;
						if (arr[nx][ny] == '.') {
							check = true;
						} else if (arr[nx][ny] == '$') {
							answer++;
							check = true;
						} else if (arr[nx][ny] - 'a' < 0) {// 대문자
							if (key[arr[nx][ny] - 'A'] == 1) {
								check = true;
							} else {
								visit[nx][ny] = true;
								wait.add(new Point(nx, ny));
							}
						} else {
							key[arr[nx][ny] - 'a'] = 1;
							check = true;
						}
						if (check) {
							visit[nx][ny] = true;
							queue.add(new Point(nx, ny));
						}
					}
				}
			}
			size = wait.size();
			for (int s = 0; s < size; s++) {
				Point now = wait.poll();
				boolean check = false;
				if (arr[now.x][now.y] - 'a' < 0) {// 대문자
					if (key[arr[now.x][now.y] - 'A'] == 1) {
						check = true;
					} else {
						wait.add(new Point(now.x, now.y));
					}
				} else {
					key[arr[now.x][now.y] - 'a'] = 1;
					check = true;
				}
				if (check) {
					queue.add(new Point(now.x, now.y));
				}
			}
		}
	}
}