import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();

			Deque<Integer> deck = new ArrayDeque<>();

			int sum = 0;
			for (int i = 0; i < tmp.length(); i++) {
				char c = tmp.charAt(i);
				if (c == '[') {
					continue;
				}
				else if (c == ',' || c == ']') {
					if (sum != 0) {
						deck.add(sum);
					}
					sum = 0;
				}
				else {
					sum = (sum * 10) + (int) (c - '0');
				}
			}

			int dre = 1;
			boolean check = true;
			for (int i = 0; i < command.length(); i++) {
				char c = command.charAt(i);
				if (c == 'R') {
					dre = dre * (-1);
				}
				else {
					if (deck.size() == 0) {
						check = false;
						break;
					}
					if (dre == 1) {
						deck.pollFirst();
					}
					else {
						deck.pollLast();
					}
				}
			}
			if (!check) {
				sb.append("error");
			}
			else {
				sb.append('[');
				if (dre == 1) {
					while (!deck.isEmpty()) {
						sb.append(deck.pollFirst());
						if (!deck.isEmpty()) {
							sb.append(',');
						}
					}
				}
				else {
					while (!deck.isEmpty()) {
						sb.append(deck.pollLast());
						if (!deck.isEmpty()) {
							sb.append(',');
						}
					}
				}
				sb.append(']');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}