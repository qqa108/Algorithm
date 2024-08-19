import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> hash = new HashMap<>();

		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			if (s.equals("all")) {
				for (int j = 1; j <= 20; j++) {
					hash.put(j, 1);
				}
			}
			else if (s.equals("empty")) {
				hash.clear();
			}
			else {
				int num = Integer.parseInt(st.nextToken());

				if (s.equals("add")) {
					hash.put(num, 1);
				}
				else if (s.equals("remove")) {
					hash.remove(num);
				}
				else if (s.equals("check")) {
					if (hash.containsKey(num)) {
						sb.append(1 + "\n");
					}
					else {
						sb.append(0 + "\n");
					}
				}
				else if (s.equals("toggle")) {
					if (hash.containsKey(num)) {
						hash.remove(num);
					}
					else {
						hash.put(num, 1);
					}
				}
			}
		}
		System.out.println(sb);
	}
}