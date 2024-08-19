import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int V;
	static Edge[] edgeList;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		double arr[][] = new double[V][2];

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Double.parseDouble(st.nextToken());
			arr[i][1] = Double.parseDouble(st.nextToken());
		}

		edgeList = new Edge[(V * (V - 1)) / 2];
		int index = 0;
		for (int i = 0; i < V; i++) {
			for (int j = i + 1; j < V; j++) {

				double dis = Math.sqrt(Math.pow((arr[i][0] - arr[j][0]), 2) + Math.pow((arr[i][1] - arr[j][1]), 2));
				edgeList[index++] = new Edge(i, j, dis);

			}
		}
		Arrays.sort(edgeList);
		make();

		double weight = 0;
		int cnt = 0;
		for (Edge edge : edgeList) {
			if (!union(edge.from, edge.to)) {
				continue;
			}
			weight = weight + edge.weight;
			if (++cnt == V - 1) {
				break;
			}
		}
		System.out.printf("%.2f", weight);
	}

	static class Edge implements Comparable<Edge> {
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return (int) (this.weight - o.weight);
		}
	}

	public static void make() {
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	public static int find(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}
}