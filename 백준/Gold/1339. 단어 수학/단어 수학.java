import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static HashMap<Character, Integer> hash = new HashMap<>();
	static String arr[];
	static int num[];
	static boolean visit[];
	static int index = 0;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new String[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken();
			for (int j = 0; j < arr[i].length(); j++) {
				char key = arr[i].charAt(j);
				if (!hash.containsKey(key)) {
					hash.put(key, index++);
				}
			}
		}
		num = new int[index];
		visit = new boolean[10];
		perm(0);
		System.out.println(max);
	}

	static void perm(int idx) {
		if (idx == index) {
			max = Math.max(max, cal());
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (!visit[i]) {
				visit[i] = true;
				num[idx] = i;
				perm(idx + 1);
				visit[i] = false;
			}
		}
	}

	static int cal() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int tmp = 0;
			for (int j = 0; j < arr[i].length(); j++) {
				tmp = (10 * tmp) + num[hash.get(arr[i].charAt(j))];
			}
			sum = sum + tmp;
		}
		return sum;
	}
}