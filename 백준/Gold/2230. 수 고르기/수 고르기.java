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
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int min = Integer.MAX_VALUE;
		int pre = 0;

		for (int i = 0; i < N; i++) {
			boolean check = false;
			for (int j = pre; j < N; j++) {
				int dif = arr[j] - arr[i];
				pre = j;

				if (dif >= M) {
					min = Math.min(min, dif);
					check = true;
					break;
				}
			}
			if (!check) {
				break;
			}
		}
		System.out.println(min);
	}
}