import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int V;
	static List<Integer> arr[];
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new LinkedList[N + 1];
		visit = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = new LinkedList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());

			arr[node].add(next);
			arr[next].add(node);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(arr[i]);
		}
		sb.append(V + " ");
		visit[V] = true;
		dfs(V);

		visit = new boolean[N + 1];
		sb.append("\n" + V + " ");
		visit[V] = true;
		bfs(V);
		System.out.println(sb);
		br.close();
	}

	static void bfs(int idx) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(idx);

		while (true) {
			if (queue.isEmpty()) {
				break;
			}
			int now = queue.poll();

			for (int i = 0; i < arr[now].size(); i++) {
				int next = arr[now].get(i);
				if (!visit[next]) {
					visit[next] = true;
					queue.add(next);
					sb.append(next + " ");
				}
			}

		}
	}

	static void dfs(int idx) {
		for (int i = 0; i < arr[idx].size(); i++) {
			int next = arr[idx].get(i);
			if (!visit[next]) {
				visit[next] = true;
				sb.append(next + " ");
				dfs(next);
			}
		}
	}
}