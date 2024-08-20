import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			String answer[][] = new String[N][N];

			int di[] = { -1, 0, 1 };
			int dj[] = { 0, -1, 0 };
			int dx[] = { N - 1, N - 1, 0 };
			int dy[] = { 0, N - 1, N - 1 };
			int da[] = { 0, -1, 0 };
			int db[] = { 1, 0, -1 };

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					answer[i][j] = "";
				}
			}
			for (int T = 0; T < 3; T++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						answer[i][T] = answer[i][T] + arr[dx[T] + j * di[T] + i * da[T]][dy[T] + j * dj[T] + i * db[T]];
					}
				}
			}
			
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(answer[i][j] + " ");
				}
				System.out.println();
			}

		}

		sc.close();
	}
}