import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static boolean visit[];
	static int count;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from][to] = 1;
			arr[to][from] = -1;
		}

		for (int i = 1; i <= N; i++) {
			visit = new boolean[N + 1];
			count = N - 1;
			dfs(i, 1);
			dfs(i, -1);
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	static void dfs(int idx, int dre) {
		visit[idx] = true;
		for (int i = 1; i <= N; i++) {
			if (arr[idx][i] == dre && !visit[i]) {
				count--;
				dfs(i, dre);
			}
		}
	}
}