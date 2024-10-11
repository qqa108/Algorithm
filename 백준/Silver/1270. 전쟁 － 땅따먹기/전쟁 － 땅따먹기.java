import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            HashMap<Long, Integer> hash = new HashMap<>();

            int max = 0;
            long idx = 0;
            for (int j = 0; j < M; j++) {
                long num = Long.parseLong(st.nextToken());

                if (hash.containsKey(num)) {
                    hash.put(num, hash.get(num) + 1);
                }
                else {
                    hash.put(num, 1);
                }

                if (hash.get(num) > max) {
                    max = hash.get(num);
                    idx = num;
                }
            }

            if (max > M / 2) {
                sb.append(idx).append('\n');
            }
            else {
                sb.append("SYJKGW\n");
            }
        }
        System.out.print(sb);
    }
}