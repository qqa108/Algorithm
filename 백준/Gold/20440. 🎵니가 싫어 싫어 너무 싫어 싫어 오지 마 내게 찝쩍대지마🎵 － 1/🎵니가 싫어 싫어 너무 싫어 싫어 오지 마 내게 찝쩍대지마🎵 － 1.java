import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Time arr[] = new Time[N];
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);

		queue.add(arr[0].end);
		int maxs = arr[0].start;
		int maxe = arr[0].end;
		int pre = arr[0].end;
		int max = 1;
		int count = 1;
		

		for (int i = 1; i < N; i++) {
			if (queue.peek() <= arr[i].start) {
				queue.poll();
				count--;
			}
			queue.add(arr[i].end);
			count++;

			if (maxe == arr[i].start) {
				maxe = arr[i].end;
				//pre = queue.peek();
			}
			if (count > max) {
				max = count;
				maxs = arr[i].start;
				maxe = queue.peek();
//				if(pre < arr[i].end) {
//					maxe = pre;
//				}
//				else {
//					maxe = arr[i].end;
//				}
//				pre = queue.peek();
			}			
		}

		System.out.println(max + "\n" + maxs + " " + maxe);
	}

	static class Time implements Comparable<Time> {
		int start;
		int end;

		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			if (this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}
}