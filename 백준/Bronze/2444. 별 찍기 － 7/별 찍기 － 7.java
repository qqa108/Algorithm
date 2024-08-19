import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 2 * N - 1; j++) {
				if (j >= N - i + 1 && j <= N + i - 1) {
					System.out.print("*");
				}
				else if (j > N + i - 1) {
					break;
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.print('\n');
		}

		for (int i = N - 1; i > 0; i--) {
			for (int j = 2 * N - 1; j >= 1; j--) {
				if (j >= N - i + 1 && j <= N + i - 1) {
					System.out.print("*");
				}
				else if (j < N - i + 1) {
					break;
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.print('\n');
		}
		sc.close();
	}
}