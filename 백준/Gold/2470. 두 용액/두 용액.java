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
		int arr[] = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = N - 1;
		int answer1 = 0;
		int answer2 = 0;
		while (true) {
			if (left >= right) {
				break;
			}

			int sum = arr[left] + arr[right];
			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				answer1 = arr[left];
				answer2 = arr[right];
			}

			if (sum > 0) {
				right--;
			}
			else if (sum < 0) {
				left++;
			}
			else {
				break;
			}
		}
		System.out.println(answer1 + " " + answer2);
	}
}