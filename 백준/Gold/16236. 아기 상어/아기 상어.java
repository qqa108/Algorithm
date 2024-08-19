import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static boolean visit[][];
	static int sharki, sharkj, sharksize = 2, sharkexp = 0;
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					arr[i][j] = 0;
					sharki = i;
					sharkj = j;
				}
			}
		}

		while (true) {
			if (!bfs()) {
				break;
			}
		}
		System.out.println(answer);
	}

	static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.x == o.x) {
				return this.y - o.y;
			}
			else {
				return this.x - o.x;
			}
		}
	}

	static boolean bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		visit = new boolean[N][N];
		int distance = 0;
		boolean eat = false;

		queue.add(new Point(sharki, sharkj));
		visit[sharki][sharkj] = true;

		while (!queue.isEmpty()) {
			PriorityQueue<Point> fish = new PriorityQueue<>();
			int size = queue.size();

			for (int q = 0; q < size; q++) {
				Point now = queue.poll();

				if (arr[now.x][now.y] != 0 && arr[now.x][now.y] < sharksize) {
					fish.add(new Point(now.x, now.y));
				}

				for (int i = 0; i < 4; i++) {
					int nexti = now.x + di[i];
					int nextj = now.y + dj[i];
					if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && !visit[nexti][nextj]
							&& arr[nexti][nextj] <= sharksize) {
						queue.add(new Point(nexti, nextj));
						visit[nexti][nextj] = true;
					}
				}
			}
			if (!fish.isEmpty()) {
				Point feed = fish.poll();
				sharki = feed.x;
				sharkj = feed.y;
				arr[feed.x][feed.y] = 0;
				sharkexp++;
				if (sharkexp == sharksize) {
					sharksize++;
					sharkexp = 0;
				}
				answer = answer + distance;
				eat = true;
				break;
			}
			distance++;
		}
		return eat;
	}
}