import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static Deque<Integer> queue = new ArrayDeque<>();
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}

		dfs(arr, 0);
		System.out.println(max);
	}

	static void dfs(int now[][], int idx) {
		if (idx == 5) {
			return;
		}
		for (int d = 0; d < 4; d++) {
			int next[][] = new int[N][N];

			if (d == 0) {
				for (int i = 0; i < N; i++) {
					queue.clear();
					boolean check = true;
					for (int j = 0; j < N; j++) {
						if (now[j][i] != 0) {
							if (check && !queue.isEmpty() && queue.peekLast() == now[j][i]) {
								int num = queue.pollLast();
								queue.add(2 * num);
								check = false;
							}
							else {
								queue.add(now[j][i]);
								check = true;
							}
						}
					}
					for (int j = 0; j < N; j++) {
						if (queue.isEmpty()) {
							break;
						}
						next[j][i] = queue.poll();
					}
				}
			}
			else if (d == 1) {
				for (int i = 0; i < N; i++) {
					queue.clear();
					boolean check = true;
					for (int j = N - 1; j >= 0; j--) {
						if (now[i][j] != 0) {
							if (check && !queue.isEmpty() && queue.peekLast() == now[i][j]) {
								int num = queue.pollLast();
								queue.add(2 * num);
								check = false;
							}
							else {
								queue.add(now[i][j]);
								check = true;
							}
						}
					}
					for (int j = N - 1; j >= 0; j--) {
						if (queue.isEmpty()) {
							break;
						}
						next[i][j] = queue.poll();
					}
				}
			}
			else if (d == 2) {
				for (int i = 0; i < N; i++) {
					queue.clear();
					boolean check = true;
					for (int j = N - 1; j >= 0; j--) {
						if (now[j][i] != 0) {
							if (check && !queue.isEmpty() && queue.peekLast() == now[j][i]) {
								int num = queue.pollLast();
								queue.add(2 * num);
								check = false;
							}
							else {
								queue.add(now[j][i]);
								check = true;
							}
						}
					}
					for (int j = N - 1; j >= 0; j--) {
						if (queue.isEmpty()) {
							break;
						}
						next[j][i] = queue.poll();
					}
				}
			}
			else if (d == 3) {
				for (int i = 0; i < N; i++) {
					queue.clear();
					boolean check = true;
					for (int j = 0; j < N; j++) {
						if (now[i][j] != 0) {
							if (check && !queue.isEmpty() && queue.peekLast() == now[i][j]) {
								int num = queue.pollLast();
								queue.add(2 * num);
								check = false;
							}
							else {
								queue.add(now[i][j]);
								check = true;
							}
						}
					}
					for (int j = 0; j < N; j++) {
						if (queue.isEmpty()) {
							break;
						}
						next[i][j] = queue.poll();
					}
				}
			}

			boolean check = false;
			int each = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (next[i][j] != now[i][j]) {
						check = true;
					}
					each = Math.max(each, next[i][j]);
					max = Math.max(max, next[i][j]);
				}
			}

			if (check && log(max) - log(each) < 5 - idx) {
				dfs(next, idx + 1);
			}
		}
	}

	static double log(double x) {
		return Math.log10(x) / Math.log10(2);
	}
}