import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int n = sc.nextInt();
			int day[] = new int[n];
			
			for(int i=0; i<n; i++) {
				day[i] = sc.nextInt();
			}
			
			int max = day[n-1];
			long sum = 0;
			
			for(int i=n-2; i>=0; i--) {
				if(max > day[i]) {
					sum = sum + max - day[i];
				}
				else {
					max = day[i];
				}
			}

			System.out.println("#" + test_case + " " + sum);
		}

		sc.close();
	}
}