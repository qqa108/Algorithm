import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int A[] = new int[N];
			int B[] = new int[M];

			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}

			int max = 0;

			if (N > M) {
				for (int i = 0; i <= N - M; i++) {
					int sum = 0;
					for (int j = 0; j < M; j++) {
						sum = sum + A[j + i] * B[j];
					}
					if (max < sum) {
						max = sum;
					}
				}
			}
			else {
				for (int i = 0; i <= M - N; i++) {
					int sum = 0;
					for (int j = 0; j < N; j++) {
						sum = sum + A[j] * B[j + i];
					}
					if (max < sum) {
						max = sum;
					}
				}
			}
			System.out.println("#" + test_case + " " + max);
		}

		sc.close();
	}
}