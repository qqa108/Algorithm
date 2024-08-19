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
		long arr[] = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);

		long answer[] = new long[3];
		long min = Long.MAX_VALUE;
		for (int i = 1; i < N - 1; i++) {
			int left = 0;
			int mid = i;
			int right = N - 1;

			while (true) {
				if (left >= right) {
					break;
				}

				long sum = arr[left] + arr[mid] + arr[right];
				if (min > Math.abs(sum)) {
					min = Math.abs(sum);
					answer[0] = arr[left];
					answer[1] = arr[mid];
					answer[2] = arr[right];
				}

				if (sum > 0) {
					right--;
					if (right == mid) {
						right--;
					}
				} else if (sum < 0) {
					left++;
					if (left == mid) {
						left++;
					}
				} else {
					break;
				}
			}
		}
		Arrays.sort(answer);
		System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
	}
}