import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        List<Person> list = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < K; i++) {
            int tmp = Integer.parseInt(st.nextToken());

            boolean check = false;
            for (int j = 0; j < size; j++) {
                if (list.get(j).idx == tmp) {
                    list.get(j).count++;
                    check = true;
                    break;
                }
            }
            if (check) {
                continue;
            }
            if (size == N) {
                Collections.sort(list);
                list.remove(0);
                size--;
            }
            if (size < N) {
                list.add(new Person(tmp, 1, i));
                size++;
            }
        }

        int arr[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i).idx;
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        for (int i = 0; i < list.size(); i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    }

    static class Person implements Comparable<Person> {
        int idx, count, order;

        public Person(int idx, int count, int order) {
            this.idx = idx;
            this.count = count;
            this.order = order;
        }

        @Override
        public int compareTo(Person o) {
            if (this.count == o.count) {
                return this.order - o.order;
            }
            return this.count - o.count;
        }
    }
}