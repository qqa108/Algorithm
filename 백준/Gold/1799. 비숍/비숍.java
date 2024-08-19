import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static boolean visit[];
	static List<Point> listeven = new ArrayList<>();
	static List<Point> listodd = new ArrayList<>();
	static int even = 0;
	static int odd = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					if ((i + j) % 2 == 0) {
						listeven.add(new Point(i, j));
					} else {
						listodd.add(new Point(i, j));
					}
				}
			}
		}

		visit = new boolean[((N * 2) - 1) * 2];
		evendfs(0, 0);
		visit = new boolean[((N * 2) - 1) * 2];
		odddfs(0, 0);
		System.out.println(even + odd);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void evendfs(int index, int num) {
		for (int i = index; i < listeven.size(); i++) {
			int x = listeven.get(i).x;
			int y = listeven.get(i).y;

			if (!visit[x + y] && !visit[(3 * N) - 2 + y - x]) {
				visit[x + y] = true;
				visit[(3 * N) - 2 + y - x] = true;
				evendfs(i + 1, num + 1);
				visit[x + y] = false;
				visit[(3 * N) - 2 + y - x] = false;
			}
		}
		even = Math.max(even, num);
	}

	static void odddfs(int index, int num) {
		for (int i = index; i < listodd.size(); i++) {
			int x = listodd.get(i).x;
			int y = listodd.get(i).y;

			if (!visit[x + y] && !visit[(3 * N) - 2 + y - x]) {
				visit[x + y] = true;
				visit[(3 * N) - 2 + y - x] = true;
				odddfs(i + 1, num + 1);
				visit[x + y] = false;
				visit[(3 * N) - 2 + y - x] = false;
			}
		}
		odd = Math.max(odd, num);
	}
}