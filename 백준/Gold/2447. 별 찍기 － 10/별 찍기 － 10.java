import java.util.Scanner;

public class Main {
	static char arr[][];

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new char[N][N];
		print(0, N, 0, N, N, N / 3, false);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);

		sc.close();
	}

	static void print(int si, int ei, int sj, int ej, int n, int k, boolean center) {
		int count = 0;
		for (int i = si; i < ei; i = i + k) {
			for (int j = sj; j < ej; j = j + k) {
				if (n == 1) {
					if (center) {
						arr[i][j] = ' ';
					}
					else {
						arr[i][j] = '*';
					}
					return;
				}
				else {
					if (center || count == 4) {
						print(i, i + k, j, j + k, k, k / 3, true);
					}
					else {
						print(i, i + k, j, j + k, k, k / 3, false);
					}
				}
				count++;
			}
		}
	}
}