import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		int index = K - 1;

		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		sb.append("<");
		while (true) {
			sb.append(list.remove(index));
			if (list.isEmpty()) {
				break;
			}
			sb.append(", ");
			index = (index + K - 1) % list.size();
		}
		sb.append(">");

		System.out.println(sb);

		sc.close();
	}
}