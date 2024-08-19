import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int result[];
	static int N;
	static int R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		result = new int[R];

		comb(0, 0);
		System.out.println(sb);

		sc.close();
	}

	static void comb(int cnt, int start) {
		if (cnt == R) {
			for (int i = 0; i < R; i++) {
				sb.append(result[i] + " ");
			}
			sb.append('\n');
			return;
		}
		for (int i = start; i < N; i++) {
			result[cnt] = i + 1;
			comb(cnt + 1, i + 1);

		}
	}
}