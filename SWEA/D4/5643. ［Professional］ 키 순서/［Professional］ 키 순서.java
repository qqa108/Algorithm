import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, count, answer;
	static boolean arr[][], visit[];

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			arr = new boolean[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from][to] = true;
			}

			answer = 0;
			for (int i = 1; i <= N; i++) {
				visit = new boolean[N+1];
				count = 0;
				dfs_to(i);
				dfs_from(i);
				if (count == N - 1) {
					answer++;
				}
			}
			sb.append('#').append(test_case).append(' ').append(answer).append('\n');
		}
		System.out.println(sb);
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