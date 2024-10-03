import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static Game posibility[];
    static int score[];
    static double sum[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        posibility = new Game[6];
        score = new int[4];
        sum = new double[4];

        HashMap<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            String s = st.nextToken();
            hash.put(s, i);
        }
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            int teamA = hash.get(a);
            int teamB = hash.get(b);
            double w = Double.parseDouble(st.nextToken());
            double d = Double.parseDouble(st.nextToken());
            double l = Double.parseDouble(st.nextToken());
            posibility[i] = new Game(teamA, teamB, w, d, l);
        }
        dfs(0, 1);
        for (int i = 0; i < 4; i++) {
            System.out.printf("%.10f%n", sum[i]);
        }
    }

    static void dfs(int idx, double p) {
        if (idx == 6) {
            int max = 0;
            int maxidx = 0;
            List<Integer> maxList = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                if (score[i] > max) {
                    max = score[i];
                    maxidx = i;
                }
            }
            for (int i = 0; i < 4; i++) {
                if (score[i] == max) {
                    maxList.add(i);
                }
            }

            max = 0;
            List<Integer> max2List = new ArrayList<>();
            if (maxList.size() < 2) {
                for (int i = 0; i < 4; i++) {
                    if (score[i] > max && i != maxidx) {
                        max = score[i];
                    }
                }
                for (int i = 0; i < 4; i++) {
                    if (score[i] == max) {
                        max2List.add(i);
                    }
                }
            }

            if (maxList.size() == 1) {
                for (int i = 0; i < maxList.size(); i++) {
                    sum[maxList.get(i)] = sum[maxList.get(i)] + p;
                }
                for (int i = 0; i < max2List.size(); i++) {
                    sum[max2List.get(i)] = sum[max2List.get(i)] + (p / max2List.size());
                }
            } else {
                for (int i = 0; i < maxList.size(); i++) {
                    sum[maxList.get(i)] = sum[maxList.get(i)] + (p / maxList.size()) * 2;
                }
            }


            return;
        }
        Game now = posibility[idx];

        if (now.w != 0) {
            score[now.from] = score[now.from] + 3;
            dfs(idx + 1, p * now.w);
            score[now.from] = score[now.from] - 3;
        }
        if (now.d != 0) {
            score[now.from] = score[now.from] + 1;
            score[now.to] = score[now.to] + 1;
            dfs(idx + 1, p * now.d);
            score[now.from] = score[now.from] - 1;
            score[now.to] = score[now.to] - 1;
        }
        if (now.l != 0) {
            score[now.to] = score[now.to] + 3;
            dfs(idx + 1, p * now.l);
            score[now.to] = score[now.to] - 3;
        }
    }

    static class Game {
        int from, to;
        double w, d, l;

        Game(int from, int to, double w, double d, double l) {
            this.from = from;
            this.to = to;
            this.w = w;
            this.d = d;
            this.l = l;
        }
    }
}