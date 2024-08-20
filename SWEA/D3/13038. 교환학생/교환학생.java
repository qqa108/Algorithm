import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int test_case = 1; test_case <= tc; test_case++) {
			int n = sc.nextInt();
			int day[] = new int[7];
			int goal = n;

			for (int i = 0; i < 7; i++) {
				day[i] = sc.nextInt();
			}

			int min = 7 * 100000;

			for (int i = 0; i < 7; i++) {
				goal = n;
				int index = i;
				int count = 0;

				while (true) {
					if (goal == 0) {
						break;
					}
					if (day[index] == 1) {
						goal--;
					}
					count++;
					index = (index + 1) % 7;
				}
				if (min > count) {
					min = count;
				}
			}
			System.out.println("#" + test_case + " " + min);
		}
		sc.close();
	}
}