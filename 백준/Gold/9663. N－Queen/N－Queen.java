import java.util.Scanner;

public class Main {
	static int N;
	static int arr[][];
	static boolean visit[];
	static int di[] = { -1, 1, 1, -1 };
	static int dj[] = { 1, 1, -1, -1 };
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		visit = new boolean[N];

		dfs(0);
		System.out.println(count);
		sc.close();
	}

	static void dfs(int idx) {
		if (idx == N) {

			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			boolean check = false;
			if (!visit[i]) {
				for (int j = 0; j < 4; j++) {
					int m = 1;
					while (true) {
						if (idx + m * di[j] < 0 || idx + m * di[j] >= N || i + m * dj[j] < 0 || i + m * dj[j] >= N) {
							break;
						}
						if (arr[idx + m * di[j]][i + m * dj[j]] == 1) {
							check = true;
							break;
						}
						m++;
					}
					if (check) {
						break;
					}
				}
				if (!check) {
					visit[i] = true;
					arr[idx][i] = 1;
					dfs(idx + 1);
					visit[i] = false;
					arr[idx][i] = 0;
				}

			}

		}
	}
}