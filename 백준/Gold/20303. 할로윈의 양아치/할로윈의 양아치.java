import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int candy[];
	static List<Integer> list[];
	static boolean visit[];
	static boolean get_candy[];
	static int max;
	static int child;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		candy = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			candy[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}

		int dp[] = new int[K + 1];

		visit = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			child = 0;
			max = 0;
			if (!visit[i]) {
				visit[i] = true;
				dfs(i);
			}
			for (int j = 1; j < K; j++) {
				if (j + child <= K) {
					dp[j] = Math.max(dp[j], dp[j + child] + max);
				}
			}
		}
		System.out.println(dp[1]);
	}

	static void dfs(int idx) {
		max = max + candy[idx];
		child++;
		for (int i = 0; i < list[idx].size(); i++) {
			if (!visit[list[idx].get(i)]) {
				visit[list[idx].get(i)] = true;
				dfs(list[idx].get(i));
			}
		}
	}
}