import java.util.Scanner;

public class Solution {
	static boolean used[];
	static int N;
	static int L;
	static int taste[];
	static int cal[];
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			N = sc.nextInt();
			L = sc.nextInt();
			taste = new int[N];
			cal = new int[N];
			used = new boolean[N];
			max = 0;

			for (int i = 0; i < N; i++) {
				taste[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}

			subset(0, 0, 0);

			System.out.println("#" + test_case + " " + max);
		}

		sc.close();
	}

	static void subset(int idx, int tsum, int csum) {
		if (idx == N) {
			if (csum <= L && tsum > max) {
				max = tsum;
			}
			return;
		}
		used[idx] = true;
		subset(idx + 1, tsum + taste[idx], csum + cal[idx]);
		used[idx] = false;
		subset(idx + 1, tsum, csum);
	}
}