import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		int di[] = { 0, 0, 1, -1, -1, -1, 1, 1 };
		int dj[] = { 1, -1, 0, 0, 1, -1, -1, 1 };
		for (int test_case = 1; test_case <= tc; test_case++) {
			int N = sc.nextInt();
			char arr[][] = new char[N][N];

			for (int i = 0; i < N; i++) {
				String s = sc.next();
				arr[i] = s.toCharArray();
			}

			int answer = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int index = 0; index < 8; index++) {
						int count = 0;
						for (int k = 0; k < 5; k++) {
							if (i + di[index] * k < 0 || i + di[index] * k >= N || j + dj[index] * k < 0
									|| j + dj[index] * k >= N) {
								break;
							}
							else {
								if (arr[i + di[index] * k][j + dj[index] * k] == 'o') {
									count++;
								}
								else {
									count = 0;
								}
							}
						}
						if(count == 5) {
							answer = 1;
							break;
						}
					}

					if (answer == 1) {
						break;
					}
				}
				if (answer == 1) {
					break;
				}
			}

			if (answer == 1) {
				System.out.println("#" + test_case + " YES");
			}
			else {
				System.out.println("#" + test_case + " NO");
			}

		}

		sc.close();
	}
}