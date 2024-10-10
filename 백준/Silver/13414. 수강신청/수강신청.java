import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hash = new HashMap<>();
        int idx = 0;
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            hash.put(num, idx++);
        }
        String arr[] = new String[L];
        for(String num : hash.keySet()) {
            arr[hash.get(num)] = num;
        }

        StringBuilder sb = new StringBuilder();

        int count = 0;
        for(int i=0; i<L; i++) {
            if(count == K) {
                break;
            }
            if(arr[i] != null) {
                sb.append(arr[i]).append('\n');
                count++;
            }
        }
        System.out.println(sb);
    }
}