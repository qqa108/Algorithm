import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int V;
	static int E;
	static Edge edge[];
	static int parents[];

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edge = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			edge[i] = new Edge(from, to, weight);
		}
		Arrays.sort(edge);
		make();

		int weight = 0;

		for (int i = 0; i < E; i++) {
			if (!union(edge[i].from, edge[i].to)) {
				continue;
			}
			weight = weight + edge[i].weight;
		}
		System.out.println(weight);
	}

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static void make() {
		parents = new int[V];
		parents[0] = 0;
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	static int find(int num) {
		if (parents[num] == num) {
			return num;
		} else {
			parents[num] = find(parents[num]);
			return parents[num];
		}
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) {
			return false;
		} else {
			parents[bRoot] = aRoot;
			return true;
		}
	}

}