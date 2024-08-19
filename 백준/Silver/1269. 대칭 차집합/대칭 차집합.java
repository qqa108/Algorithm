import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> hash = new HashMap<>();

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {

			int num = Integer.parseInt(st.nextToken());

			if (hash.containsKey(num)) {
				hash.put(num, 2);
			}
			else {
				hash.put(num, 1);
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (hash.containsKey(num)) {
				hash.put(num, 2);
			}
			else {
				hash.put(num, 1);
			}
		}

		int count = 0;
		for (int val : hash.values()) {
			if (val == 1) {
				count++;
			}
		}
		System.out.println(count);

	}
}