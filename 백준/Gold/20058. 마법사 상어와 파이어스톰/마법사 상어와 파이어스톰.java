import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, Q;
	static int arr[][];
	static boolean visit[][];
	static Queue<Point> queue = new ArrayDeque<>();
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int cnt = 0, sum = 0, answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tmp = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, tmp);
		arr = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum = sum + arr[i][j];
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int l = Integer.parseInt(st.nextToken());
			spin((int) Math.pow(2, l));
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && arr[i][j] != 0) {
					cnt = 1;
					visit[i][j] = true;
					dfs(i, j);
					answer = Math.max(answer, cnt);
				}
			}
		}
		System.out.println(sum + "\n" + answer);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void spin(int size) {
		int tmp[][] = new int[N][N];
		for (int x = 0; x < N; x = x + size) {
			for (int y = 0; y < N; y = y + size) {
				for (int i = x; i < x + size; i++) {
					for (int j = y; j < y + size; j++) {
						tmp[i][j] = arr[x + y + size - 1 - j][(Math.abs(y - x + i))];
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = tmp[i][j];
			}
		}
		bfs();
	}

	static void bfs() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] <= 0) {
					continue;
				}
				int count = 0;
				for (int d = 0; d < 4; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];
					if (ni >= 0 && ni < N && nj >= 0 && nj < N && arr[ni][nj] != 0) {
						count++;
					}
				}
				if (count <= 2) {
					queue.add(new Point(i, j));
				}
			}
		}
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			arr[now.x][now.y]--;
			sum--;
		}
	}

	static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + di[i];
			int ny = y + dj[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny] && arr[nx][ny] != 0) {
				cnt++;
				visit[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}
}