import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int matrixA[][] = new int[n][m];

        for(int i=0; i<n; i++) {
            String s = scanner.next();
            for(int j=0; j<m; j++) {
                if(s.charAt(j) == '1') {
                    matrixA[i][j] = 1;
                }
                else {
                    matrixA[i][j] = 0;
                }
            }
        }
        for(int i=0; i<n; i++) {
            String s = scanner.next();
            for(int j=0; j<m; j++) {
                if(s.charAt(j) == '1') {
                    if(matrixA[i][j] == 1) {
                        matrixA[i][j] = 0;
                    }
                    else {
                        matrixA[i][j] = 1;
                    }
                }
                else {
                    if(matrixA[i][j] == 1) {
                        matrixA[i][j] = 1;
                    }
                    else {
                        matrixA[i][j] = 0;
                    }
                }
            }
        }

        int a = 0;
        int b = 0;
        int count = 0;
        int answer = 0;
        int end = 0;

        while(true) {
            if(n<3 || m<3) {
                end++;
            }
            if(end == 1) {
                for(int i=0; i<n; i++) {
                    for(int j=0; j<m; j++) {
                        if(matrixA[i][j] == 1) {
                            count++;
                        }
                    }
                }
                if(count != 0) {
                    answer = -1;
                }
                break;
            }
            if(matrixA[a][b] == 1) {
                for(int i=a; i<a+3; i++) {
                    for(int j=b; j<b+3; j++) {
                        if(matrixA[i][j] == 1) {
                            matrixA[i][j] = 0;
                        }
                        else {
                            matrixA[i][j] = 1;
                        }
                    }
                }
                answer++;
            }

            if(a == n-3 && b == m-3) {
                end++;
            }
            else if(a != n-3 && b == m-3) {
                b = 0;
                a++;
            }
            else {
                b++;
            }
        }
        System.out.println(answer);

        scanner.close();
    }
}