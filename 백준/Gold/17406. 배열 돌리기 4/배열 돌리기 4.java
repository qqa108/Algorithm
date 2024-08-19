import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int K;
	static int arr[][];
	static int init[][];
	static boolean visit[];
	static int result[];
	static int order[][];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		init = new int[N + 1][M + 1];
		visit = new boolean[K];
		result = new int[K];
		order = new int[K][3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				init[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = init[i][j];
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			order[i][0] = Integer.parseInt(st.nextToken());
			order[i][1] = Integer.parseInt(st.nextToken());
			order[i][2] = Integer.parseInt(st.nextToken());
		}
		perm(0);
		System.out.println(min);

		br.close();
	}

	static void rotate(int r, int c, int s) {
		while (true) {
			if (s == 0) {
				break;
			}
			int tmp = arr[r - s][c + s];
			for (int i = c + s; i > c - s; i--) { // rt -> lt
				arr[r - s][i] = arr[r - s][i - 1];
			}
			for (int i = r - s; i < r + s; i++) { // lt -> lb
				arr[i][c - s] = arr[i + 1][c - s];
			}
			for (int i = c - s; i < c + s; i++) { // lb -> rb
				arr[r + s][i] = arr[r + s][i + 1];
			}
			for (int i = r + s; i > r - s; i--) { // rb -> rt
				arr[i][c + s] = arr[i - 1][c + s];
			}
			arr[r - s + 1][c + s] = tmp;

			s--;
		}
	}

	static void getmin() {
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= M; j++) {
				sum = sum + arr[i][j];
			}
			min = Math.min(min, sum);
		}
	}

	static void perm(int idx) {
		if (idx == K) {
			for (int i = 0; i < K; i++) {
				rotate(order[result[i]][0], order[result[i]][1], order[result[i]][2]);
			}
			getmin();
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					arr[i][j] = init[i][j];
				}
			}
			return;
		}
		for (int i = 0; i < K; i++) {
			if (!visit[i]) {
				visit[i] = true;
				result[idx] = i;
				perm(idx + 1);
				visit[i] = false;
			}
		}
	}
}