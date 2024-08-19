import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String password = scanner.next();

            if(password.equals("end")) {
                break;
            }

            char []alpha = password.toCharArray();
            int acount = 0;
            int bcount = 0;
            int count = 0;
            int answer = 0;
     
            for(int i=0; i<alpha.length; i++) {
                if(alpha[i]=='a'||alpha[i]=='e'||alpha[i]=='i'||alpha[i]=='o'||alpha[i]=='u')  {
                    acount++;
                    count++;
                    bcount = 0;
                }
                else {                
                    bcount++;
                    acount = 0;
                }

                if(acount >= 3 || bcount >= 3) {
                    answer--;
                    break;
                }
                if(i > 0) {
                    if(alpha[i-1] == alpha[i] && alpha[i] != 'e' && alpha[i] != 'o') {
                        answer--;
                        break;
                    }
                }
            }
            if(count == 0) {
                answer--;
            }

            if(answer == 0) {
                System.out.println("<" + password + "> is acceptable.");
            }
            else {
                System.out.println("<" + password + "> is not acceptable.");
            }
        }
        scanner.close();
    }
}
