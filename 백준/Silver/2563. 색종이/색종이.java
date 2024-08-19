import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int mat[][] = new int[101][101];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int j = w; j < w + 10; j++) {
				for (int k = h; k < h + 10; k++) {
					mat[j][k]++;
				}
			}
		}

		int sum = 0;
		for (int j = 1; j <= 100; j++) {
			for (int k = 1; k <= 100; k++) {
				if (mat[j][k] != 0) {
					sum++;
				}
			}
		}

		System.out.println(sum);

		br.close();
	}
}