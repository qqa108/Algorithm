import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append('\n');
                }
                else {
                    sb.append(pq.poll().x).append('\n');
                }
            }
            else {
                pq.add(new Point(num));
            }
        }
        System.out.println(sb);
    }

    static class Point implements Comparable<Point> {
        int x;

        Point(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(Point o) {
            return o.x - this.x;
        }
    }
}