import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean arr[][] = new boolean[N][M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int h = Integer.parseInt(st.nextToken());
			for (int j = 0; j < h; j++) {
				arr[j][i] = true;
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			boolean start = false;
			int tmp = 0;
			for (int j = 0; j < M; j++) {
				if (arr[i][j]) {
					if (!start) {
						start = true;
						tmp = 0;
						continue;
					}
					count = count + tmp;
					tmp = 0;
				}
				else {
					tmp++;
				}
			}
		}
		System.out.println(count);
	}
}