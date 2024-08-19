import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int arr[][];
	static boolean visit[];
	static List<Point> chi = new ArrayList<>();
	static List<Point> home = new ArrayList<>();
	static int sum;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					chi.add(new Point(i, j));
					arr[i][j] = 0;
				}
				else if (arr[i][j] == 1) {
					home.add(new Point(i, j));
				}
			}
		}
		visit = new boolean[chi.size()];
		comb(0, 0);

		System.out.println(min);

		br.close();
	}

	static class Point {
		int x;
		int y;
		int dis = Integer.MAX_VALUE;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void comb(int idx, int start) {
		if (idx == M) {
			sum = 0;
			for (int i = 0; i < chi.size(); i++) {
				if (visit[i]) {
					for (int j = 0; j < home.size(); j++) {
						home.get(j).dis = Math.min(home.get(j).dis,
								Math.abs(home.get(j).x - chi.get(i).x) + Math.abs(home.get(j).y - chi.get(i).y));
					}
				}
			}
			for (int i = 0; i < home.size(); i++) {
				sum = sum + home.get(i).dis;
				home.get(i).dis = Integer.MAX_VALUE;
			}
			min = Math.min(min, sum);

			return;
		}
		for (int i = start; i < chi.size(); i++) {
			visit[i] = true;
			comb(idx + 1, i + 1);
			visit[i] = false;
		}
	}

}