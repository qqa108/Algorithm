import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[][] = new int[101][101];

		for (int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			for (int j = x1; j < x2; j++) {
				for (int k = y1; k < y2; k++) {
					arr[j][k]++;
				}
			}
		}
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (arr[i][j] != 0) {
					sum++;
				}
			}
		}
		System.out.println(sum);
		sc.close();
	}
}