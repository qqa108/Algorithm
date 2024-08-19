import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int arr[];
	static int result[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();

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
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");

			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			result[idx] = arr[i];
			comb(idx + 1, i);
		}
	}
}