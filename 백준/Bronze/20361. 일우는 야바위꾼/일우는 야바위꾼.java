import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		for (int test_case = 1; test_case <= 1; test_case++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			int K = sc.nextInt();
			int arr[] = new int[N + 1];
			arr[X] = 1;

			for (int i = 0; i < K; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();

				int tmp = arr[from];
				arr[from] = arr[to];
				arr[to] = tmp;
			}
			for (int i = 1; i <= N; i++) {
				if (arr[i] == 1) {
					System.out.println( i);
					break;
				}
			}
		}
		sc.close();
	}
}