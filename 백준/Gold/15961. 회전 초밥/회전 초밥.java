import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> hash = new HashMap<>();
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            hash.put(arr[i], 0);
        }

        int count = 0;
        int max = 0;
        for (int i = 0; i < K; i++) {
            if (hash.get(arr[i]) == 0) {
                count++;
            }
            hash.put(arr[i], hash.get(arr[i]) + 1);
        }

        for (int i = 0; i < N; i++) {
            if (hash.containsKey(C) && hash.get(C) != 0) {
                max = Math.max(max, count);
            }
            else {
                max = Math.max(max, count + 1);
            }

            if (hash.get(arr[i]) == 1) {
                count--;
            }
            hash.put(arr[i], hash.get(arr[i]) - 1);

            int next = arr[(i + K) % N];
            if (hash.get(next) == 0) {
                count++;
            }
            hash.put(next, hash.get(next) + 1);
        }
        System.out.println(max);
    }
}