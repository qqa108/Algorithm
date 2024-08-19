import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int w;
	static int h;
	static int di[] = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int dj[] = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int count;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		while (true) {
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				break;
			}
			arr = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());

			count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1) {
						dfs(i, j);
						count++;
					}
				}
			}

			sb.append(count + "\n");
		}
		System.out.println(sb);

		br.close();
	}

	static void dfs(int x, int y) {
		if (arr[x][y] == 1) {
			arr[x][y] = 0;
		}
		for (int i = 0; i < 8; i++) {
			if (x + di[i] >= 0 && x + di[i] < h && y + dj[i] >= 0 && y + dj[i] < w && arr[x + di[i]][y + dj[i]] == 1) {
				dfs(x + di[i], y + dj[i]);
			}
		}
	}
}