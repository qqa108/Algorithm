import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int x = N / 5;
		int y = (N - 5 * x) / 3;
		int answer = 0;

		for (int i = N; i >= 0; i--) {
			if (x < 0) {
				answer = -1;
				break;
			}
			if (5 * x + 3 * y == N) {
				answer = x + y;
				break;
			} else {
				x--;
				y = (N - 5 * x) / 3;
			}
		}

		System.out.println(answer);

		sc.close();
	}
}