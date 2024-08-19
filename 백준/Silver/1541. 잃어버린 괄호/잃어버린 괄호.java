import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char calculate[] = s.toCharArray();
        int sum = 0;
        String number = "";
        int isminus = 0;
        int pre = 0;
        
        for(int i=0; i<calculate.length; i++) {
            if(calculate[i] == '+') {
                pre = Integer.parseInt(number);
                if(isminus == 1) {
                    sum = sum - pre;
                }
                else {
                    sum = sum + pre;
                }
                number = "";
            }
            else if(calculate[i] == '-') {
                pre = Integer.parseInt(number);
                if(isminus == 1) {
                    sum = sum - pre;
                }
                else {
                    sum = sum + pre;
                }
                isminus = 1;
                number = "";
            }
            else {
                number = number + calculate[i];
            }
        }
        if(isminus == 1) {
            sum = sum - Integer.parseInt(number);
        }
        else {
            sum = sum + Integer.parseInt(number);
        }
        System.out.println(sum);
        
        scanner.close();
    }
}