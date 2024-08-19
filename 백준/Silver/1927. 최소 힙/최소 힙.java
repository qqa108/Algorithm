import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        PriorityQueue <Long> queue = new PriorityQueue<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            long num = Long.parseLong(st.nextToken());

            if(num == 0) {
                if(queue.isEmpty()) {
                    bw.write(0 + "\n");
                }
                else {
                    bw.write(queue.remove() + "\n");
                }        
            }
            else {
                queue.add(num);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}