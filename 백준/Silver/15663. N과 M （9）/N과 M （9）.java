import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int arr[];
	static int result[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	static StringBuilder tmp = new StringBuilder();
	static Map<String, Integer> hash = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		visit = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		perm(0);
		System.out.println(sb);
	}

	static void perm(int idx) {
		if (idx == M) {
			tmp.setLength(0);
			for (int i = 0; i < M; i++) {
				tmp.append(result[i] + " ");
			}
			if (!hash.containsKey(tmp.toString())) {
				hash.put(tmp.toString(), 1);
				sb.append(tmp + "\n");
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				result[idx] = arr[i];
				perm(idx + 1);
				visit[i] = false;
			}
		}
	}
}