import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static boolean visit[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		int high = 0;
		int max = 0;
		int count = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				high = Math.max(high, arr[i][j]);
			}
		}
		for (int h = 0; h <= high; h++) {
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] > h && visit[i][j] == false) {
						visit[i][j] = true;
						dfs(i, j, h);
						count++;
					}
				}
			}
			max = Math.max(max, count);
			count = 0;
		}
		System.out.println(max);
	}

	static void dfs(int x, int y, int h) {
		for (int i = 0; i < 4; i++) {
			if (x + di[i] >= 0 && x + di[i] < N && y + dj[i] >= 0 && y + dj[i] < N
					&& visit[x + di[i]][y + dj[i]] == false && arr[x + di[i]][y + dj[i]] > h) {
				visit[x + di[i]][y + dj[i]] = true;
				dfs(x + di[i], y + dj[i], h);
			}
		}
	}
}