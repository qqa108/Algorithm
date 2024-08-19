import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static String s;
	static int N, K;
	static int result[] = new int[2];
	static boolean visit[][] = new boolean[2][1_000_001];
	static Queue<String> queue = new ArrayDeque<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.next();
		N = s.length();
		K = sc.nextInt();
		queue.add(s);
		bfs();

		int answer = -1;
		for (int i = 1000000; i >= 0; i--) {
			if (visit[K % 2][i]) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}

	static void comb(String s, int cnt, int start, int idx) {
		if (idx == 2) {
			StringBuilder sb = new StringBuilder();
			sb.append(s);
			char tmp = s.charAt(result[0]);
			sb.setCharAt(result[0], s.charAt(result[1]));
			sb.setCharAt(result[1], tmp);

			String next = sb.toString();
			if (!visit[cnt][Integer.parseInt(next)] && next.charAt(0) != '0') {
				visit[cnt][Integer.parseInt(next)] = true;
				queue.add(next);
			}
			return;
		}
		for (int i = start; i < N; i++) {
			result[idx] = i;
			comb(s, cnt, i + 1, idx + 1);
		}
	}

	static void bfs() {
		int count = 0;
		while (!queue.isEmpty()) {
			if (count == K) {
				return;
			}
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				String now = queue.poll();
				comb(now, (count + 1) % 2, 0, 0);
			}
			count++;
		}
	}
}