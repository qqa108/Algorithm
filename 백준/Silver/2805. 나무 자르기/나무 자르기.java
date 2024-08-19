import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long m = scanner.nextLong();
        long sum = 0;
        long tree[] = new long[n];

        for (int i = 0; i < n; i++) {
            tree[i] = scanner.nextLong();
        }

        // 나무 높이 배열을 오름차순으로 정렬
        Arrays.sort(tree);

        long left = 0;
        long right = tree[n - 1]; // 최대 높이를 기준으로 시작

        while (left <= right) {
            long mid = (left + right) / 2;
            sum = 0;

            for (int i = n - 1; i >= 0; i--) {
                if (tree[i] - mid <= 0) {
                    break;
                } else {
                    sum += tree[i] - mid;
                }
            }

            if (sum < m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right); // right가 정답

        scanner.close();
    }
}
