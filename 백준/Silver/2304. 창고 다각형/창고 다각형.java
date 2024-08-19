import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int build[] = new int[1001];
		int max = 0;
		int index = 0;
		int maxindex = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());

			build[L] = H;

			if (max <= H) {
				max = H;
				maxindex = L;
			}
			if (index < L) {
				index = L;
			}
		}

		long sum = 0;
		int pre = 0;
		for (int i = 0; i <= maxindex; i++) {
			if (build[i] != 0 && pre < build[i]) {
				sum = sum + build[i];
				pre = build[i];
			}
			else {
				sum = sum + pre;
			}
		}

		pre = 0;
		for (int i = index; i > maxindex; i--) {
			if (build[i] != 0 && pre < build[i]) {
				sum = sum + build[i];
				pre = build[i];
			}
			else {
				sum = sum + pre;
			}
		}
		System.out.println(sum);
		br.close();
	}
}