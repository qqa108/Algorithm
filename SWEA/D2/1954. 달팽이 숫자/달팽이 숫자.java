import java.util.Scanner;

public class Solution {

	static int di[] = { 0, 1, 0, -1 };
	static int dj[] = { 1, 0, -1, 0 };
	static int delta;
	static int index;
	static int N;
	static int arr[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			N = sc.nextInt();
			arr = new int[N][N];
			delta = 0;
			index = 1;

			Snail(0, 0, 0);
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.print('\n');
			}
		}

		sc.close();
	}

	static void Snail(int i, int j, int delta) {
		if (index == N * N) {
			arr[i][j] = index;
			return;
		}
		if (i + di[delta] >= N || i + di[delta] < 0 || j + dj[delta] >= N || j + dj[delta] < 0
				|| arr[i + di[delta]][j + dj[delta]] != 0) {
			delta = (delta + 1) % 4;
			Snail(i, j, delta);
		} else {
			arr[i][j] = index++;
			Snail(i + di[delta], j + dj[delta], delta);
		}
	}
}