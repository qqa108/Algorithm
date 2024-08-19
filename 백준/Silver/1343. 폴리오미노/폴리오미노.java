import java.util.Scanner;

public class Main {
    static int n;
    static char[] board;
    static String answer = "-1";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        n = input.length();
        board = input.toCharArray();

        dfs(0);
        System.out.println(answer);
        scanner.close();
    }

    static void dfs(int idx) {
        if (idx == n) {
            // 모든 보드판을 덮었을 때
            String result = new String(board);
            if (answer.equals("-1") || result.compareTo(answer) < 0) {
                answer = result;
            }
            return;
        }

        if (board[idx] == '.') {
            dfs(idx + 1); // '.'를 그대로 둠
        } else if (idx + 3 < n && board[idx + 1] == 'X' && board[idx + 2] == 'X' && board[idx + 3] == 'X') {
            // 'AAAA' 패턴을 덮음
            board[idx] = 'A';
            board[idx + 1] = 'A';
            board[idx + 2] = 'A';
            board[idx + 3] = 'A';
            dfs(idx + 4);
            board[idx] = 'X';
            board[idx + 1] = 'X';
            board[idx + 2] = 'X';
            board[idx + 3] = 'X'; // 원상복구
        } else if (idx + 1 < n && board[idx + 1] == 'X') {
            // 'BB' 패턴을 덮음
            board[idx] = 'B';
            board[idx + 1] = 'B';
            dfs(idx + 2);
            board[idx] = 'X';
            board[idx + 1] = 'X'; // 원상복구
        }
    }
}