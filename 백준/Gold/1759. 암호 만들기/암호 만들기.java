import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringBuilder alpha = new StringBuilder();
	static int M;
	static int N;
	static char arr[];
	static char result[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new char[N];
		result = new char[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = st.nextToken();
			arr[i] = s.charAt(0);
		}
		Arrays.sort(arr);
		comb(0, 0);
		System.out.println(sb);

		br.close();
	}

	static void comb(int idx, int start) {
		if (idx == M) {
			int c = 0;
			int v = 0;

			for (int i = 0; i < idx; i++) {
				alpha.append(result[i]);

				if (result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u') {
					v++;
				}
				else {
					c++;
				}
			}
			if (v >= 1 && c >= 2) {
				sb.append(alpha + "\n");
			}
			alpha.setLength(0);

			return;
		}
		for (int i = start; i < N; i++) {
			result[idx] = arr[i];
			comb(idx + 1, i + 1);
		}
	}
}