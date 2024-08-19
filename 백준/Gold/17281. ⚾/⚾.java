import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int result[] = new int[9];
	static int battingbox[][];
	static boolean visit[] = new boolean[9];
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		battingbox = new int[N][9];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				battingbox[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		perm(0);
		System.out.println(max);
	}

	static void perm(int idx) {
		if (idx == 9) {
			game();
			return;
		}
		if (idx == 3) {
			result[idx] = 0;
			perm(idx + 1);
		} else {
			for (int i = 1; i < 9; i++) {
				if (!visit[i]) {
					visit[i] = true;
					result[idx] = i;
					perm(idx + 1);
					visit[i] = false;
				}
			}
		}
	}

	static void game() {
		int inning = 0;
		int out = 0;
		int base[] = { 0, 0, 0, 0 };
		int score = 0;
		int order = 0;
		while (true) {
			if (inning == N) {
				max = Math.max(max, score);
				break;
			}

			int hit = battingbox[inning][result[order]];
			if (hit == 0) {
				out++;
			} else {
				base[0] = 0;
				score = score + basestat(hit, base);
			}
			order = (order + 1) % 9;

			if (out == 3) {
				out = 0;
				inning++;

				for (int i = 1; i < 4; i++) {
					base[i] = 0;
				}
			}
		}
	}

	static int basestat(int hit, int base[]) {
		int score = 0;
		for (int i = 3; i >= 0; i--) {
			if (base[i] == 0 && i != 0) {
				continue;
			}
			if (base[i] + hit > 3) {
				base[i] = 0;
				score++;
			} else {
				base[base[i] + hit] = base[i] + hit;
				base[i] = 0;
			}
		}
		return score;
	}
}