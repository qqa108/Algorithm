import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int arr[][];
	static int di[] = { 0, -1, 0, 1 };
	static int dj[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			int count = 0;

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				arr[x][y] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1) {
						dfs(i, j);
						count++;
					}
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
		br.close();
	}

	static void dfs(int x, int y) {
		if (arr[x][y] == 1) {
			arr[x][y] = 0;
		}
		for (int i = 0; i < 4; i++) {
			if (x + di[i] >= 0 && x + di[i] < N && y + dj[i] >= 0 && y + dj[i] < M && arr[x + di[i]][y + dj[i]] == 1) {
				dfs(x + di[i], y + dj[i]);
			}
		}
	}
}