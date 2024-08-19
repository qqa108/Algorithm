import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long N;
	static long arr[];
	static int result[] = new int[3];
	static boolean visit[] = new boolean[6];
	static long num1, num2, num3, sum;
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		arr = new long[6];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		sum = 0;
		if (N == 1) {
			Arrays.sort(arr);
			for (int i = 0; i < 5; i++) {
				sum = sum + arr[i];
			}
			min = sum;
		}
		else {
			comb(0, 0);
		}

		System.out.println(min);
	}

	static void comb(int idx, int start) {
		if (idx == 3) {
			if ((result[0] == 0 && result[1] == 2 && result[2] == 4)
					|| (result[0] == 0 && result[1] == 3 && result[2] == 4)
					|| (result[0] == 0 && result[1] == 1 && result[2] == 2)
					|| (result[0] == 0 && result[1] == 1 && result[2] == 3)
					|| (result[0] == 1 && result[1] == 2 && result[2] == 5)
					|| (result[0] == 1 && result[1] == 3 && result[2] == 5)
					|| (result[0] == 2 && result[1] == 4 && result[2] == 5)
					|| (result[0] == 3 && result[1] == 4 && result[2] == 5)) {
				num3 = 4;
				num1 = ((N - 2) * (N - 2)) + 4 * (((N - 2) * (N - 2)) + (N - 2));
				num2 = (N * N * 5 - (num3 * 3 + num1)) / 2;

				num1 = num1 + num2 + num3;
				num2 = num2 + num3;

				sum = (num1 * arr[result[0]]) + (num2 * arr[result[1]]) + (num3 * arr[result[2]]);
				min = Math.min(min, sum);
				sum = (num1 * arr[result[0]]) + (num2 * arr[result[2]]) + (num3 * arr[result[1]]);
				min = Math.min(min, sum);
				sum = (num1 * arr[result[1]]) + (num2 * arr[result[0]]) + (num3 * arr[result[2]]);
				min = Math.min(min, sum);
				sum = (num1 * arr[result[1]]) + (num2 * arr[result[2]]) + (num3 * arr[result[0]]);
				min = Math.min(min, sum);
				sum = (num1 * arr[result[2]]) + (num2 * arr[result[0]]) + (num3 * arr[result[1]]);
				min = Math.min(min, sum);
				sum = (num1 * arr[result[2]]) + (num2 * arr[result[1]]) + (num3 * arr[result[0]]);
				min = Math.min(min, sum);				
			}
			return;
		}
		for (int i = start; i < 6; i++) {
			result[idx] = i;
			comb(idx + 1, i + 1);
		}
	}
}