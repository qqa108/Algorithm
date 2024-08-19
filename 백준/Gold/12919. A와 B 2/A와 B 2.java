import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String start;
	static String e;
	static StringBuilder end = new StringBuilder();
	static int sa, sb, ea, eb;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = st.nextToken();
		st = new StringTokenizer(br.readLine());
		e = st.nextToken();
		end.append(e);

		for (int i = 0; i < end.length(); i++) {
			if (end.charAt(i) == 'A') {
				ea++;
			}
			else {
				eb++;
			}
		}
		for (int i = 0; i < start.length(); i++) {
			if (start.charAt(i) == 'A') {
				sa++;
			}
			else {
				sb++;
			}
		}
		dfs(ea, eb);
		System.out.println(answer);
	}

	static void dfs(int a, int b) {
		if (start.equals(end.toString())) {
			answer = 1;
			return;
		}
		if (answer == 0 && a - 1 >= sa && end.charAt(end.length() - 1) == 'A') {
			end.delete(end.length() - 1, end.length());
			dfs(a - 1, b);
			end.append('A');
		}
		if (answer == 0 && b - 1 >= sb && end.charAt(0) == 'B') {
			end.delete(0, 1);
			end.reverse();
			dfs(a, b - 1);
			end.append('B');
			end.reverse();
		}
	}
}