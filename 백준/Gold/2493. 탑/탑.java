import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		High high[] = new High[N];
		Stack<High> stack = new Stack<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			high[i] = new High(i + 1, Integer.parseInt(st.nextToken()), 0);
		}

		for (int i = N - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				stack.push(high[i]);
			}
			else {
				while (true) {
					if (stack.peek().height < high[i].height) {
						stack.peek().answer = high[i].index;
						stack.pop();
					}
					else {
						break;
					}
					if (stack.isEmpty()) {
						break;
					}
				}
				stack.push(high[i]);
			}
		}

		for (int i = 0; i < N; i++) {
			sb.append(high[i].answer).append(" ");
		}
		System.out.println(sb);

		br.close();
	}

	static class High {
		int index;
		int height;
		int answer;

		public High(int index, int height, int answer) {
			this.index = index;
			this.height = height;
			this.answer = answer;
		}
	}
}