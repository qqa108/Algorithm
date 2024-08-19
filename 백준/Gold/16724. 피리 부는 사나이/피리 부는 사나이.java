import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char arr[][];
	static int visit[][];
	static Queue<Point> queue = new ArrayDeque<>();
	static Map<Character, Integer> hash = new HashMap<>();
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new int[N][M]; // 0이면 아직 안가본길, 1이면 임시로 시험중, 2면 검증완료

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();
		}
		hash.put('U', 0);
		hash.put('R', 1);
		hash.put('D', 2);
		hash.put('L', 3);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j] == 0) {
					visit[i][j] = 1;
					dfs(i, j);
					visit[i][j] = 2;
				}
			}
		}
		System.out.println(count);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void dfs(int x, int y) {
		int next = hash.get(arr[x][y]);
		int nextx = x + di[next];
		int nexty = y + dj[next];

		if (visit[nextx][nexty] == 0) {
			visit[nextx][nexty] = 1;
			dfs(nextx, nexty);
			visit[nextx][nexty] = 2;
		}
		else if (visit[nextx][nexty] == 1) {
			count++;
			return;
		}
	}
}