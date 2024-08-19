import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		int num = 1;
		int idx = 0;

		Num arr[] = new Num[1000000];

		out:
		while (true) {
			String tmp = Integer.toString(num);

			for (int i = 0; i < tmp.length(); i++) {
				if (idx >= 1000000) {
					break out;
				}
				arr[idx++] = new Num(tmp.charAt(i), num);
			}
			num++;
		}

		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			while (true) {
				if (s.charAt(i) == arr[index].num) {
					break;
				}
				index++;
			}
			index++;
		}
		System.out.println(arr[index - 1].idx);
	}

	static class Num {
		char num;
		int idx;

		public Num(char num, int idx) {
			this.num = num;
			this.idx = idx;
		}
	}
}