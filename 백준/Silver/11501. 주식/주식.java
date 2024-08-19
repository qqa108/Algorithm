import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int max = arr[N - 1];
			long sum = 0;

			for (int i = N - 1; i >= 0; i--) {
				max = Math.max(max, arr[i]);
				if (max - arr[i] > 0) {
					sum = sum + max - arr[i];
				}
			}
			sb.append(sum).append('\n');
		}
		System.out.println(sb);
	}
}