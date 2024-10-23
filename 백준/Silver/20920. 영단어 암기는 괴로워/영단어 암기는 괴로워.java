import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.length() >= M) {
                if (!hash.containsKey(s)) {
                    hash.put(s, 1);
                } else {
                    hash.put(s, hash.get(s) + 1);
                }
            }
        }

        Word arr[] = new Word[hash.size()];
        int idx = 0;
        for (String key : hash.keySet()) {
            arr[idx++] = new Word(hash.get(key), key);
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i].w).append("\n");
        }
        System.out.println(sb);
    }

    static class Word implements Comparable<Word> {
        int fre;
        String w;

        public Word(int fre, String w) {
            this.fre = fre;
            this.w = w;
        }

        @Override
        public int compareTo(Word o) {
            if (this.fre == o.fre) {
                if (this.w.length() == o.w.length()) {
                    return this.w.compareTo(o.w);
                }
                return o.w.length() - this.w.length();
            }
            return o.fre - this.fre;
        }
    }
}