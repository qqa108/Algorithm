import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Integer.parseInt(st.nextToken());
			Queue<Integer> queue = new ArrayDeque<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
			}

			int index = 1;
			while (true) {
				int num = queue.remove();
				num = num - index;
				index = (index % 5) + 1;

				if (num <= 0) {
					queue.add(0);
					break;
				}
				else {
					queue.add(num);
				}
			}

			sb.append("#" + test_case + " ");
			for (int i = 0; i < 8; i++) {
				sb.append(queue.remove() + " ");
			}
			sb.append("\n");

		}
		System.out.println(sb);
		br.close();
	}
}