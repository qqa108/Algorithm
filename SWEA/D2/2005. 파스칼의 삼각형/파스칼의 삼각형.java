import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int N = sc.nextInt();
			int arr[][] = new int[N][];

			arr[0] = new int[1];
			arr[0][0] = 1;

			for (int i = 1; i < N; i++) {
				arr[i] = new int[i + 1];

				arr[i][0] = 1;
				for (int j = 1; j < i; j++) {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				}
				arr[i][i] = 1;
			}
			
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.print("\n");
			}

		}

		sc.close();
	}
}