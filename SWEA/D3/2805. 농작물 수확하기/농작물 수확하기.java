import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			int sum = 0;

			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = s.charAt(j) - '0';

					if (i <= N / 2 && j >= N / 2 - i && j <= N / 2 + i) {
						sum = sum + arr[i][j];
					} else if (i > N / 2 && j >= i - (N / 2) && j <= (N / 2) * 3 - i) {
						sum = sum + arr[i][j];
					}
				}
			}
			System.out.println("#" + test_case + " " + sum);

		}
		sc.close();
	}
}