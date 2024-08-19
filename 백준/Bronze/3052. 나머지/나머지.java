import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashMap<Integer, Integer> hash = new HashMap<>();
		int count = 0;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) % 42;

			if (!hash.containsKey(num)) {
				hash.put(num, 1);
				count++;
			}
		}

		System.out.println(count);
		br.close();
	}
}