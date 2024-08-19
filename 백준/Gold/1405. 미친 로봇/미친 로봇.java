import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean visit[][];
	static double P[];
	static int di[] = { 0, 0, 1, -1 };
	static int dj[] = { 1, -1, 0, 0 };
	static double answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = new double[4];
		visit = new boolean[(2 * N) + 1][(2 * N) + 1];
		for (int i = 0; i < 4; i++) {
			int a = Integer.parseInt(st.nextToken());
			P[i] = (double) a / 100;
		}
		answer = 0;
		visit[N][N] = true;
		int arr[] = new int[4];
		dfs(0, N, N, arr);
//		System.out.printf("%.50f\n", answer);
		System.out.println(answer);
	}

	static void dfs(int idx, int x, int y, int arr[]) {
		if (idx == N) {
			double p = 0;
			double mul = 1;
			for (int i = 0; i < 4; i++) {
				if (arr[i] != 0) {
					for (int j = 0; j < arr[i]; j++) {
						mul = mul * P[i];
					}
				}
			}
			answer = answer + mul;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (!visit[x + di[i]][y + dj[i]]) {
				visit[x + di[i]][y + dj[i]] = true;
				if (P[i] != 0) {
					arr[i]++;
					dfs(idx + 1, x + di[i], y + dj[i], arr);
					arr[i]--;
				}
				visit[x + di[i]][y + dj[i]] = false;
			}
		}
	}
}