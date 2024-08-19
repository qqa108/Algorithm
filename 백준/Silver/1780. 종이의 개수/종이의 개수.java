import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, arr[][], answer[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		answer = new int[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		paper(0, 0, N, N);
		System.out.println(answer[0] + "\n" + answer[1] + "\n" + answer[2]);
	}

	static void paper(int tx, int ty, int bx, int by) {
		if (tx == bx) {
			return;
		}

		int num = arr[tx][ty];
		boolean check = false;
		out:
		for (int i = tx; i < bx; i++) {
			for (int j = ty; j < by; j++) {
				if (arr[i][j] != arr[tx][ty]) {
					check = true;
					break out;
				}
			}
		}

		if (check) {
			int mul = (bx - tx) / 3;
			for (int i = tx; i < bx; i = i + mul) {
				for (int j = ty; j < by; j = j + mul) {
					paper(i, j, i + mul, j + mul);
				}
			}
		}
		else {
			answer[num + 1]++;
			return;
		}
	}
}