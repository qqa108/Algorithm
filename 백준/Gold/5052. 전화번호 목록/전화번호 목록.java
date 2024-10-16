import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String arr[] = new String[N];
            HashMap<String, Boolean> hash = new HashMap<>();
            boolean answer = false;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = st.nextToken();
                hash.put(arr[i], true);
            }
            for (int i = 0; i < N; i++) {
                StringBuilder tmp = new StringBuilder();
                String now = arr[i];

                for (int j = 0; j < now.length() - 1; j++) {
                    tmp.append(now.charAt(j));
                    String s = tmp.toString();

                    if (hash.containsKey(s)) {
                        answer = true;
                    }
                }
            }
            if (!answer) {
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }
        System.out.println(sb);
    }


    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> hash = new HashMap<>();
        boolean answer = true;

        for (int i = 0; i < phone_book.length; i++) {
            hash.put(phone_book[i], true);
        }

        for (int i = 0; i < phone_book.length; i++) {
            StringBuilder sb = new StringBuilder();
            String now = phone_book[i];

            for (int j = 0; j < now.length() - 1; j++) {
                sb.append(now.charAt(j));
                String s = sb.toString();

                if (hash.containsKey(s)) {
                    answer = false;
                }
            }
        }
        return answer;
    }
}