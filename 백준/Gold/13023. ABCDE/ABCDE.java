import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static List<Integer> arr[];
	static boolean visit[];
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from].add(to);
			arr[to].add(from);
		}

		for (int i = 0; i < N; i++) {
			if (answer == 1) {
				break;
			}
			visit[i] = true;
			dfs(i, 0);
			visit[i] = false;
		}
		System.out.println(answer);
		br.close();
	}

	static void dfs(int from, int idx) {
		if (idx == 4) {
			answer = 1;
			return;
		}
		for (int i = 0; i < arr[from].size(); i++) {
			if (answer == 1) {
				break;
			}
			int nextfrom = arr[from].get(i);
			if (!visit[nextfrom]) {
				visit[nextfrom] = true;
				dfs(nextfrom, idx + 1);
				visit[nextfrom] = false;
			}
		}
	}
}