import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static final int D = 100_000_000;
	static Queue<Integer> queue = new ArrayDeque<>();
	static HashMap<Integer, Integer> hash = new HashMap<>();
	static int count = 0;
	static long answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			queue.add(tmp);
			hash.put(tmp, 1);
		}
		bfs();
		System.out.println(answer);
	}

	static void bfs() {
		int dis = 1;
		while (true) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				if (count == K) {
					return;
				}
				int now = queue.poll();
				if (hash.get(now - 1) == null) {
					hash.put(now - 1, 1);
					queue.add(now - 1);
					count++;
					answer = answer + dis;
				}
				if (count == K) {
					return;
				}
				if (hash.get(now + 1) == null) {
					hash.put(now + 1, 1);
					queue.add(now + 1);
					count++;
					answer = answer + dis;
				}
			}
			dis++;
		}
	}
}