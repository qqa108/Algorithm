import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N;
	static int M;
	static int visit[];
	static int answer = Integer.MAX_VALUE;
	static int count = 0;
	static StringBuilder sb = new StringBuilder();
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new int[100001];
		Arrays.fill(visit, Integer.MAX_VALUE);
		bfs();

		System.out.println(answer);
		System.out.println(sb);

		sc.close();
	}

	static class Num {
		int num;
		int count;
		List<Integer> list = new ArrayList<>();

		public Num(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}

	static void bfs() {
		Queue<Num> queue = new ArrayDeque<>();
		queue.add(new Num(N, 0));
		visit[N] = 0;

		while (!queue.isEmpty()) {

			Num now = queue.poll();
			if (now.num == M) {
				answer = visit[M];

				int index = M;
				int count = answer;
				while (true) {
					stack.push(index);
					if (index == N) {
						break;
					}
					count--;
					if (index % 2 == 0 && visit[index / 2] == count) {
						visit[index / 1] = -1;
						index = index / 2;
					}
					else if (visit[index + 1] == count) {
						visit[index + 1] = -1;
						index++;
					}
					else if (visit[index - 1] == count) {
						visit[index - 1] = -1;
						index--;
					}
				}
				while (!stack.isEmpty()) {
					sb.append(stack.pop()).append(' ');
				}
				return;
			}
			if (now.num * 2 <= 100000 && visit[now.num * 2] >= now.count + 1) {
				queue.add(new Num(now.num * 2, now.count + 1));
				visit[now.num * 2] = now.count + 1;
				now.list.add(now.num * 2);
			}
			if (now.num + 1 <= 100000 && visit[now.num + 1] >= now.count + 1) {
				queue.add(new Num(now.num + 1, now.count + 1));
				visit[now.num + 1] = now.count + 1;
				now.list.add(now.num + 1);
			}
			if (now.num - 1 >= 0 && visit[now.num - 1] >= now.count + 1) {
				queue.add(new Num(now.num - 1, now.count + 1));
				visit[now.num - 1] = now.count + 1;
				now.list.add(now.num - 1);
			}
		}
	}
}