import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int arr[][] = new int[7][2];
		int big[] = new int[5];
		int di[] = { 1, 2, 3, 4 };
		int dj[] = { 3, 4, 2, 1 };
		int max = 1;
		int min = 1;
		int index = 0;

		for (int i = 0; i < 6; i++) {
			int num = sc.nextInt();
			int size = sc.nextInt();
			arr[i][0] = num;
			arr[i][1] = size;

			if (big[num] == 0) {
				big[num] = size;
			}
			else {
				big[num] = -1;
			}
		}
		arr[6] = arr[0];

		for (int i = 1; i <= 4; i++) {
			if (big[i] > 0) {
				max = max * big[i];
			}
		}
		for (int i = 0; i < 7; i++) {
			index = arr[i][0] - 1;
			if (arr[i][0] == di[index] && arr[i + 1][0] == dj[index]) {
				min = min * arr[i][1] * arr[i + 1][1];
				break;
			}
		}
		System.out.println((max - min) * K);

		sc.close();
	}
}