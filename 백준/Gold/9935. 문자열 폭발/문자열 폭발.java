import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		st = new StringTokenizer(br.readLine());
		String bomb = st.nextToken();

		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);
			sb.append(now);
			int start = sb.length() - bomb.length();
			int end = sb.length();
			if (start < 0) {
				continue;
			}

			String tmp = sb.substring(start, end);
			if (tmp.equals(bomb)) {
				sb.delete(start, end);
			}
		}
		if (sb.length() == 0) {
			sb.append("FRULA");
		}
		System.out.println(sb);
	}
}