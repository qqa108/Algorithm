import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, count, answer = 0;
	static boolean arr[][], visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from][to] = true;
		}

		for (int i = 1; i <= N; i++) {
			visit = new boolean[N + 1];
			count = 0;
			dfs_to(i);
			dfs_from(i);
			if (count == N - 1) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	static void dfs_to(int idx) {
		visit[idx] = true;
		for (int i = 1; i <= N; i++) {
			if (arr[idx][i] && !visit[i]) {
				count++;
				dfs_to(i);
			}
		}
	}

	static void dfs_from(int idx) {
		visit[idx] = true;
		for (int i = 1; i <= N; i++) {
			if (arr[i][idx] && !visit[i]) {
				count++;
				dfs_from(i);
			}
		}
	}
}