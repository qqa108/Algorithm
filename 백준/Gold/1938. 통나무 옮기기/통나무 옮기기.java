import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char arr[][];
	static boolean visit[][][];
	static Queue<Point> queue = new ArrayDeque<>();
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int end[][] = new int[3][2];
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new char[N][N];
		visit = new boolean[2][N][N];

		int start[][] = new int[3][2];
		int sidx = 0;
		int eidx = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'B') {
					start[sidx][0] = i;
					start[sidx++][1] = j;
				}
				else if (arr[i][j] == 'E') {
					end[eidx][0] = i;
					end[eidx++][1] = j;
				}
			}
		}
		int dre = 1;
		if (start[0][0] == start[1][0]) {
			dre = 0;
		}

		queue.add(new Point(start[0][0], start[0][1], start[1][0], start[1][1], start[2][0], start[2][1], dre));
		visit[dre][start[1][0]][start[1][1]] = true;
		bfs();
		System.out.println(answer);
	}

	static class Point {
		int x1, y1, x2, y2, x3, y3, dre;

		public Point(int x1, int y1, int x2, int y2, int x3, int y3, int dre) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.x3 = x3;
			this.y3 = y3;
			this.dre = dre;
		}
	}

	static void bfs() {
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				if (now.x2 == end[1][0] && now.y2 == end[1][1]) {
					if ((now.x1 == end[0][0] && now.y1 == end[0][1] && now.x3 == end[2][0] && now.y3 == end[2][1])
							|| (now.x3 == end[0][0] && now.y3 == end[0][1] && now.x1 == end[2][0]
									&& now.y1 == end[2][1])) {
						answer = count;
					}
				}

				for (int i = 0; i < 4; i++) {
					if (now.x1 + di[i] >= 0 && now.x1 + di[i] < N && now.y1 + dj[i] >= 0 && now.y1 + dj[i] < N
							&& now.x3 + di[i] >= 0 && now.x3 + di[i] < N && now.y3 + dj[i] >= 0 && now.y3 + dj[i] < N
							&& !visit[now.dre][now.x2 + di[i]][now.y2 + dj[i]]
							&& arr[now.x1 + di[i]][now.y1 + dj[i]] != '1' && arr[now.x2 + di[i]][now.y2 + dj[i]] != '1'
							&& arr[now.x3 + di[i]][now.y3 + dj[i]] != '1') {
						queue.add(new Point(now.x1 + di[i], now.y1 + dj[i], now.x2 + di[i], now.y2 + dj[i],
								now.x3 + di[i], now.y3 + dj[i], now.dre));
						visit[now.dre][now.x2 + di[i]][now.y2 + dj[i]] = true;
					}
				}
				boolean check = true;

				if (now.x2 - 1 >= 0 && now.x2 + 1 < N && now.y2 - 1 >= 0 && now.y2 + 1 < N) {
					out:
					for (int i = now.x2 - 1; i <= now.x2 + 1; i++) {
						for (int j = now.y2 - 1; j <= now.y2 + 1; j++) {
							if (arr[i][j] == '1') {
								check = false;
								break out;
							}
						}
					}
				}
				else {
					check = false;
				}
				if (check) {
					if (now.dre == 0 && !visit[1][now.x2][now.y2]) {
						queue.add(new Point(now.x1 - 1, now.y1 + 1, now.x2, now.y2, now.x3 + 1, now.y3 - 1, 1));
						visit[1][now.x2][now.y2] = true;
					}
					else if (now.dre == 1 && !visit[0][now.x2][now.y2]) {
						queue.add(new Point(now.x1 + 1, now.y1 - 1, now.x2, now.y2, now.x3 - 1, now.y3 + 1, 0));
						visit[0][now.x2][now.y2] = true;
					}
				}
			}
			count++;
		}
	}
}