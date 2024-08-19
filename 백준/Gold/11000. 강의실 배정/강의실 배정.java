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
		Room room[] = new Room[N];
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			room[i] = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(room);
		queue.add(room[0].end);
		int count = 1;

		for (int i = 1; i < N; i++) {
			if (queue.peek() <= room[i].start) {
				queue.poll();
				count--;
			}
			queue.add(room[i].end);
			count++;
		}
		System.out.println(count);
	}

	static class Room implements Comparable<Room> {
		int start;
		int end;

		public Room(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Room o) {
			if (this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}
}