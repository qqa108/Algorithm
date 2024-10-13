import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> hash = new HashMap<>();
        List<String> list = new ArrayList<>();

        int count = 0;
        while (true) {
            String s = br.readLine();
            if (s == null) {
                break;
            }
            if (hash.containsKey(s)) {
                hash.replace(s, hash.get(s) + 1);
            } else {
                hash.put(s, 1);
                list.add(s);
            }
            count++;
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            String key = list.get(i);
            double num = ((double) hash.get(key) / (double) count) * 100;
            String percent = String.format("%.4f", num);
            sb.append(key).append(" ").append(percent).append("\n");
        }
        System.out.println(sb);
    }
}