import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		BigInteger count = BigInteger.TWO.pow(N).subtract(BigInteger.ONE);

		System.out.println(count);
		if (N <= 20) {
			moveHanoi(N, 1, 2, 3);
			System.out.println(sb);
		}

		sc.close();
	}

	static void moveHanoi(int n, int first, int second, int third) {
		if (n == 0) {
			return;
		}
		moveHanoi(n - 1, first, third, second);
		sb.append(first + " " + third + '\n');
		moveHanoi(n - 1, second, first, third);
	}
}