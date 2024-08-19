import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static int popul[];
	static boolean visit[];
	static boolean check[];
	static Queue<Integer> queue = new ArrayDeque<>();
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		popul = new int[N];
		visit = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				arr[i][tmp - 1] = 1;
				arr[tmp - 1][i] = 1;
			}
		}

		subset(0);
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}

	static void subset(int idx) {
		if (idx == N) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (visit[i]) {
					count++;
				}
			}
			if (count == 0 || count == N) {
				return;
			}

			boolean first;
			boolean second;
			check = new boolean[N];
			for (int i = 0; i < N; i++) {
				if (visit[i]) {
					queue.add(i);
					check[i] = true;
					break;
				}
			}
			bfs();
			first = isGraph();

			Arrays.fill(check, true);
			for (int i = 0; i < N; i++) {
				if (!visit[i]) {
					queue.add(i);
					check[i] = false;
					break;
				}
			}
			bfs2();
			second = isGraph();

			if (first && second) {
				int sum = 0;
				for (int i = 0; i < N; i++) {
					if (visit[i]) {
						sum = sum + popul[i];
					}
					else {
						sum = sum - popul[i];
					}
				}
				min = Math.min(min, Math.abs(sum));
			}
			return;
		}
		visit[idx] = true;
		subset(idx + 1);
		visit[idx] = false;
		subset(idx + 1);

	}

	static void bfs() {
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < N; i++) {
				if (arr[now][i] == 1 && visit[i] && !check[i]) {
					queue.add(i);
					check[i] = true;
				}
			}
		}
	}

	static void bfs2() {
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < N; i++) {
				if (arr[now][i] == 1 && !visit[i] && check[i]) {
					queue.add(i);
					check[i] = false;
				}
			}
		}
	}

	static boolean isGraph() {
		boolean vc = true;
		for (int i = 0; i < N; i++) {
			if (visit[i] != check[i]) {
				vc = false;
				break;
			}
		}
		return vc;
	}
}