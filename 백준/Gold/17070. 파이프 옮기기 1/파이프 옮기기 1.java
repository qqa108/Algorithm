import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static boolean visit[][];
	static int pipe1[][] = { { 0, 0 }, { 0, 1 } };
	static int pipe2[][] = { { 0, 0 }, { 1, 0 } };
	static int pipe3[][] = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		visit = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1, 2, 1);
		System.out.println(count);
	}

	static void dfs(int x, int y, int pre) {
		if (x == N && y == N) {
			count++;
			return;
		}
		if (pre != 2 && x + pipe1[1][0] <= N && y + pipe1[1][1] <= N && !visit[x + pipe1[1][0]][y + pipe1[1][1]]
				&& arr[x + pipe1[1][0]][y + pipe1[1][1]] != 1) {
			visit[x + pipe1[1][0]][y + pipe1[1][1]] = true;
			dfs(x + pipe1[1][0], y + pipe1[1][1], 1);
			visit[x + pipe1[1][0]][y + pipe1[1][1]] = false;
		}
		if (pre != 1 && x + pipe2[1][0] <= N && y + pipe2[1][1] <= N && !visit[x + pipe2[1][0]][y + pipe2[1][1]]
				&& arr[x + pipe2[1][0]][y + pipe2[1][1]] != 1) {
			visit[x + pipe2[1][0]][y + pipe2[1][1]] = true;
			dfs(x + pipe2[1][0], y + pipe2[1][1], 2);
			visit[x + pipe2[1][0]][y + pipe2[1][1]] = false;
		}
		if (x + pipe3[3][0] <= N && y + pipe3[3][1] <= N && !visit[x + pipe3[1][0]][y + pipe3[1][1]]
				&& !visit[x + pipe3[2][0]][y + pipe3[2][1]] && !visit[x + pipe3[3][0]][y + pipe3[3][1]]
				&& arr[x + pipe3[1][0]][y + pipe3[1][1]] != 1 && arr[x + pipe3[2][0]][y + pipe3[2][1]] != 1
				&& arr[x + pipe3[3][0]][y + pipe3[3][1]] != 1) {
			visit[x + pipe3[1][0]][y + pipe3[1][1]] = true;
			visit[x + pipe3[2][0]][y + pipe3[2][1]] = true;
			visit[x + pipe3[3][0]][y + pipe3[3][1]] = true;
			dfs(x + pipe3[3][0], y + pipe3[3][1], 3);
			visit[x + pipe3[1][0]][y + pipe3[1][1]] = false;
			visit[x + pipe3[2][0]][y + pipe3[2][1]] = false;
			visit[x + pipe3[3][0]][y + pipe3[3][1]] = false;
		}
	}
}