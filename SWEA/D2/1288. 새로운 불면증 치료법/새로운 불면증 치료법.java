import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int N = sc.nextInt();
			int arr[] = new int[10];
			int answer = 0;
			int plus = N;

			N = 0;
			while (true) {
				if (answer == 1) {
					break;
				}
				N = N + plus;
				String s = Integer.toString(N);
				for (int i = 0; i < s.length(); i++) {
					arr[(int) (s.charAt(i) - '0')] = 1;
				}
				

				for (int i = 0; i < 10; i++) {
					if (arr[i] != 1) {
						break;
					}
					if (i == 9) {
						answer = 1;
					}
				}

			}
			System.out.println("#" + test_case + " " + N);

		}

		sc.close();
	}
}