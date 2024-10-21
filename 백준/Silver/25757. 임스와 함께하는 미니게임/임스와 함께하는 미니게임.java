import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String s = st.nextToken();
        HashMap<String, Boolean> hash = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String now = st.nextToken();
            hash.put(now, true);
        }

        int size = hash.size();
        if (s.equals("F")) {
            size = size / 2;
        } else if (s.equals("O")) {
            size = size / 3;
        }

        System.out.println(size);
    }
}