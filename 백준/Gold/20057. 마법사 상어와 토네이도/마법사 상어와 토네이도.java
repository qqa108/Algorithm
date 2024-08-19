import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static int di[] = { 0, 1, 0, -1 };
	static int dj[] = { -1, 0, 1, 0 };
	static int si[] = { -1, 1, -2, 2, 0, -1, 1, -1, 1, 0 };
	static int sj[] = { 1, 1, 0, 0, -2, 0, 0, -1, -1, -1 };
	static int per[] = { 1, 1, 2, 2, 5, 7, 7, 10, 10, 0 };
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int x = N / 2;
		int y = N / 2;
		int index = 0;
		int count = 0;
		int str = 1;
		int two = 0;

		while (true) {
			if (x == 0 && y == 0) {
				break;
			}

			x = x + di[index];
			y = y + dj[index];
			int pre = arr[x][y];
			count++;

			if (arr[x][y] != 0) {
				for (int i = 0; i < 10; i++) {
					int nextx = 0;
					int nexty = 0;

					if (index == 0) {
						nextx = x + si[i];
						nexty = y + sj[i];
					}
					else if (index == 1) {
						nextx = x - sj[i];
						nexty = y + si[i];
					}
					else if (index == 2) {
						nextx = x - si[i];
						nexty = y - sj[i];
					}
					else {
						nextx = x + sj[i];
						nexty = y + si[i];
					}

					int send = (arr[x][y] * per[i]) / 100;
					// int send = per[i] / arr[x][y];
					if (i == 9) {
						send = pre;
					}

					if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < N) {
						arr[nextx][nexty] = arr[nextx][nexty] + send;
					}
					else {
						sum = sum + send;
					}
					pre = pre - send;

				}
				arr[x][y] = pre;
			}

			if (count == str) {
				two++;
				if (two == 2) {
					two = 0;
					str++;
				}
				index = (index + 1) % 4;
				count = 0;
			}
		}
		System.out.println(sum);
	}
}