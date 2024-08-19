import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char arr[][];
	static boolean visit[];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();
		}
		visit = new boolean[26];
		visit[arr[0][0] - 65] = true;
		dfs(0, 0, 1);
		System.out.println(max);

		br.close();
	}

	static void dfs(int x, int y, int count) {
		if (max < count) {
			max = count;
		}
		for (int i = 0; i < 4; i++) {
			if (x + di[i] >= 0 && x + di[i] < N && y + dj[i] >= 0 && y + dj[i] < M
					&& !visit[arr[x + di[i]][y + dj[i]] - 65]) {
				visit[arr[x + di[i]][y + dj[i]] - 65] = true;
				dfs(x + di[i], y + dj[i], count + 1);
				visit[arr[x + di[i]][y + dj[i]] - 65] = false;
			}
		}
	}
}