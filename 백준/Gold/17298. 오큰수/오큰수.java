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
		int arr[] = new int[N];
		int answer[] = new int[N];
		Stack<Point> stack = new Stack<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			while (true) {
				if (!stack.isEmpty() && stack.peek().val < arr[i]) {
					Point now = stack.pop();
					answer[now.idx] = arr[i];
				} else {
					stack.push(new Point(i, arr[i]));
					break;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if (answer[i] == 0) {
				answer[i] = -1;
			}
			sb.append(answer[i]).append(' ');
		}
		System.out.println(sb);
	}

	static class Point {
		int idx, val;

		public Point(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
}