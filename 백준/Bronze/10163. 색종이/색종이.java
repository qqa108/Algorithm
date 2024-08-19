import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[][] = new int[1001][1001];

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();

			for (int j = x; j < x + w; j++) {
				for (int k = y; k < y + h; k++) {
					arr[j][k] = i + 1;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 1001; j++) {
				for (int k = 0; k < 1001; k++) {
					if (arr[j][k] == i + 1) {
						count++;
					}
				}
			}
			System.out.println(count);
			count = 0;
		}

		sc.close();
	}
}