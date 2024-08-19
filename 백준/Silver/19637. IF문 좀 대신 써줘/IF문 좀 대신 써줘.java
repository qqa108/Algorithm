import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Long, String> hash = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long power[] = new long[n+1];
        int size = 1;

        power[0] = -1;
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            String title = st.nextToken();
            long stat = Long.parseLong(st.nextToken());
            
            if(stat == power[size-1]) {
                continue;
            }
            else {
                power[size++] = stat;
                hash.put(stat, title);
            }
        }

        for(int i=0; i<m; i++) {
            long stat = Long.parseLong(br.readLine());
            int left = 1;
            int right = size-2;
            int mid = (left + right);
            
            while(true) {
                if(stat > power[mid-1] && stat <= power[mid]) {
                    bw.write(hash.get(power[mid]) + "\n");
                    break;
                }
                if(power[mid] > stat) {
                    right = mid - 1;
                    mid = (left + right)/2;
                }
                else {
                    left = mid + 1;
                    mid = (left + right)/2;
                }
            }
        }

        br.close();
        bw.close();
    }
}