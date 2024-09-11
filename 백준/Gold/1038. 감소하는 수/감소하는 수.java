import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Long> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        list = new ArrayList<>();
        dfs(0, 10);
        Collections.sort(list);

        if (N >= list.size()) {
            System.out.println(-1);
        }
        else {
            System.out.println(list.get(N));
        }
    }

    static void dfs(long idx, int start) {
        if (idx > 100_000_0000) {
            return;
        }
        for (int i = 0; i < start; i++) {
            if (idx / 10 == 0 || idx % 10 > i) {
                long next = (idx * 10) + i;
                list.add(next);
                dfs(next, i);
            }
        }
    }
}