import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, E;
	static List<Point> list[];
	static int dist[];
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		dist = new int[N + 1];
		visit = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[from].add(new Point(to, w));
			list[to].add(new Point(from, w));
		}
		dij();
		System.out.println(dist[N]);
	}

	static class Point implements Comparable<Point> {
		int v, w;

		public Point(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			return this.w - o.w;
		}

	}

	static void dij() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(1, 0));
		dist[1] = 0;

		while (!pq.isEmpty()) {
			Point now = pq.poll();

			if (!visit[now.v]) {
				visit[now.v] = true;
			}
			else {
				continue;
			}

			for (int i = 0; i < list[now.v].size(); i++) {
				Point next = list[now.v].get(i);
				if (dist[next.v] > dist[now.v] + next.w) {
					dist[next.v] = dist[now.v] + next.w;
					pq.add(new Point(next.v, dist[next.v]));
				}
			}
		}

	}

}