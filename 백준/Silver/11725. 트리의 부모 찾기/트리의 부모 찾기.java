import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int[] parents;
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		parents = new int[N + 1];
		visit = new boolean[N + 1];

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());

			list.get(left).add(right);
			list.get(right).add(left);
		}

		dfs(1);

		for (int i = 2; i < parents.length; i++) {
			sb.append(parents[i] + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int idx) {
		visit[idx] = true;

		for (int v : list.get(idx)) {
			if (!visit[v]) {
				dfs(v);
				parents[v] = idx;
			}
		}
	}
}