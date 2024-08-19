import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[];
	static int cal[];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		cal = new int[4];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		dfs(1, arr[0], cal[0], cal[1], cal[2], cal[3]);
		System.out.println(max);
		System.out.println(min);
	}

	static void dfs(int idx, int sum, int a, int b, int c, int d) {
		if (idx == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		if (a != 0) {
			dfs(idx + 1, sum + arr[idx], a - 1, b, c, d);
		}
		if (b != 0) {
			dfs(idx + 1, sum - arr[idx], a, b - 1, c, d);
		}
		if (c != 0) {
			dfs(idx + 1, sum * arr[idx], a, b, c - 1, d);
		}
		if (d != 0) {
			dfs(idx + 1, sum / arr[idx], a, b, c, d - 1);
		}
	}
}