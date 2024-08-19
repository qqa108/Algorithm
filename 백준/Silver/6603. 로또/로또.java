import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int arr[];
	static int result[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int TC = sc.nextInt();

			if (TC == 0) {
				break;
			}

			arr = new int[TC];
			result = new int[6];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			getLotto(0, 0);

			System.out.println(sb);
			sb.delete(0, sb.length());
		}

		sc.close();
	}

	static void getLotto(int cnt, int start) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < arr.length; i++) {
			result[cnt] = arr[i];
			getLotto(cnt + 1, i + 1);
		}
	}
}