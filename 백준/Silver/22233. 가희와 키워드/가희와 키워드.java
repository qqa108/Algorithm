import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap <String, Integer> hash = new HashMap <> ();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String note = st.nextToken();
            hash.put(note, 1);
            count++;
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            String blog = st.nextToken();
            String []key = blog.split(",");

            for(int j=0; j<key.length; j++) {
                if(hash.containsKey(key[j])) {
                    hash.remove(key[j]);
                    count--;
                }
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
