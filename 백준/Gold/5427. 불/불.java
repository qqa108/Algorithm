import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char arr[][];
	static boolean firevisit[][];
	static boolean personvisit[][];
	static Queue<Point> fire;
	static Queue<Point> person;
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
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			arr = new char[N][M];
			firevisit = new boolean[N][M];
			personvisit = new boolean[N][M];
			answer = Integer.MAX_VALUE;
			fire = new ArrayDeque<>();
			person = new ArrayDeque<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				arr[i] = s.toCharArray();
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == '@') {
						person.add(new Point(i, j));
					}
					else if (arr[i][j] == '*') {
						fire.add(new Point(i, j));
					}
				}
			}
			bfs();

			if (answer == Integer.MAX_VALUE) {
				sb.append("IMPOSSIBLE\n");
			}
			else {
				sb.append(answer + "\n");
			}
		}
		System.out.println(sb);
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void bfs() {
		int count = 0;
		while (true) {
			if(!fire.isEmpty()) {
				int size = fire.size();
				for (int s = 0; s < size; s++) {
					Point now = fire.poll();
					
					for (int i = 0; i < 4; i++) {
						int nextx = now.x + di[i];
						int nexty = now.y + dj[i];
						if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M && !firevisit[nextx][nexty]
								&& arr[nextx][nexty] != '#') {
							fire.add(new Point(nextx, nexty));
							arr[nextx][nexty] = '*';
							firevisit[nextx][nexty] = true;
						}
					}
				}
			}

			if (person.isEmpty()) {
				break;
			}
			int size = person.size();

			for (int s = 0; s < size; s++) {
				Point now = person.poll();
				if (now.x == 0 || now.x == N - 1 || now.y == 0 || now.y == M - 1) {
					answer = Math.min(answer, count + 1);
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nextx = now.x + di[i];
					int nexty = now.y + dj[i];
					if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M && !personvisit[nextx][nexty]
							&& arr[nextx][nexty] != '#' && arr[nextx][nexty] != '*') {
						person.add(new Point(nextx, nexty));
						arr[nextx][nexty] = '@';
						personvisit[nextx][nexty] = true;
					}
				}
			}
			count++;
		}
	}
}