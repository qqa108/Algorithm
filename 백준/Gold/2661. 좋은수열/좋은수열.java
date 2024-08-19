import java.util.Scanner;

public class Main {
	static int N;
	static int arr[];
	static boolean finish = false;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		dfs(0);
		System.out.println(sb);
	}

	static void dfs(int idx) {
		if (idx == N) {
			for (int a = 0; a < N; a++) {
				sb.append(arr[a]);
			}
			finish = true;
			return;
		}
		for (int i = 1; i <= 3; i++) {
			if (finish) {
				return;
			}
			arr[idx] = i;

			boolean check = true;
			out:
			for (int j = 1; j <= 80; j++) {
				int right = 0;
				int left = 0;
				for (int k = j - 1; k >= 0; k--) {
					if (idx - j - k < 0) {
						break out;
					}
					right = (10 * right) + arr[idx - k];
					left = (10 * left) + arr[idx - j - k];
				}
				if (right == left) {
					check = false;
					break out;
				}
			}
			if (check) {
				dfs(idx + 1);
			}
		}
	}
}