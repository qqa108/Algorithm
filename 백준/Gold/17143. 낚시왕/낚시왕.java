import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, S;
	static Shark arr[][][];
	static Queue<Shark> queue = new ArrayDeque<>();
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, 1, -1 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new Shark[M + 1][N][M];
		
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken()) - 1;
			int size = Integer.parseInt(st.nextToken());
			arr[0][x][y] = new Shark(x, y, speed, dir, size);
		}
		bfs();
		System.out.println(answer);
	}

	static class Shark {
		int x, y, speed, dir, size;

		public Shark(int x, int y, int speed, int dir, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}

	static void bfs() {
		for (int k = 0; k < M; k++) {
			for (int i = 0; i < N; i++) {
				if (arr[k][i][k] != null) {
					answer = answer + arr[k][i][k].size;
					arr[k][i][k] = null;
					break;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[k][i][j] == null) {
						continue;
					}
					Shark now = arr[k][i][j];
					// 방향전환
					int dis = 0, dir = now.dir, go = 0, x = now.x, y = now.y;
					if (now.dir == 0) { // top
						dis = now.x - now.speed;
						if (dis >= 0) {
							x = dis;
							dir = 0;
						} else {
							go = (dis + 1) / (N - 1);
							if (go % 2 == 0) { // v
								x = -dis - ((2 * N) - 2) * ((1 - go) / 2);
								dir = 1;
							} else { // ^
								x = ((2 * N) - 2) * ((1 - go) / 2) + dis;
								dir = 0;
							}
						}
					} else if (now.dir == 1) { // bottom
						dis = now.x + now.speed;
						go = (dis - 1) / (N - 1);

						if (go % 2 == 0) { // v
							x = dis - ((2 * N) - 2) * ((go + 1) / 2);
							dir = 1;
						} else { // ^
							x = ((2 * N) - 2) * ((go + 1) / 2) - dis;
							dir = 0;
						}
					} else if (now.dir == 2) { // right
						dis = now.y + now.speed;
						go = (dis - 1) / (M - 1);

						if (go % 2 == 0) { // ->
							y = dis - ((2 * M) - 2) * ((go + 1) / 2);
							dir = 2;
						} else { // <-
							y = ((2 * M) - 2) * ((go + 1) / 2) - dis;
							dir = 3;
						}
					} else { // left
						dis = now.y - now.speed;
						if (dis >= 0) {
							y = dis;
							dir = 3;
						} else {
							go = (dis + 1) / (M - 1);
							if (go % 2 == 0) { // ->
								y = -dis - ((2 * M) - 2) * ((1 - go) / 2);
								dir = 2;
							} else { // <-
								y = ((2 * M) - 2) * ((1 - go) / 2) + dis;
								dir = 3;
							}
						}
					}
					if (arr[k + 1][x][y] != null && arr[k + 1][x][y].size > now.size) {
						continue;
					}
					arr[k + 1][x][y] = new Shark(x, y, now.speed, dir, now.size);
				}
			}
		}
	}
}