import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int arr[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int pre = 0;
	static int remain = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					remain++;
				}
			}
		}

		int index = 2;
		int time = 0;
		while (true) {
			if (remain <= 0) {
				break;
			}
			pre = remain;
			arr[0][0] = index;
			dfs(0, 0, index);
			time++;
			index = index + 2;
		}

		System.out.println(time + "\n" + pre);

		br.close();
	}

	static void dfs(int x, int y, int index) {
		for (int i = 0; i < 4; i++) {
			if (x + di[i] >= 0 && x + di[i] < N && y + dj[i] >= 0 && y + dj[i] < M
					&& arr[x + di[i]][y + dj[i]] != index) {
				if (arr[x + di[i]][y + dj[i]] == 1) {
					arr[x + di[i]][y + dj[i]] = index;
					remain--;
				} else {
					arr[x + di[i]][y + dj[i]] = index;
					dfs(x + di[i], y + dj[i], index);
				}
			}
		}
	}
}