import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[];
	static int dp[];
	static int trace[];

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		trace = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N];
		int len = 0;

		for (int i = 0; i < N; i++) {
			int idx = lowerBound(dp, len, arr[i]);
			dp[idx] = arr[i];
			trace[i] = idx;
			if (idx == len)
				len++;
		}

		sb.append(len).append('\n');

		int[] lis = new int[len];
		int idx = len - 1;
		for (int i = N - 1; i >= 0; i--) {
			if (trace[i] == idx) {
				lis[idx--] = arr[i];
			}
		}

		for (int num : lis) {
			sb.append(num).append(' ');
		}

		System.out.println(sb);
	}

	static int lowerBound(int[] arr, int len, int target) {
		int left = 0;
		int right = len;

		while (left < right) {
			int mid = (left + right) / 2;
			if (arr[mid] < target) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}

		return right;
	}
}