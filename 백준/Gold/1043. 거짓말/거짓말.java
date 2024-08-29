import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int parent[];
    static ArrayList<Integer> party[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int truth[] = new int[T];
        for (int i = 0; i < T; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                party[i].add(tmp);
            }
        }

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int first = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(first, party[i].get(j));
            }
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            int first = party[i].get(0);
            boolean check = true;

            for (int j = 0; j < T; j++) {
                if (isSame(first, truth[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                count++;
            }
        }
        System.out.println(count);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    static boolean isSame(int a, int b) {
        if (find(a) == find(b)) {
            return true;
        }
        return false;
    }
}