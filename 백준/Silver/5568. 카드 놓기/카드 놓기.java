import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, K, arr[];
    static int result[];
    static boolean visit[];
    static HashMap<Integer, Integer> map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = new int[K];
        visit = new boolean[N];
        map = new HashMap<>();
        answer = 0;
        perm(0);
        System.out.println(answer);
    }

    static void perm(int idx) {
        if (idx == K) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < K; i++) {
                sb.append(result[i]);
            }
            int sum = Integer.parseInt(sb.toString());
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
                answer++;
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                result[idx] = arr[i];
                visit[i] = true;
                perm(idx + 1);
                visit[i] = false;
            }
        }
    }
}