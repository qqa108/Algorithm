import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		String day28[] = { "02" };
		String day30[] = { "04", "06", "09", "11" };

		for (int test_case = 1; test_case <= tc; test_case++) {
			String s = sc.next();
			String Y = "" + s.charAt(0) + s.charAt(1) + s.charAt(2) + s.charAt(3);
			String M = "" + s.charAt(4) + s.charAt(5);
			String D = "" + s.charAt(6) + s.charAt(7);
			int answer = 0;

			if (Integer.valueOf(M) >= 1 && Integer.valueOf(M) <= 12) {
				answer = 1;
			}
			if (answer == 1) {
				if (M.equals("02")) {
					if (Integer.valueOf(D) >= 1 && Integer.valueOf(D) <= 28) {
						answer = 1;
					}
					else {
						answer = 0;
					}
				}
				else if (M.equals("04") || M.equals("06") || M.equals("09") || M.equals("11")) {
					if (Integer.valueOf(D) >= 1 && Integer.valueOf(D) <= 30) {
						answer = 1;
					}
					else {
						answer = 0;
					}
				}
				else {
					if (Integer.valueOf(D) >= 1 && Integer.valueOf(D) <= 31) {
						answer = 1;
					}
					else {
						answer = 0;
					}
				}
			}
			System.out.print("#" + test_case + " ");
			if (answer == 0) {
				System.out.println(-1);
			}
			else {
				System.out.println(Y + "/" + M + "/" + D);
			}

		}

		sc.close();
	}
}