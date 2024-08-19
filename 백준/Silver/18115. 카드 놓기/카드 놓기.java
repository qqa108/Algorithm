import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> queue = new ArrayDeque<>();
		int N = Integer.parseInt(st.nextToken());
		int arr[] = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int index = 1;
		for (int i = N; i > 0; i--) {
			if (arr[i] == 1) {
				queue.addFirst(index);
			} else if (arr[i] == 2) {
				int tmp = queue.removeFirst();
				queue.addFirst(index);
				queue.addFirst(tmp);
			} else {
				queue.addLast(index);
			}
			index++;
		}
		for (int i = 1; i <= N; i++) {
			sb.append(queue.removeFirst() + " ");
		}
		System.out.println(sb);
	}
}