import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int first = N;
		int second = 0;
		List<Integer> answer = new ArrayList<>();
		int max = 0;
		int index = 0;

		for (int i = 1; i <= N; i++) {
			List<Integer> list = new ArrayList<>();
			list.add(N);
			list.add(i);
			first = N;
			second = i;
			int count = 0;

			while (true) {
				if (first - second < 0) {
					break;
				}
				int tmp = first - second;
				first = second;
				second = tmp;
				list.add(second);
				count++;
			}
			if (count > max) {
				max = count;
				index = i;
				answer = list;
			}
		}
		System.out.println(max + 2);
		for (int i = 0; i < max + 2; i++) {
			System.out.print(answer.get(i) + " ");
		}

		sc.close();
	}
}