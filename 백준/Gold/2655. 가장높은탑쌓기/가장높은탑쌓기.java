import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Box arr[] = new Box[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[i] = new Box(i + 1, b, h, w);
		}

		Arrays.sort(arr);
		int dp[] = new int[N];

		dp[0] = arr[0].h;
		int result = dp[0];

		for (int i = 1; i < N; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (arr[i].b < arr[j].b) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + arr[i].h;
			result = Math.max(result, dp[i]);
		}

		int count = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (dp[i] == result) {
				count++;
				sb.append(arr[i].idx).append('\n');
				result = result - arr[i].h;
			}
		}
		System.out.println(count);
		System.out.println(sb);
	}

	static class Box implements Comparable<Box> {
		int idx, b, h, w;

		public Box(int idx, int b, int h, int w) {
			this.idx = idx;
			this.b = b;
			this.h = h;
			this.w = w;
		}

		@Override
		public int compareTo(Box o) {
			return o.w - this.w;
		}
	}
}