import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Meeting meeting[];
	static boolean visit[];
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		meeting = new Meeting[N + 1];
		visit = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			meeting[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		subset(1);
		System.out.println(max);
	}

	static class Meeting {
		int day;
		int money;

		public Meeting(int day, int money) {
			this.day = day;
			this.money = money;
		}

	}

	static void subset(int idx) {
		if (idx == N + 1) {
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				if (visit[i]) {
					int daycount = i + meeting[i].day - 1;
					if (daycount > N) {
						break;
					}
					sum = sum + meeting[i].money;
					i = daycount;
				}
			}
			max = Math.max(max, sum);
			return;
		}
		visit[idx] = true;
		subset(idx + 1);
		visit[idx] = false;
		subset(idx + 1);
	}
}