import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[];
	static int dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N + 1];
		int index = 1;
		for (int i = 1; i <= N; i++) {
			if (dp[index - 1] < arr[i]) {
				dp[index++] = arr[i];
			} else if (dp[index - 1] > arr[i]) {
				dp[binary(0, index - 1, arr[i])] = arr[i];
			}
		}

		int count = 0;
		for (int i = 0; i <= N; i++) {
			if (dp[i] != 0) {
				count++;
			}
		}

		System.out.println(count);
	}

	static int binary(int left, int right, int target) {
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