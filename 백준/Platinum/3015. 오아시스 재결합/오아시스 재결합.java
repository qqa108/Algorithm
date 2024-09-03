import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Point> stack = new Stack<>();
        long count = 0;
        for (int i = 0; i < N; i++) {
            Point next = new Point(arr[i], 1);

            if (stack.isEmpty()) {
                stack.push(next);
            }
            else if (stack.peek().h > arr[i]) {
                stack.push(next);
                count++;
            }
            else {
                while (true) {
                    if (stack.isEmpty()) {
                        stack.push(next);
                        break;
                    }
                    if (stack.peek().h > arr[i]) {
                        stack.push(next);
                        count = count + 1;
                        break;
                    }
                    if (stack.peek().h == arr[i]) {
                        next.cnt = next.cnt + stack.peek().cnt;
                    }
                    count = count + stack.pop().cnt;
                }
            }
        }
        System.out.println(count);
    }

    static class Point {
        int h;
        long cnt;

        Point(int h, long cnt) {
            this.h = h;
            this.cnt = cnt;
        }
    }
}