import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char delta[] = { 'A', 'C', 'G', 'T' };

		st = new StringTokenizer(br.readLine());

		String password = st.nextToken();
		char arr[] = password.toCharArray();

		st = new StringTokenizer(br.readLine());
		int fre[] = new int[4];
		for (int i = 0; i < 4; i++) {
			fre[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = P - 1;
		int count = 0;
		int tmp[] = new int[4];

		while (true) {
			if (right == S) {
				break;
			}

			if (left == 0) {
				for (int i = left; i <= right; i++) {
					for (int j = 0; j < 4; j++) {
						if (arr[i] == delta[j]) {
							tmp[j]++;
							break;
						}
					}
				}
				left++;
				right++;
			}
			else {
				for (int i = 0; i < 4; i++) {
					if (arr[left - 1] == delta[i]) {
						tmp[i]--;
					}
					if (arr[right] == delta[i]) {
						tmp[i]++;
					}
				}
				left++;
				right++;
			}

			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				if (tmp[i] >= fre[i]) {
					cnt++;
				}
			}
			if (cnt == 4) {
				count++;
			}

		}
		System.out.println(count);

		br.close();
	}

}