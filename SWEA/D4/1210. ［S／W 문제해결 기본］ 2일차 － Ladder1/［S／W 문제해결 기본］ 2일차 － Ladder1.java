import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 10;

		for (int test_case = 1; test_case <= tc; test_case++) {
			int arr[][] = new int[100][100];
			int n = sc.nextInt();

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int answer = 0;
			for (int j = 0; j < 100; j++) {
				if (arr[0][j] == 1) {
					int x = j;
					int y = 1;
					int dre = 0;
					while (true) {

						if (y == 99) {
							if (arr[y][x] == 2) {
								answer = j;
							}
							break;
						}
						if (x - 1 >= 0 && arr[y][x - 1] == 1 && dre <= 0) {
							x--;
							dre = -1;
						}
						else if (x + 1 < 100 && arr[y][x + 1] == 1 && dre >= 0) {
							x++;
							dre = 1;
						}
						else {
							y++;
							dre = 0;
						}
					}
				}
			}
			System.out.println("#" + n + " " + answer);
		}
		sc.close();
	}
}

/*

 */