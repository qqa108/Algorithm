import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int sum = 0;

			for (int i = 0; i < 10; i++) {
				int num = sc.nextInt();

				if (num % 2 == 1) {
					sum = sum + num;
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}

		sc.close();
	}
}