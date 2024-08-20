import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			int avg = 0;

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				avg = avg + arr[i];
			}
			avg = avg / N;
			Arrays.sort(arr);

			int count = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] > avg) {
					count = count + arr[i] - avg;
				}
				else {
					break;
				}
			}
			System.out.println("#" + test_case + " " + count);
		}

		sc.close();
	}
}