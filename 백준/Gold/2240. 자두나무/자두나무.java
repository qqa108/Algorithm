import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		int dp[][][] = new int[N + 1][W + 1][2];
		int max = 0;

		if (arr[0] == 0) {
			dp[1][0][0] = 1;
		}
		else if (W != 0) {
			dp[1][1][1] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= W; j++) {
				for (int k = 0; k < 2; k++) {
					if (arr[i - 1] == k) {
						dp[i][j][k] = dp[i - 1][j][k] + 1;
						if (j > 0) {
							dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - 1][(k + 1) % 2] + 1);
						}
					}
					else {
						dp[i][j][k] = dp[i - 1][j][k];
						if (j > 0) {
							dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - 1][(k + 1) % 2]);
						}
					}
				}
			}
		}

		for (int j = 0; j <= W; j++) {
			for (int k = 0; k < 2; k++) {
				max = Math.max(max, dp[N][j][k]);
			}
		}
		System.out.println(max);
	}
}