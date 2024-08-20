import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static List<Integer> arr[];
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			arr = new ArrayList[101];
			visit = new boolean[101];

			for (int i = 1; i <= 100; i++) {
				arr[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from].add(to);
			}
			visit[start] = true;
			sb.append("#" + tc + " ");
			bfs(start);
			sb.append("\n");
		}
		System.out.println(sb);

		br.close();
	}

	static class Point {
		int num;
		int count;

		public Point(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}

	static void bfs(int idx) {
		Queue<Point> queue = new ArrayDeque<>();
		List<Integer> list = new ArrayList<>();
		queue.add(new Point(idx, 0));
		int max = 0;
		int maxcount = 0;

		while (true) {
			if (queue.isEmpty()) {
				Collections.sort(list);
				max = list.get(list.size() - 1);
				sb.append(max + " ");
				break;
			}
			Point now = queue.poll();

			for (int i = 0; i < arr[now.num].size(); i++) {
				int next = arr[now.num].get(i);
				if (!visit[next]) {
					visit[next] = true;

					queue.add(new Point(next, now.count + 1));
				}
			}
			if (maxcount < now.count) {
				maxcount = now.count;
				list.clear();
				list.add(now.num);
			}
			else if (maxcount == now.count) {
				list.add(now.num);
			}
		}
	}
}