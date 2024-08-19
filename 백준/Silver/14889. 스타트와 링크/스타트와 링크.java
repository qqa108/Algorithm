import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static boolean visit[];
	static int sum;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit = new boolean[N];
		comb(0, 0);
		System.out.println(min);

		br.close();
	}

	static void comb(int idx, int start) {
		if (idx == N / 2) {
			sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) {
						continue;
					}
					if (visit[i] == true && visit[j] == true) {
						sum = sum + arr[i][j];
					} else if (visit[i] == false && visit[j] == false) {
						sum = sum - arr[i][j];
					}
				}
			}
			min = Math.min(Math.abs(sum), min);
			return;
		}
		for (int i = start; i < N; i++) {
			visit[i] = true;
			comb(idx + 1, i + 1);
			visit[i] = false;
		}
	}
}