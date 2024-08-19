import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char arr[][];
	static boolean visit[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int wolf, sheep;
	static int v, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && (arr[i][j] == 'k' || arr[i][j] == 'v')) {
					v = 0;
					k = 0;
					visit[i][j] = true;
					dfs(i, j);
					if (k > v) {
						sheep = sheep + k;
					}
					else {
						wolf = wolf + v;
					}
				}
			}
		}
		System.out.println(sheep + " " + wolf);
	}

	static void dfs(int x, int y) {
		if (arr[x][y] == 'v') {
			v++;
		}
		else if (arr[x][y] == 'k') {
			k++;
		}
		for (int i = 0; i < 4; i++) {
			if (x + di[i] >= 0 && x + di[i] < N && y + dj[i] >= 0 && y + dj[i] < M && !visit[x + di[i]][y + dj[i]]
					&& arr[x + di[i]][y + dj[i]] != '#') {
				visit[x + di[i]][y + dj[i]] = true;
				dfs(x + di[i], y + dj[i]);
			}
		}
	}
}