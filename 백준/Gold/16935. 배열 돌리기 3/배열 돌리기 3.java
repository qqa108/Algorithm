import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int r = 0; r < R; r++) {
			int com = Integer.parseInt(st.nextToken());
			N = arr.length;
			M = arr[0].length;

			if (com == 1) {
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M; j++) {
						int temp = arr[i][j];
						arr[i][j] = arr[N - i - 1][j];
						arr[N - i - 1][j] = temp;
					}
				}
			}
			else if (com == 2) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M / 2; j++) {
						int temp = arr[i][j];
						arr[i][j] = arr[i][M - j - 1];
						arr[i][M - j - 1] = temp;
					}
				}
			}
			else if (com == 3) {
				int tmp[][] = new int[M][N];

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						tmp[j][N - i - 1] = arr[i][j];
					}
				}
				arr = tmp;
			}
			else if (com == 4) {
				int tmp[][] = new int[M][N];

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						tmp[M - j - 1][i] = arr[i][j];
					}
				}
				arr = tmp;
			}
			else if (com == 5) {
				int tmp[][] = new int[N][M];

				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M / 2; j++) {
						tmp[i][j + M / 2] = arr[i][j];
					}
				}
				for (int i = 0; i < N / 2; i++) {
					for (int j = M / 2; j < M; j++) {
						tmp[i + N / 2][j] = arr[i][j];
					}
				}
				for (int i = N / 2; i < N; i++) {
					for (int j = M / 2; j < M; j++) {
						tmp[i][j - M / 2] = arr[i][j];
					}
				}
				for (int i = N / 2; i < N; i++) {
					for (int j = 0; j < M / 2; j++) {
						tmp[i - N / 2][j] = arr[i][j];
					}
				}
				arr = tmp;
			}
			else if (com == 6) {
				int tmp[][] = new int[N][M];

				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M / 2; j++) {
						tmp[i + N / 2][j] = arr[i][j];
					}
				}
				for (int i = 0; i < N / 2; i++) {
					for (int j = M / 2; j < M; j++) {
						tmp[i][j - M / 2] = arr[i][j];
					}
				}
				for (int i = N / 2; i < N; i++) {
					for (int j = M / 2; j < M; j++) {
						tmp[i - N / 2][j] = arr[i][j];
					}
				}
				for (int i = N / 2; i < N; i++) {
					for (int j = 0; j < M / 2; j++) {
						tmp[i][j + M / 2] = arr[i][j];
					}
				}
				arr = tmp;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);

		br.close();
	}
}