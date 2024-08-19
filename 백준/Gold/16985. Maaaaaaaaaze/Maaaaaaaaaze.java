import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int arr[][][] = new int[5][5][5];
	static int order[] = new int[5];
	static int spin[] = new int[5];
	static boolean check[] = new boolean[5];
	static int di[] = { -1, 0, 1, 0, 0, 0 };
	static int dj[] = { 0, 1, 0, -1, 0, 0 };
	static int dk[] = { 0, 0, 0, 0, 1, -1 };
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 5; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		perm(0);

		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}

	static class Point {
		int x, y, z;

		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static void perm(int idx) {
		if (idx == 5) {
			perm2(0);
			return;
		}
		for (int i = 0; i < 5; i++) {
			if (!check[i]) {
				check[i] = true;
				order[idx] = i;
				perm(idx + 1);
				check[i] = false;
			}
		}
	}

	static void perm2(int idx) {
		if (idx == 5) {
			int tmp[][][] = new int[5][5][5];

			for (int i = 0; i < 5; i++) {
				tmp[i] = spin_arr(arr[order[i]], spin[order[i]]);
			}
			if (tmp[0][0][0] == 1 && tmp[4][4][4] == 1) {
				bfs(tmp);
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			spin[idx] = i;
			perm2(idx + 1);
		}
	}

	static int[][] spin_arr(int arr[][], int num) {
		int map[][] = new int[5][5];

		if (num == 1) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					map[i][j] = arr[4 - j][i];
				}
			}
			return map;
		}
		else if (num == 2) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					map[i][j] = arr[4 - i][4 - j];
				}
			}
			return map;
		}
		else if (num == 3) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					map[i][j] = arr[j][4 - i];
				}
			}
			return map;
		}
		else {
			return arr;
		}
	}

	static void bfs(int[][][] tmp) {
		Queue<Point> queue = new ArrayDeque<>();
		boolean visit[][][] = new boolean[5][5][5];
		queue.add(new Point(0, 0, 0));
		visit[0][0][0] = true;

		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				if (now.x == 4 && now.y == 4 && now.z == 4) {
					answer = Math.min(answer, count);
					return;
				}

				for (int i = 0; i < 6; i++) {
					int nx = now.x + di[i];
					int ny = now.y + dj[i];
					int nz = now.z + dk[i];
					if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && nz >= 0 && nz < 5 && !visit[nx][ny][nz]
							&& tmp[nx][ny][nz] == 1) {
						queue.add(new Point(nx, ny, nz));
						visit[nx][ny][nz] = true;
					}
				}
			}
			count++;
		}
	}
}