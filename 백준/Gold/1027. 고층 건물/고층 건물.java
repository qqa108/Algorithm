import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		double arr[] = new double[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			double max = Integer.MAX_VALUE;
			double lear = 0;
			int count = 0;

			for (int j = i - 1; j >= 0; j--) {
				lear = (arr[i] - arr[j]) / (i - j);
				if (lear < max) {
					max = lear;
					count++;
				}
			}
			max = -Integer.MAX_VALUE;
			for (int j = i + 1; j < N; j++) {
				lear = (arr[i] - arr[j]) / (i - j);
				if (lear > max) {
					max = lear;
					count++;
				}
			}
			answer = Math.max(answer, count);
		}
		System.out.println(answer);
	}
}