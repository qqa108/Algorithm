import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String s = sc.nextLine();

		for (int i = 0; i < N; i++) {
			int A[] = new int[5];
			int B[] = new int[5];
			int a = sc.nextInt();
			for (int j = 0; j < a; j++) {
				int tmp = sc.nextInt();
				A[tmp]++;
			}
			int b = sc.nextInt();
			for (int j = 0; j < b; j++) {
				int tmp = sc.nextInt();
				B[tmp]++;
			}
			char winner = 'D';

			if (A[4] < B[4]) {
				winner = 'B';
			}
			else if (A[4] > B[4]) {
				winner = 'A';
			}

			else if (A[3] < B[3]) {
				winner = 'B';
			}
			else if (A[3] > B[3]) {
				winner = 'A';
			}

			else if (A[2] < B[2]) {
				winner = 'B';
			}
			else if (A[2] > B[2]) {
				winner = 'A';
			}

			else if (A[1] < B[1]) {
				winner = 'B';
			}
			else if (A[1] > B[1]) {
				winner = 'A';
			}
			System.out.println(winner);
		}

		sc.close();
	}
}