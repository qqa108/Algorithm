import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			String s = Integer.toString(i);
			String tmp = "";

			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') {

					tmp = tmp + "-";
				}
			}
			if (tmp.equals("")) {
				System.out.print(s + " ");
			}
			else {
				System.out.print(tmp + " ");
			}
		}

		sc.close();
	}
}