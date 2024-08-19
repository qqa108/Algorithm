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

		comb(0, 0);
		System.out.println(sb);
	}

	static void comb(int idx, int start) {
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
		for (int i = start; i < N; i++) {
			result[idx] = arr[i];
			comb(idx + 1, i);
		}
	}
}