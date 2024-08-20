import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static boolean visit[];
	static Point house[];
	static Point base[];
	static Point result[];
	static int sum;
	static int answer;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			visit = new boolean[N];
			house = new Point[N];
			base = new Point[2];
			result = new Point[N];
			answer = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			base[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			base[1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < N; i++) {
				house[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			perm(0);

			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb);
		br.close();
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void perm(int idx) {
		if (idx == N) {
			sum = 0;
			for (int i = 1; i < N; i++) {
				sum = sum + Math.abs(result[i].x - result[i - 1].x) + Math.abs(result[i].y - result[i - 1].y);
			}
			sum = sum + Math.abs(result[0].x - base[0].x) + Math.abs(result[0].y - base[0].y);
			sum = sum + Math.abs(base[1].x - result[N - 1].x) + Math.abs(base[1].y - result[N - 1].y);

			answer = Math.min(answer, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				result[idx] = house[i];
				perm(idx + 1);
				visit[i] = false;
			}
		}
	}
}