import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int V;
	static int E;
	static Node arr[];
	static int root;
	static int count;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			arr = new Node[V + 1];
			for (int i = 0; i <= V; i++) {
				arr[i] = new Node();
			}
			arr[1].dgree = 1;
			arr[1].mid = 1;

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < E; i++) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				arr[c].mid = c;
				arr[c].parent = p;
				if (arr[p].count == 0) {
					arr[p].left = c;
					arr[p].count++;
				}
				else {
					arr[p].right = c;
				}

			}
			
			dfs2(1, 1);

			int tmp1 = num1;
			int tmp2 = num2;
			root = 0;
			count = 0;

			while (true) {
				int dif = arr[tmp1].dgree - arr[tmp2].dgree;

				if (dif == 0) {
					if (arr[tmp1].mid == arr[tmp2].mid) {
						root = tmp1;
						break;
					}
					else {
						tmp1 = arr[tmp1].parent;
						tmp2 = arr[tmp2].parent;
					}
				}
				else if (dif > 0) {
					tmp1 = arr[tmp1].parent;
				}
				else {
					tmp2 = arr[tmp2].parent;
				}
			}
			dfs(root);

			sb.append("#" + test_case + " " + root + " " + count + "\n");
		}
		System.out.println(sb);
	}

	static class Node {
		int parent;
		int mid;
		int left;
		int right;
		int dgree;
		int count;

	}

	static void dfs(int root) {
		count++;
		if (arr[root].left != 0) {
			dfs(arr[root].left);
		}
		if (arr[root].right != 0) {
			dfs(arr[root].right);
		}

	}

	static void dfs2(int root, int dgree) {
		arr[root].dgree = dgree;
		if (arr[root].left != 0) {
			dfs2(arr[root].left, dgree + 1);
		}
		if (arr[root].right != 0) {
			dfs2(arr[root].right, dgree + 1);
		}

	}
}