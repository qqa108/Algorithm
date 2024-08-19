import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int arr[][];
	static boolean visit[][];
	static List<Edge> list = new ArrayList<>();
	static int parent[];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int index = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					arr[i][j] = -1;
				}
			}
		}

		index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] != -1 && !visit[i][j]) {
					visit[i][j] = true;
					arr[i][j] = index;
					dfs(i, j, index);
					index++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			int from = -1;
			int fromindex = -1;
			int to = -1;
			int toindex = -1;

			for (int j = 0; j < M; j++) {
				if (j != 0 && from != -1 && arr[i][j] != -1 && arr[i][j - 1] == -1) {
					toindex = arr[i][j];
					to = j;
					if (from != -1 && to != -1 && to - from - 1 > 1) {
						list.add(new Edge(fromindex, toindex, to - from - 1));
					}
				}
				if (j != M - 1 && arr[i][j] != -1 && arr[i][j + 1] == -1) {
					fromindex = arr[i][j];
					from = j;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			int from = -1;
			int fromindex = -1;
			int to = -1;
			int toindex = -1;

			for (int j = 0; j < N; j++) {
				if (j != 0 && from != -1 && arr[j][i] != -1 && arr[j - 1][i] == -1) {
					toindex = arr[j][i];
					to = j;
					if (from != -1 && to != -1 && to - from - 1 > 1) {
						list.add(new Edge(fromindex, toindex, to - from - 1));
					}
				}
				if (j != N - 1 && arr[j][i] != -1 && arr[j + 1][i] == -1) {
					fromindex = arr[j][i];
					from = j;
				}
			}
		}

		Collections.sort(list);

		make();

		int sum = 0;
		int count = 0;
		int check = 0;

		for (Edge e : list) {
			if (!union(e.from, e.to)) {
				continue;
			}
			count++;

			sum = sum + e.weight;
			if (count == index - 1) {
				check = 1;
				break;
			}
		}

		if (check == 0) {
			sum = -1;
		}
		System.out.println(sum);
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
			return this.weight - o.weight;
		}

	}

	static void make() {
		parent = new int[index];
		for (int i = 0; i < index; i++) {
			parent[i] = i;
		}
	}

	static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) {
			return false;
		}
		parent[bRoot] = aRoot;
		return true;
	}

	static void dfs(int x, int y, int index) {
		for (int i = 0; i < 4; i++) {
			if (x + di[i] >= 0 && x + di[i] < N && y + dj[i] >= 0 && y + dj[i] < M && !visit[x + di[i]][y + dj[i]]
					&& arr[x + di[i]][y + dj[i]] == 1) {
				visit[x + di[i]][y + dj[i]] = true;
				arr[x + di[i]][y + dj[i]] = index;
				dfs(x + di[i], y + dj[i], index);
			}
		}
	}
}