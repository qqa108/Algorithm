import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int N = sc.nextInt();
			int A[] = new int[N];
			int B[] = new int[N];

			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
				B[i] = sc.nextInt();
			}

			int P = sc.nextInt();
			int C[] = new int[P];

			for (int i = 0; i < P; i++) {
				C[i] = sc.nextInt();
				int count = 0;
				for (int j = 0; j < N; j++) {
					if (C[i] >= A[j] && C[i] <= B[j]) {
						count++;
					}
				}
				C[i] = count;
			}
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < P; i++) {
				System.out.print(C[i] + " ");
			}
			System.out.println();
		}

		sc.close();
	}
}