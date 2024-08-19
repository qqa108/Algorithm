import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 1;
		int sum = arr[0];
		int min = Integer.MAX_VALUE;

		while (true) {
			if (sum >= S) {
				min = Math.min(min, right - left);
			}
			if (sum < S && right < N) {
				sum = sum + arr[right++];
			}
			else if (sum >= S && left < right) {
				sum = sum - arr[left++];
			}
			else {
				break;
			}
		}
		if (min == Integer.MAX_VALUE) {
			min = 0;
		}
		System.out.println(min);
	}
}