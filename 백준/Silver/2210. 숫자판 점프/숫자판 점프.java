import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int arr[][];
	static boolean check[];
	static int result[];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[5][5];
		check = new boolean[1000000];
		result = new int[6];

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				result[0] = arr[i][j];
				dfs(i, j, 1);
			}
		}
		System.out.println(count);

		br.close();
	}

	static void dfs(int x, int y, int idx) {
		if (idx == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(result[i]);
			}
			if (check[Integer.parseInt(sb.toString())] == false) {
				check[Integer.parseInt(sb.toString())] = true;
				count++;
			}
			sb.setLength(0);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (x + di[i] >= 0 && x + di[i] < 5 && y + dj[i] >= 0 && y + dj[i] < 5) {
				result[idx] = arr[x + di[i]][y + dj[i]];
				dfs(x + di[i], y + dj[i], idx + 1);
			}
		}
	}
}