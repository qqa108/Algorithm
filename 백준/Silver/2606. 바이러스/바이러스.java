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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> list[] = new ArrayList[N]; // 인접리스트 생성
		boolean visit[] = new boolean[N];
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) { // 정점 잇기
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			list[from].add(to);
			list[to].add(from);
		}

		int count = 0;
		queue.add(0); // 큐에 1번 정점 넣고
		visit[0] = true;
		while (!queue.isEmpty()) { // bfs
			int now = queue.poll();
			for (int i = 0; i < list[now].size(); i++) {
				if (!visit[list[now].get(i)]) { // 한 정점과 연결되어있는 정점들중에 방문하지 않았다면
					queue.add(list[now].get(i));
					visit[list[now].get(i)] = true;
					count++;
				}
			}
		}
		System.out.println(count);
	}
}