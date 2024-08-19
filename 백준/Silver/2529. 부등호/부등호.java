import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char arr[];
	static int result[];
	static boolean visit[];
	static boolean finish;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new char[N];
		result = new int[N + 1];
		visit = new boolean[10];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = st.nextToken();
			arr[i] = s.charAt(0);
		}

		finish = false;
		dfs2(0);

		finish = false;
		visit = new boolean[10];
		dfs1(0);
		System.out.println(sb);
	}

	static void dfs1(int idx) {
		if (idx == N + 1) {
			finish = true;
			for (int i = 0; i < N + 1; i++) {
				sb.append(result[i]);
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (finish) {
				return;
			}
			if (!visit[i] && (idx == 0 || (arr[idx - 1] == '<' && result[idx - 1] < i)
					|| (arr[idx - 1] == '>' && result[idx - 1] > i))) {
				visit[i] = true;
				result[idx] = i;
				dfs1(idx + 1);
				visit[i] = false;
			}
		}
	}

	static void dfs2(int idx) {
		if (idx == N + 1) {
			finish = true;
			for (int i = 0; i < N + 1; i++) {
				sb.append(result[i]);
			}
			sb.append('\n');
			return;
		}
		for (int i = 9; i >= 0; i--) {
			if (finish) {
				return;
			}
			if (!visit[i] && (idx == 0 || (arr[idx - 1] == '<' && result[idx - 1] < i)
					|| (arr[idx - 1] == '>' && result[idx - 1] > i))) {
				visit[i] = true;
				result[idx] = i;
				dfs2(idx + 1);
				visit[i] = false;
			}
		}
	}
}