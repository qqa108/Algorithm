import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean visit[];
	static int N;
	static Food food[];
	static long sum;
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		food = new Food[N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long s = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			food[i] = new Food(s, b);
		}
		subset(0);
		System.out.println(min);

		br.close();
	}

	static class Food {
		long sour;
		long bitter;

		public Food(long sour, long bitter) {
			this.sour = sour;
			this.bitter = bitter;
		}
	}

	static void subset(int idx) {
		long s = 1;
		long b = 0;
		if (idx == N) {
			for (int i = 0; i < N; i++) {
				if (visit[i]) {
					s = s * food[i].sour;
					b = b + food[i].bitter;
				}
			}
			if (s != 1 && b != 0) {
				sum = Math.abs(s - b);
			}
			if (min > sum) {
				min = sum;
			}
			return;
		}
		visit[idx] = true;
		subset(idx + 1);
		visit[idx] = false;
		subset(idx + 1);

	}
}