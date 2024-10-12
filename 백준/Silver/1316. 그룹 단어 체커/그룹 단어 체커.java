import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int count = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            boolean arr[] = new boolean[26];

            for(int j=0; j<s.length(); j++) {
                int idx = (int)(s.charAt(j) - 'a');

                if(j != 0 && s.charAt(j) != s.charAt(j-1) && arr[idx]) {
                    count++;
                    break;
                }
                arr[idx] = true;
            }
        }
        System.out.println(N - count);
    }
}