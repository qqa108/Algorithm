import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Room room[];
	static boolean visit[];
	static int answer;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 0) {
				break;
			}
			room = new Room[N + 1];
			visit = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				room[i] = new Room();
				st = new StringTokenizer(br.readLine());
				room[i].num = i;
				String C = st.nextToken();
				room[i].type = C;
				int m = Integer.parseInt(st.nextToken());
				room[i].money = m;
				while (true) {
					int a = Integer.parseInt(st.nextToken());
					if (a == 0) {
						break;
					}
					room[i].next.add(a);
				}
			}
			answer = 0;
			visit[1] = true;
			dfs(1, 0);

			if (answer == 1) {
				sb.append("Yes\n");
			}
			else {
				sb.append("No\n");
			}
		}
		System.out.println(sb);
	}

	static class Room {
		int num, money;
		List<Integer> next = new ArrayList<>();
		String type;
	}

	static void dfs(int index, int money) {
		int nowmoney = money;
		if (room[index].type.equals("L")) {
			nowmoney = Math.max(money, room[index].money);
		}
		else if (room[index].type.equals("T")) {
			nowmoney = money - room[index].money;
		}

		if (nowmoney < 0) {
			return;
		}
		if (index == N) {
			answer = 1;
			return;
		}
		for (int i = 0; i < room[index].next.size(); i++) {
			int next = room[index].next.get(i);
			if (answer == 0 && !visit[next]) {
				visit[next] = true;
				dfs(next, nowmoney);
				visit[next]=false;
			}
		}
	}
}