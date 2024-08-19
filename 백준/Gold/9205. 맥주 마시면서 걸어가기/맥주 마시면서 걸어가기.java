import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer> list[];
	static boolean visit[];
	static boolean finish;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			int store = Integer.parseInt(st.nextToken());
			N = store + 2;
			Point arr[] = new Point[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[i] = new Point(x, y);
			}

			list = new ArrayList[N];

			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
				for (int j = 0; j < N; j++) {
					if (i == j) {
						continue;
					}
					if (Math.abs(arr[i].x - arr[j].x) + Math.abs(arr[i].y - arr[j].y) <= 1000) {
						list[i].add(j);
					}
				}
			}

			finish = false;
			visit = new boolean[N];
			visit[0] = true;
			dfs(0);

			if (finish) {
				sb.append("happy").append('\n');
			}
			else {
				sb.append("sad").append('\n');
			}
		}
		System.out.println(sb);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void dfs(int index) {
		if (index == N - 1) {
			finish = true;
			return;
		}
		for (int i = 0; i < list[index].size(); i++) {
			if (finish) {
				return;
			}
			int num = list[index].get(i);
			if (!visit[num]) {
				visit[num] = true;
				dfs(num);
			}
		}
	}
}