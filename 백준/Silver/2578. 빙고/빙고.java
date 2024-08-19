import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tmp[][] = new int[5][5];
		int answer[] = new int[25];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				tmp[i][j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
		}
		for (int i = 0; i < 25; i++) {
			if (i != 0 && i % 5 == 0) {
				st = new StringTokenizer(br.readLine());
			}
			answer[i] = Integer.parseInt(st.nextToken());
		}

		int bingo[][] = new int[12][6];
		int index = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= 5; j++) {
				bingo[index][j] = tmp[i][j - 1];
			}
			index++;
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= 5; j++) {
				bingo[index][j] = tmp[j - 1][i];
			}
			index++;
		}
		for (int i = 1; i <= 5; i++) {
			bingo[index][i] = tmp[i - 1][i - 1];
		}
		index++;
		for (int i = 1; i <= 5; i++) {
			bingo[index][i] = tmp[i - 1][5 - i];
		}

		int ans = 0;
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 12; j++) {
				int count = 0;
				if (bingo[j][0] == -1) {
					continue;
				}
				for (int k = 1; k <= 5; k++) {
					if (bingo[j][k] == answer[i]) {
						bingo[j][k] = 0;
					}
					if (bingo[j][k] == 0) {
						count++;
					}
				}
				if (count == 5) {
					bingo[j][0] = -1;
				}
			}

			int count = 0;
			for (int j = 0; j < 12; j++) {
				if (bingo[j][0] == -1) {
					count++;
				}
			}
			if (count >= 3) {
				ans = i + 1;
				break;
			}
		}
		System.out.println(ans);

		br.close();
	}
}