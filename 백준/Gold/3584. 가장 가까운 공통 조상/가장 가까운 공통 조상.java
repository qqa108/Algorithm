import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int arr[] = new int[N + 1];

            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                arr[to] = from;
            }

            List<Integer> list = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            int next = L;
            while (true) {
                list.add(next);
                if (arr[next] == 0) {
                    break;
                }
                next = arr[next];
            }
            for (int j = 0; j < list.size(); j++) {
                map.put(list.get(j), list.size() - j);
            }
            next = R;
            int idx = 0;
            int max = 0;
            while (true) {
                if (map.containsKey(next) && idx < map.get(next)) {
                    idx = map.get(next);
                    max = next;
                }
                if (arr[next] == 0) {
                    break;
                }
                next = arr[next];
            }
            sb.append(max).append('\n');
        }
        System.out.print(sb);
    }
}