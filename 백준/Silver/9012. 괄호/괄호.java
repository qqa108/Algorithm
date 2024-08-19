import java.util.*;
import java.util.Stack;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack <Character> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            String s = scanner.next();
            String answer = "YES";

            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == '(') {
                    stack.push(s.charAt(j));
                }
                else {
                    if(stack.empty()) {
                        answer = "NO";
                        break;
                    }
                    if(stack.peek() == '(') {
                        stack.pop();
                    }
                    else {
                        answer = "NO";
                        break;
                    }
                }
            }
            if(!stack.empty()) {
                answer = "NO";
            }
            System.out.println(answer);
            stack.clear();
        }
        
        scanner.close();
    }
}