import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[][][] = new int[10][10][10];

        for(int i=1; i<10; i++) {
            for(int j=1; j<10; j++) {
                for(int k=1; k<10; k++) {
                    if((i != j) && (j != k) && (i != k)) {
                        arr[i][j][k]=0;
                    }
                    else {
                        arr[i][j][k]=-1;
                    }
                }
            }
        }
        
        for(int a=0; a<n; a++) {
            int num = scanner.nextInt();
            int strike = scanner.nextInt();
            int ball = scanner.nextInt();
            int first = num/100;
            int second = num/10 - (num/100)*10;
            int third = num%10;

            if(strike == 0 && ball == 0) {
                for(int i=1; i<10; i++) {
                    for(int j=1; j<10; j++) {
                        for(int k=1; k<10; k++) {
                            if(first==i||first==j||first==k||second==i||second==j||second==k||third==i||third==j||third==k) {

                            }
                            else {
                                arr[i][j][k]++;
                            }
                        }
                    }
                }
            }
            else if(strike == 0 && ball == 1) {
                for(int i=1; i<10; i++) {
                    for(int j=1; j<10; j++) {
                        for(int k=1; k<10; k++) {
                            if(first==j&&second!=i&&second!=k&&third!=i&&third!=k||
                            first==k&&second!=i&&second!=j&&third!=i&&third!=j||
                            second==i&&first!=j&&first!=k&&third!=j&&third!=k||
                            second==k&&first!=i&&first!=j&&third!=i&&third!=j||
                            third==i&&first!=j&&first!=k&&second!=j&&second!=k||
                            third==j&&first!=i&&first!=k&&second!=i&&second!=k) {
                                arr[i][j][k]++;
                            }
                        }
                    }
                }
            }
            else if(strike == 0 && ball == 2) {
                for(int i=1; i<10; i++) {
                    for(int j=1; j<10; j++) {
                        for(int k=1; k<10; k++) {
                            if(first==j&&second==i&&third!=k||first==j&&second==k&&third!=i||
                            first==k&&second==i&&third!=j||second==i&&third==j&&first!=k||
                            second==k&&third==j&&first!=i||second==k&&third==i&&first!=j||
                            first==j&&third==i&&second!=k||first==k&&third==i&&second!=j||first==k&&third==j&&second!=i) {
                                arr[i][j][k]++;
                            }
                        }
                    }
                }
            }
            else if(strike == 0 && ball == 3) {
                for(int i=1; i<10; i++) {
                    for(int j=1; j<10; j++) {
                        for(int k=1; k<10; k++) {
                            if(first==j&&second==k&&third==i || first==k&&second==i&&third==j) {
                                arr[i][j][k]++;
                            }
                        }
                    }
                }
            }
            else if(strike == 1 && ball == 0) {
                for(int i=1; i<10; i++) {
                    for(int j=1; j<10; j++) {
                        for(int k=1; k<10; k++) {
                            if(first==i&&second!=j&&second!=k&&third!=j&&third!=k||
                            second==j&&first!=i&&first!=k&&third!=i&&third!=k||
                            third==k&&first!=i&&first!=j&&second!=i&&second!=j) {
                                arr[i][j][k]++;
                            }
                        }
                    }
                }
            }
            else if(strike == 1 && ball == 1) {
                for(int i=1; i<10; i++) {
                    for(int j=1; j<10; j++) {
                        for(int k=1; k<10; k++) {
                            if(first==i&&second==k&&third!=j||first==i&&third==j&&second!=k||
                            second==j&&third==i&&first!=k||second==j&&first==k&&third!=i||
                            third==k&&second==i&&first!=j||third==k&&first==j&&second!=i) {
                                arr[i][j][k]++;
                            }
                        }
                    }
                }
            }
            else if(strike == 1 && ball == 2) {
                for(int i=1; i<10; i++) {
                    for(int j=1; j<10; j++) {
                        for(int k=1; k<10; k++) {
                            if(first==i&&second==k&&third==j||first==k&&second==j&&third==i||
                            first==j&&second==i&&third==k) {
                                arr[i][j][k]++;
                            }
                        }
                    }
                }
            }
            else if(strike == 2 && ball == 0) {
                for(int i=1; i<10; i++) {
                    for(int j=1; j<10; j++) {
                        for(int k=1; k<10; k++) {
                            if(first==i&&second==j&&third!=k||first==i&&third==k&&second!=j||second==j&&third==k&&first!=i) {
                                arr[i][j][k]++;
                            }
                        }
                    }
                }
            }
            else if(strike == 3 && ball == 0) {
                arr[first][second][third]++;
                break;
            }

        }

        int count = 0;
        for(int i=1; i<10; i++) {
            for(int j=1; j<10; j++) {
                for(int k=1; k<10; k++) {
                    if(arr[i][j][k] == n) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        scanner.close();
    }
}