import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int dgr[] = new int[N + 1];
		List<Integer> list[] = new ArrayList[N + 1];
		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			dgr[end]++;
		}
		for (int i = 1; i <= N; i++) {
			if (dgr[i] == 0) {
				queue.add(i);
			}
		}
		while (true) {
			if (queue.isEmpty()) {
				break;
			}
			int now = queue.poll();
			sb.append(now + " ");
			for (int i = 0; i < list[now].size(); i++) {
				dgr[list[now].get(i)]--;
				if (dgr[list[now].get(i)] == 0) {
					queue.add(list[now].get(i));
				}
			}
		}

		System.out.println(sb);

		br.close();
	}
}