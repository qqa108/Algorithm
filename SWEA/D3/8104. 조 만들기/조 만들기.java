import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int sum = 0;
			int arr[] = new int[K];
			int index = 0;

			if (N % 2 == 0) {
				sum = sum + (1 + (N * K)) * N / 2;
				for (int j = 0; j < K; j++) {
					arr[j] = sum;
				}
			}
			else {
				sum = sum + (1 + ((N - 1) * K)) * (N - 1) / 2;
				for (int i = (N - 1) * K + 1; i <= N * K; i++) {
					
					arr[index++] = sum  + i;
				}
			}
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < K; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();

		}

		sc.close();
	}
}