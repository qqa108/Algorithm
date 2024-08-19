import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char arr[][];
	static int di[] = { -1, 0, 1 };
	static int count = 0;
	static int finish = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();
		}

		for (int i = 0; i < N; i++) {
			finish = 0;
			dfs(i, 0);
		}
		System.out.println(count);

		br.close();
	}

	static void dfs(int x, int y) {
		if (y == M - 1) {
			finish = 1;
			count++;
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (x + di[i] >= 0 && x + di[i] < N && y + 1 >= 0 && y + 1 < M && arr[x + di[i]][y + 1] == '.') {
				if(finish == 0) {
					arr[x + di[i]][y + 1] = 'o';
				}
				else {
					arr[x + di[i]][y + 1] = '.';
					return;
				}
				dfs(x + di[i], y + 1);
			}
		}
	}
}