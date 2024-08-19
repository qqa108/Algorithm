import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		int C = sc.nextInt();
		int at = 0;
		int left = 0;
		int right = (int) Math.pow(2, N + N);

		while (true) {
			if (N == 0) {
				break;
			}
			int x = R / (int) Math.pow(2, N - 1);
			int y = C / (int) Math.pow(2, N - 1);

			if (x == 0) {
				if (y == 0) {
					at = 0;
				}
				else {
					at = 1;
				}
			}
			else {
				if (y == 0) {
					at = 2;
				}
				else {
					at = 3;
				}
			}

			right = right - (int) Math.pow(2, 2 * N - 2) * (3 - at);
			left = right - (int) Math.pow(2, 2 * N - 2);
			R = R - (x * (int) Math.pow(2, N - 1));
			C = C - (y * (int) Math.pow(2, N - 1));
			N--;
		}
		System.out.println(left);

		sc.close();
	}
}