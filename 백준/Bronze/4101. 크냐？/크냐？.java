import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		while (true) {
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if (A == 0 && B == 0) {
				System.out.println(sb);
				break;
			}
			if (A > B) {
				sb.append("Yes").append('\n');
			}
			else {
				sb.append("No").append('\n');
			}
			st = new StringTokenizer(br.readLine());
		}
	}
}