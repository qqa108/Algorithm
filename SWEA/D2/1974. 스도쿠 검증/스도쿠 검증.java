import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {

			int arr[][] = new int[10][10];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int answer = 1;

			for (int i = 0; i < 9; i++) {
				if (answer == 0) {
					break;
				}
				int check[] = new int[10];
				for (int j = 0; j < 9; j++) {
					check[arr[i][j]] = 1;
				}
				for (int j = 1; j <= 9; j++) {
					if (check[j] == 0) {
						answer = 0;
						break;
					}
				}
			}
			for (int i = 0; i < 9; i++) {
				if (answer == 0) {
					break;
				}
				int check[] = new int[10];
				for (int j = 0; j < 9; j++) {
					check[arr[j][i]] = 1;
				}
				for (int j = 1; j <= 9; j++) {
					if (check[j] == 0) {
						answer = 0;
						break;
					}
				}
			}

			int di[] = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
			int dj[] = { 0, 1, 1, 0, -1, -1, -1, 0, 1 };
			for (int i = 1; i < 9; i = i + 3) {
				if (answer == 0) {
					break;
				}
				for (int j = 1; j < 9; j = j + 3) {
					int check[] = new int[10];
					for (int k = 0; k < 9; k++) {
						check[arr[i + di[k]][j + dj[k]]] = 1;
					}
					for (int k = 1; k <= 9; k++) {
						if (check[k] == 0) {
							answer = 0;
							break;
						}
					}
					if (answer == 0) {
						break;
					}
				}
			}

			System.out.println("#" + test_case + " " + answer);
		}

		sc.close();
	}
}