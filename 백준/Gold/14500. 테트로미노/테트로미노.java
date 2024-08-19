import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int arr[][];
	static boolean visit[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, 0, 0);
				bfs(i, j);
			}
		}
		System.out.println(max);
	}

	static void dfs(int x, int y, int count, int sum) { // ㅗ 제외한 도형들 검사
		if (count == 4) {
			max = Math.max(max, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (x + di[i] >= 0 && x + di[i] < N && y + dj[i] >= 0 && y + dj[i] < M && !visit[x + di[i]][y + dj[i]]) {
				visit[x + di[i]][y + dj[i]] = true;
				dfs(x + di[i], y + dj[i], count + 1, sum + arr[x + di[i]][y + dj[i]]);
				visit[x + di[i]][y + dj[i]] = false;
			}
		}
	}

	static void bfs(int x, int y) { // ㅗ ㅏ ㅜ ㅓ 검사
		int sum = 0;
		int count = 0;
		for (int k = 0; k < 4; k++) {
			count = 0;
			sum = arr[x][y];
			for (int i = 0; i < 4; i++) {
				if (k == i) {
					continue;
				}
				if ((x + di[i] >= 0 && x + di[i] < N && y + dj[i] >= 0 && y + dj[i] < M)) {
					count++;
					sum = sum + arr[x + di[i]][y + dj[i]];
				}
			}
			if (count == 3) {
				max = Math.max(max, sum);
			}
		}
	}
}