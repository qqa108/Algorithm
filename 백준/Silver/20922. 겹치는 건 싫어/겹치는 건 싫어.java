import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int check[] = new int[100_001];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = 0, count = 0, max = 0;
		while (true) {
			if (right == N || left > right) {
				break;
			}
			if (check[arr[right]] >= K) {
				check[arr[left++]]--;
				count--;
			}
			else {
				check[arr[right++]]++;
				count++;
			}
			max = Math.max(max, count);
		}
		System.out.println(max);
	}
}