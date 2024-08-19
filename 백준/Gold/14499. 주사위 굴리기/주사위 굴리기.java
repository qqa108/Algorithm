import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int arr[][] = new int[N][M];
		int com[] = new int[c];
		int di[] = { 0, 0, -1, 1 };
		int dj[] = { 1, -1, 0, 0 };
		int par[] = { 0, 0, 0, 0 };
		int ver[] = { 0, 0, 0, 0 };

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			com[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		for (int i = 0; i < c; i++) {
			if (x + di[com[i]] >= 0 && x + di[com[i]] < N && y + dj[com[i]] >= 0 && y + dj[com[i]] < M) {
				if (com[i] == 0) {
					int tmp = par[0];
					for (int j = 0; j < 3; j++) {
						par[j] = par[(j + 1) % 4];
					}
					par[3] = tmp;
					ver[0] = par[0];
					ver[2] = par[2];
				} else if (com[i] == 1) {
					int tmp = par[3];
					for (int j = 2; j >= 0; j--) {
						par[(j + 1) % 4] = par[j];
					}
					par[0] = tmp;
					ver[0] = par[0];
					ver[2] = par[2];
				} else if (com[i] == 2) {
					int tmp = ver[0];
					for (int j = 0; j < 3; j++) {
						ver[j] = ver[(j + 1) % 4];
					}
					ver[3] = tmp;
					par[0] = ver[0];
					par[2] = ver[2];
				} else {
					int tmp = ver[3];
					for (int j = 2; j >= 0; j--) {
						ver[(j + 1) % 4] = ver[j];
					}
					ver[0] = tmp;
					par[0] = ver[0];
					par[2] = ver[2];
				}

				x = x + di[com[i]];
				y = y + dj[com[i]];

				if (arr[x][y] == 0) {
					arr[x][y] = ver[0];
				} else {
					ver[0] = arr[x][y];
					par[0] = arr[x][y];
					arr[x][y] = 0;
				}

				sb.append(ver[2]).append('\n');
			}
		}
		System.out.println(sb);
	}
}