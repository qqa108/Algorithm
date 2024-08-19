import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static String arr[];
	static boolean result[];
	static int count, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new String[N];
		result = new boolean[26];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.substring(4, s.length() - 4);
		}
		answer = 0;
		result[0] = true;
		result[2] = true;
		result[8] = true;
		result[13] = true;
		result[19] = true;
		if (K >= 5) {
			comb(0, 0);
		}
		System.out.println(answer);
	}

	static void comb(int idx, int start) {
		if (idx == K - 5) {
			count = 0;
			for (int i = 0; i < N; i++) {
				boolean check = true;
				for (int j = 0; j < arr[i].length(); j++) {
					if (!result[arr[i].charAt(j) - 'a']) {
						check = false;
						break;
					}
				}
				if (check) {
					count++;
				}
			}
			answer = Math.max(answer, count);

			return;
		}
		for (int i = start; i < 26; i++) {
			if (i == 0 || i == 2 || i == 8 || i == 13 || i == 19) {
				continue;
			}
			result[i] = true;
			comb(idx + 1, i + 1);
			result[i] = false;
		}
	}

}