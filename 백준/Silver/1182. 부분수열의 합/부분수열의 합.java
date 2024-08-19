import java.util.Scanner;

public class Main {
	static boolean used[];
	static int arr[];
	static int N;
	static int S;
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		used = new boolean[N];

		if (S == 0) {
			count = -1;
		}
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		getSum(0);

		System.out.println(count);

		sc.close();
	}

	static void getSum(int idx) {
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (used[i]) {
					sum = sum + arr[i];
				}
			}
			if (sum == S) {
				count++;
			}
			return;
		}
		used[idx] = true;
		getSum(idx + 1);
		used[idx] = false;
		getSum(idx + 1);
	}
}