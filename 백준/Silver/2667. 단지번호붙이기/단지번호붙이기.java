import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static int di[] = { 0, -1, 0, 1 };
	static int dj[] = { 1, 0, -1, 0 };
	static int count = 0;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					dfs(i, j);
					list.add(count);
					count = 0;
				}
			}
		}
		Collections.sort(list);
		sb.append(list.size() + "\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + "\n");
		}
		System.out.println(sb);

		br.close();
	}

	static void dfs(int x, int y) {
		if (arr[x][y] == 1) {
			arr[x][y] = 0;
			count++;
		}
		for (int i = 0; i < 4; i++) {
			if (x + di[i] >= 0 && x + di[i] < N && y + dj[i] >= 0 && y + dj[i] < N && arr[x + di[i]][y + dj[i]] == 1) {
				dfs(x + di[i], y + dj[i]);
			}
		}
	}
}