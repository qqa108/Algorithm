import java.util.Scanner;

public class Main  {
	static StringBuilder sb = new StringBuilder();
	static long count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		moveHanoi(N, 1, 2, 3);
		System.out.println(count);
		System.out.println(sb);
		sc.close();
	}

	static void moveHanoi(int n, int first, int second, int third) {
		if (n == 0) {
			return;
		}
		moveHanoi(n - 1, first, third, second);
		sb.append(first + " " + third + '\n');
		count++;
		moveHanoi(n - 1, second, first, third);
	}
}