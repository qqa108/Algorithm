import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        HashMap<String, Boolean> hash = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Word> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (hash.containsKey(s)) {
                continue;
            }
            hash.put(s, true);
            pq.add(new Word(s));
        }

        while (!pq.isEmpty()) {
            Word now = pq.poll();
            sb.append(now.word).append("\n");
        }
        System.out.println(sb);
    }

    static class Word implements Comparable<Word> {
        String word;

        Word(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Word o) {
            if (this.word.length() == o.word.length()) {
                return this.word.compareTo(o.word);
            } else if (this.word.length() < o.word.length()) {
                return -1;
            }
            return 1;
        }
    }
}