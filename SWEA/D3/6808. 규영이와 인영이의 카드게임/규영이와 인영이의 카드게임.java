import java.util.Scanner;

public class Solution {
	static int inyoung[];
	static int guyoung[];
	static boolean used[];
	static int win;
	static int lose;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
			guyoung = new int[9];
			inyoung = new int[9];
			used = new boolean[9];
			win = 0;
			lose = 0;

			for (int i = 0; i < 9; i++) {
				guyoung[i] = sc.nextInt();
				arr[guyoung[i] - 1] = 0;
			}

			int index = 0;
			for (int i = 0; i < 18; i++) {
				if (arr[i] != 0) {
					inyoung[index++] = arr[i];
				}
			}

			perm(0, 0);
			System.out.println("#" + test_case + " " + win + " " + lose);
		}

		sc.close();
	}

	static void perm(int idx, int sum) {
		if (idx == 9) {
			if (sum > 0) {
				// 규영승리
				win++;
			} else if (sum < 0) {
				lose++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (used[i] == true) {
				continue;
			}
			used[i] = true;
			if (guyoung[idx] > inyoung[i]) {
				perm(idx + 1, sum + guyoung[idx] + inyoung[i]);
			} else {
				perm(idx + 1, sum - (inyoung[i] + guyoung[idx]));
			}
			used[i] = false;
		}
	}
}