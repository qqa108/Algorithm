import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int P;
	static int oil;
	static int arr[][];
	static boolean visit[][];
	static Queue<Point> queue = new ArrayDeque<>(); // 택시가 이동하는 큐
	static PriorityQueue<Point> person = new PriorityQueue<>(); // 승객의 우선순위를 정하는 큐
	static Point arrive[]; // 승객의 도착점. 도착점은 따로 맵에 표시하지 않기 위해
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int remain; // 잔여 승객
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		oil = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		visit = new boolean[N][N];
		arrive = new Point[P + 2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int taxix = Integer.parseInt(st.nextToken()) - 1;
		int taxiy = Integer.parseInt(st.nextToken()) - 1;
		queue.add(new Point(taxix, taxiy));
		visit[taxix][taxiy] = true;

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = i + 2; // 맵에 손님위치추가
			int arrx = Integer.parseInt(st.nextToken()) - 1;
			int arry = Integer.parseInt(st.nextToken()) - 1;
			arrive[i + 2] = new Point(arrx, arry); // 도착점은 따로 관
		}
		remain = P;
		bfs();
		System.out.println(answer);
	}

	static class Point implements Comparable<Point> {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			if (oil == 0) { // 연료가 부족하면
				return;
			}
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				if (arr[now.x][now.y] >= 2) { // 승객을 태울 수 있으면
					person.add(new Point(now.x, now.y));
				}
				for (int i = 0; i < 4; i++) {
					int nextx = now.x + di[i];
					int nexty = now.y + dj[i];
					if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < N && !visit[nextx][nexty]
							&& arr[nextx][nexty] != 1) {
						queue.add(new Point(nextx, nexty));
						visit[nextx][nexty] = true;
					}
				}
			}

			if (!person.isEmpty()) { // 태울 수 있는 손님이 있으면
				Point start = person.poll(); // 출발점과 도착점 저장
				Point end = arrive[arr[start.x][start.y]];

				queue.clear(); // 지금부터 손님이 도착할 수 있는지 확인하는 큐
				visit = new boolean[N][N];
				queue.add(new Point(start.x, start.y));
				visit[start.x][start.y] = true;

				int dis = 0; // 이동거리
				boolean check = false;
				while (!queue.isEmpty()) { // 손님이 도착이 가능한지
					int size2 = queue.size();

					for (int s = 0; s < size2; s++) {
						Point now = queue.poll();
						if (now.x == end.x && now.y == end.y) {
							check = true;
							break;
						}
						for (int i = 0; i < 4; i++) {
							int nextx = now.x + di[i];
							int nexty = now.y + dj[i];
							if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < N && !visit[nextx][nexty]
									&& arr[nextx][nexty] != 1) {
								queue.add(new Point(nextx, nexty));
								visit[nextx][nexty] = true;
							}
						}
					}
					if (check) {
						break;
					}
					dis++;
				}

				if (check && oil - dis >= 0) { // 도착할 수 있고, 연료가 충분하면
					oil = oil + dis;
					arr[start.x][start.y] = 0;
					remain--;
					person.clear();
					queue.clear();
					queue.add(new Point(end.x, end.y));
					visit = new boolean[N][N];
					visit[end.x][end.y] = true;
				}
				else {
					return;
				}
			}
			else { // 태울 수 있는 손님이 없으면 다시탐색하러
				oil--;
			}
			if (remain == 0) {
				answer = oil;
				return;
			}
		}
	}
}