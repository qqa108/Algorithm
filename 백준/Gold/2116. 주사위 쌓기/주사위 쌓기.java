import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int dice[][] = new int[N][6];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dice[i][0] = Integer.parseInt(st.nextToken());
			dice[i][2] = Integer.parseInt(st.nextToken());
			dice[i][4] = Integer.parseInt(st.nextToken());
			dice[i][3] = Integer.parseInt(st.nextToken());
			dice[i][5] = Integer.parseInt(st.nextToken());
			dice[i][1] = Integer.parseInt(st.nextToken());
		}

		int up = 0;
		int down = 0;
		int max = 0;
		int sum = 0;
		int answer = 0;

		for (int i = 0; i < 6; i++) {
			sum = 0;
			max = 0;
			down = dice[0][i];
			if (i % 2 == 0) {
				up = dice[0][i + 1];
			}
			else {
				up = dice[0][i - 1];
			}

			for (int j = 0; j < 6; j++) {
				if (dice[0][j] != up && dice[0][j] != down) {
					max = Math.max(max, dice[0][j]);
				}
			}
			sum = sum + max;

			for (int j = 1; j < N; j++) {
				max = 0;
				for (int k = 0; k < 6; k++) {
					if (dice[j][k] == up) {
						down = dice[j][k];
						if (k % 2 == 0) {
							up = dice[j][k + 1];
						}
						else {
							up = dice[j][k - 1];
						}
						break;
					}
				}
				for (int k = 0; k < 6; k++) {
					if (dice[j][k] != up && dice[j][k] != down) {
						max = Math.max(max, dice[j][k]);
					}
				}
				sum = sum + max;
			}
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}
}