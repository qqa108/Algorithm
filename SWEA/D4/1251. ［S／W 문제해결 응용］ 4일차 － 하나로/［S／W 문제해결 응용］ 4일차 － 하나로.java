import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static double E;
	static Edge edge[];
	static int parents[];

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			edge = new Edge[N * (N - 1)];
			long x[] = new long[N];
			long y[] = new long[N];
			Point p[] = new Point[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Long.parseLong(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Long.parseLong(st.nextToken());
				p[i] = new Point(i, x[i], y[i]);
			}

			st = new StringTokenizer(br.readLine());
			E = Double.parseDouble(st.nextToken());

			int index = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j) {
						long dis = (p[i].x - p[j].x) * (p[i].x - p[j].x) + (p[i].y - p[j].y) * (p[i].y - p[j].y);
						edge[index] = new Edge(i, j, dis);
						index++;
					}
				}
			}

			Arrays.sort(edge);
			make();

			long answer = 0;

			for (int i = 0; i < N * (N - 1); i++) {
				if (!union(edge[i].from, edge[i].to)) {
					continue;
				}
				answer = answer + edge[i].weight;
			}
			answer = Math.round(answer * E);
			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	static class Point {
		int index;
		long x;
		long y;

		public Point(int index, long x, long y) {
			this.index = index;
			this.x = x;
			this.y = y;
		}
	}

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		long weight;

		public Edge(int from, int to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}

	static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	static int find(int num) {
		if (parents[num] == num) {
			return num;
		}
		else {
			parents[num] = find(parents[num]);
			return parents[num];
		}
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}

}