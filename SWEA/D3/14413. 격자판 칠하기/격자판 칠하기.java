import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int m = sc.nextInt();
            char board[][] = new char[n][m];
            int answer = 1;
            
            for(int i=0; i<n; i++) {
                String s = sc.next();
                for(int j=0; j<m; j++) {
                    board[i][j] = s.charAt(j);
                }
            }
            
            if(board[0][0] == '#') {
                for(int i=0; i<n; i++) {
                    char last;
                    if(i % 2 == 0) {
                        last = '#';
                    }
                    else {
                        last = '.';
                    }
                    for(int j=0; j<m; j++) {
                        if(board[i][j] != last && board[i][j] != '?') {
                            answer = 0;
                            break;
                        }
                        if(last == '#') {
                            last = '.';
                        }
                        else {
                            last = '#';
                        }
                    }
                }
            }
            else if(board[0][0] =='.') {
                for(int i=0; i<n; i++) {
                    char last;
                    if(i % 2 == 0) {
                        last = '.';
                    }
                    else {
                        last = '#';
                    }
                    for(int j=0; j<m; j++) {
                        if(board[i][j] != last && board[i][j] != '?') {
                            answer = 0;
                            break;
                        }
                        if(last == '#') {
                            last = '.';
                        }
                        else {
                            last = '#';
                        }
                    }
                }
            }
            else if(board[0][0] == '?') {
                for(int i=0; i<n; i++) {
                    char last;
                    if(i % 2 == 0) {
                        last = '#';
                    }
                    else {
                        last = '.';
                    }
                    for(int j=0; j<m; j++) {
                        if(board[i][j] != last && board[i][j] != '?') {
                            answer = 0;
                            break;
                        }
                        if(last == '#') {
                            last = '.';
                        }
                        else {
                            last = '#';
                        }
                    }
                }
                
                if(answer == 0) {
                    answer = 1;
                    for(int i=0; i<n; i++) {
                        char last;
                    	if(i % 2 == 0) {
                        	last = '.';
                    	}
                    	else {
                        	last = '#';
                    	}
                    	for(int j=0; j<m; j++) {
                        	if(board[i][j] != last && board[i][j] != '?') {
                            	answer = 0;
                            	break;
                        	}
                        	if(last == '#') {
                            	last = '.';
                        	}
                        	else {
                            	last = '#';
                        	}
                    	}
                	}
                }
            }
            
            if(answer == 1) {
                System.out.println("#" + test_case + " possible");
            }
            else {
                System.out.println("#" + test_case + " impossible");
            }
		
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}