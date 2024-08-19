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
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		int arr[] = new int[N];
		Deque<Integer> queue = new ArrayDeque<>();

		int index = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = s.charAt(i) - '0';

			while (true) {
				if (index == K || queue.isEmpty() || queue.peek() >= arr[i]) {
					queue.push(arr[i]);
					break;
				}
				else {
					queue.pop();
					index++;
				}
			}
		}
		for (int i = index; i < K; i++) {
			queue.pop();
		}
		while(true) {
			if(queue.isEmpty()) {
				break;
			}
			sb.append(queue.removeLast());
		}
		System.out.println(sb);
	}
}