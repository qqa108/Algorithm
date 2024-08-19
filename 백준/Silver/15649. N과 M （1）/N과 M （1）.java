import java.util.Scanner;

public class Main {
	static boolean used[];
	static int result[];
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		used = new boolean[N + 1];
		result = new int[M + 1];

		getP(1);
		System.out.println(sb);

		sc.close();
	}

	static void getP(int num) {
		if (num == M + 1) {
			for (int i = 1; i <= M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append('\n');
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (used[i] == true) {
				continue;
			}
			used[i] = true;
			result[num] = i;
			getP(num + 1);
			used[i] = false;
		}
	}
}