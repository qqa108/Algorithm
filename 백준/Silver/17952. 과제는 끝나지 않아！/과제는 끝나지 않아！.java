import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Stack<Work> stack = new Stack<>();

		int answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int com = Integer.parseInt(st.nextToken());
			if (com == 1) { // 일이 주어지면 일단 스택에 넣기
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				stack.push(new Work(score, time));
			}

			if (!stack.isEmpty()) { // 할일이 남아있다면
				Work now = stack.pop();
				if (now.time == 1) { // 이번시간에 일을 끝낼 수 있으면 스택에 넣지 않는다
					answer = answer + now.score;
				} else { // 못끝내면 한시간만큼 빼주고 다시 스택으로
					stack.push(new Work(now.score, now.time - 1));
				}
			}
		}
		System.out.println(answer);
	}

	static class Work {
		int score;
		int time;

		public Work(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}
}