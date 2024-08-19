import java.util.Scanner;

public class Main {
	static long arr[][] = new long[4][2];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			arr[i][0] = sc.nextLong();
			arr[i][1] = sc.nextLong();
		}
		int check1 = ccw(0, 1, 2) * ccw(0, 1, 3);
		int check2 = ccw(2, 3, 0) * ccw(2, 3, 1);
		int answer = 0;

		if (check1 == 0 && check2 == 0) {
			if (Math.min(arr[0][0], arr[1][0]) <= Math.max(arr[2][0], arr[3][0])
					&& Math.min(arr[2][0], arr[3][0]) <= Math.max(arr[0][0], arr[1][0])
					&& Math.min(arr[0][1], arr[1][1]) <= Math.max(arr[2][1], arr[3][1])
					&& Math.min(arr[2][1], arr[3][1]) <= Math.max(arr[0][1], arr[1][1])) {
				answer = 1;
			}
		} else if (check1 <= 0 && check2 <= 0) {
			answer = 1;
		}
		System.out.println(answer);
	}

	static int ccw(int a, int b, int c) {
		long result = (arr[a][0] * arr[b][1] + arr[b][0] * arr[c][1] + arr[c][0] * arr[a][1])
				- (arr[a][0] * arr[c][1] + arr[c][0] * arr[b][1] + arr[b][0] * arr[a][1]);

		if (result == 0)
			return 0;
		else if (result > 0)
			return 1;
		else
			return -1;
	}
}