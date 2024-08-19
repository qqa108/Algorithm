import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int card[] = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		int dp[] = new int[N + 1];
		int tmp[] = new int[N + 1];
		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			tmp[0] = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j != 0) {
					tmp[j] = Math.max(tmp[j - 1], card[j] + dp[i - j]);
				}
				else {
					tmp[j] = Math.max(tmp[j - 1], (i / j) * card[j]);
				}
			}
			dp[i] = Math.max(tmp[i], card[i]);
		}
		System.out.println(dp[N]);
	}
}