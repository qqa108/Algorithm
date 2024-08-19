import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> minus = new PriorityQueue<>();
		PriorityQueue<Integer> plus = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if (num == 0) {
				if (plus.isEmpty() && minus.isEmpty()) {
					sb.append(0 + "\n");
				}
				else if (plus.isEmpty()) {
					sb.append(-minus.poll() + "\n");
				}
				else if (minus.isEmpty()) {
					sb.append(plus.poll() + "\n");
				}
				else if (plus.peek() < minus.peek()) {
					sb.append(plus.poll() + "\n");
				}
				else if (plus.peek() >= minus.peek()) {
					sb.append(-minus.poll() + "\n");
				}
			}
			else if (num > 0) {
				plus.add(num);
			}
			else {
				minus.add(Math.abs(num));
			}
		}
		System.out.println(sb);
		br.close();
	}
}