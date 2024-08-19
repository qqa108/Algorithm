import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char arr1[][];
	static char arr2[][];
	static boolean visit1[][];
	static boolean visit2[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr1 = new char[N][N];
		arr2 = new char[N][N];
		visit1 = new boolean[N][N];
		visit2 = new boolean[N][N];
		int count1 = 0;
		int count2 = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr1[i] = st.nextToken().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr1[i][j] == 'B') {
					arr2[i][j] = 'B';
				} else {
					arr2[i][j] = 'G';
				}
				if (!visit1[i][j]) {
					dfs1(i, j, arr1[i][j]);
					count1++;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit2[i][j]) {
					dfs2(i, j, arr2[i][j]);
					count2++;
				}
			}
		}
		System.out.println(count1 + " " + count2);
		br.close();
	}

	static void dfs1(int x, int y, char color) {
		for (int i = 0; i < 4; i++) {
			if (x + di[i] >= 0 && x + di[i] < N && y + dj[i] >= 0 && y + dj[i] < N
					&& arr1[x + di[i]][y + dj[i]] == color && !visit1[x + di[i]][y + dj[i]]) {
				visit1[x + di[i]][y + dj[i]] = true;
				dfs1(x + di[i], y + dj[i], color);
			}
		}
	}

	static void dfs2(int x, int y, char color) {
		for (int i = 0; i < 4; i++) {
			if (x + di[i] >= 0 && x + di[i] < N && y + dj[i] >= 0 && y + dj[i] < N
					&& arr2[x + di[i]][y + dj[i]] == color && !visit2[x + di[i]][y + dj[i]]) {
				visit2[x + di[i]][y + dj[i]] = true;
				dfs2(x + di[i], y + dj[i], color);
			}
		}
	}
}