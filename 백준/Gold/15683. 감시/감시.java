import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int K;
	static int arr[][];
	static int tmp[][];
	static boolean visit[][];
	static List<Point> list = new ArrayList<>();
	static int remain = 0;
	static int tmpremain = 0;
	static int result[];
	static int cctv[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		tmp = new int[N][M];
		visit = new boolean[N][M];
		K = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					remain++;
				} else if (arr[i][j] != 6) {
					list.add(new Point(i, j, arr[i][j]));
					K++;
				}
			}
		}

		result = new int[K];
		perm(0);
		System.out.println(min);
		br.close();
	}

	static class Point {
		int x;
		int y;
		int num;
		List<Integer> direct = new ArrayList<>();

		public Point(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}

	}

	static void perm(int idx) {
		if (idx == K) {
			visit = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					tmp[i][j] = arr[i][j];
				}
			}
			tmpremain = remain;

			for (int i = 0; i < K; i++) {
				int x = list.get(i).x;
				int y = list.get(i).y;
				int num = list.get(i).num;

				if (num == 1) {
					cctv1(x, y, result[i]);
				} else if (num == 2) {
					cctv1(x, y, result[i]);
					cctv1(x, y, (result[i] + 2) % 4);
				} else if (num == 3) {
					cctv1(x, y, result[i]);
					cctv1(x, y, (result[i] + 1) % 4);
				} else if (num == 4) {
					cctv1(x, y, result[i]);
					cctv1(x, y, (result[i] + 1) % 4);
					cctv1(x, y, (result[i] + 2) % 4);
				} else if (num == 5) {
					cctv1(x, y, result[i]);
					cctv1(x, y, (result[i] + 1) % 4);
					cctv1(x, y, (result[i] + 2) % 4);
					cctv1(x, y, (result[i] + 3) % 4);
				}
			}

			min = Math.min(min, tmpremain);
			return;
		}
		for (int i = 0; i < 4; i++) {
			result[idx] = i;
			perm(idx + 1);
		}
	}

	static void cctv1(int x, int y, int num) {
		int index = 1;
		while (true) {
			int nextx = x + cctv[num][0] * index;
			int nexty = y + cctv[num][1] * index;
			if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M && tmp[nextx][nexty] != 6) {
				if (!visit[nextx][nexty] && tmp[nextx][nexty] == 0) {
					tmpremain--;
					visit[nextx][nexty] = true;
				}
				index++;
			}
			else {

				break;
			}
		}
		return;
	}

}