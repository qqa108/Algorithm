import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static long arr[];
	static long dp[];

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			arr = new long[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}

			dp = new long[N];
			int index = 0;
			for(int i=0; i<N; i++) {
				if(dp[index] < arr[i]) {
					dp[++index] = arr[i];
				}
				else {
					dp[binary(0, index, arr[i])] = arr[i];
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(index).append('\n');
		}
		System.out.println(sb);
	}

	static int binary(int left, int right, long target) {
		int mid = 0;

		while (true) {
			if (left >= right) {
				break;
			}
			mid = (left + right) / 2;
			if (dp[mid] < target) {
				left = mid + 1;

			} else {
				right = mid;
			}
		}
		return right;
	}
}