import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[];
	static int result[];
	static boolean visit[];
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[N];
		visit = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		perm(0);
		System.out.println(max);
	}

	static void perm(int idx) {
		if (idx == N) {
			int sum = 0;
			for (int i = 1; i < N; i++) {
				sum = sum + Math.abs(result[i - 1] - result[i]);
			}
			max = Math.max(max, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				result[idx] = arr[i];
				perm(idx + 1);
				visit[i] = false;
			}
		}
	}
}