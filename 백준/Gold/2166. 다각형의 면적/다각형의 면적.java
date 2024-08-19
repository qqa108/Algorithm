import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long arr[][] = new long[N + 1][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		arr[N][0] = arr[0][0];
		arr[N][1] = arr[0][1];

		long sum1 = 0;
		long sum2 = 0;
		for (int i = 0; i < N; i++) {
			sum1 = sum1 + (arr[i][0] * arr[i + 1][1]);
			sum2 = sum2 + (arr[i + 1][0] * arr[i][1]);
		}
		double answer = Math.abs(sum1 - sum2) / 2.0;

		System.out.printf("%.1f", answer);
	}
}