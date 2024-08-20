import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			String s = sc.next();
			int count = 0;
			int changed = 0;

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) - '0' != changed) {
					count++;
					changed = s.charAt(i) - '0';
				} 
			}
			System.out.println("#" + test_case + " " + count);
		}
		sc.close();
	}
}