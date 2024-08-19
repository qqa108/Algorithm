import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> max = new PriorityQueue<>();
		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());

			if (i % 2 == 0) {
				min.add(a);
			}
			else {
				max.add(a);
			}

			if (!max.isEmpty() && min.peek() > max.peek()) {
				int maxtmp = max.poll();
				int mintmp = min.poll();
				min.add(maxtmp);
				max.add(mintmp);
			}
			sb.append(min.peek()).append('\n');

		}
		System.out.println(sb);
	}
}