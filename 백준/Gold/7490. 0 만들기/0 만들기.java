import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			dfs(2, "1");
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static void dfs(int idx, String val) {
		if (idx == N + 1) {
			int left = 0;
			int op = 0;
			int right = 0;

			for (int i = 0; i < val.length(); i++) {
				if (val.charAt(i) == '+') {
					if (right != 0) {
						left = cal(left, op, right);
						right = 0;
					}
					op = 1;
				}
				else if (val.charAt(i) == '-') {
					if (right != 0) {
						left = cal(left, op, right);
						right = 0;
					}
					op = -1;
				}
				else if (val.charAt(i) == ' ') {
					continue;
				}
				else {
					if (op == 0) {
						left = (left * 10) + ((int) val.charAt(i) - '0');
					}
					else {
						right = (right * 10) + ((int) val.charAt(i) - '0');
					}
				}
			}
			left = cal(left, op, right);

			if (left == 0) {
				sb.append(val).append('\n');
			}
			return;
		}
		dfs(idx + 1, val + " " + idx);
		dfs(idx + 1, val + "+" + idx);
		dfs(idx + 1, val + "-" + idx);
	}

	static int cal(int left, int op, int right) {
		if (op == 1) {
			left = left + right;
		}
		else {
			left = left - right;
		}
		return left;
	}
}