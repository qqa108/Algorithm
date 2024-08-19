import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 0; tc < TC; tc++) {

			int N = sc.nextInt();
			int M = sc.nextInt(); // MCN 조합을 계산하면됨

			long sum1 = 1;
			long sum2 = 1;
			if (N > M - N) {
				for (int i = M; i > N; i--) {
					sum1 = sum1 * i;
				}
				for (int i = M - N; i > 0; i--) {
					sum2 = sum2 * i;
				}
			}
			else {
				for (int i = M; i > M - N; i--) {
					sum1 = sum1 * i;
				}
				for (int i = N; i > 0; i--) {
					sum2 = sum2 * i;
				}
			}
			sb.append((sum1 / sum2) + "\n");
		}
		System.out.println(sb);
		sc.close();
	}
}