import java.util.*;
import java.util.Stack;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Stack <Character> stack = new Stack<>();

        while(true) {
            String s = scanner.nextLine();
            String answer = "yes";

            if(s.charAt(0) == '.') {
                break;
            }
            stack.clear();

            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);

                if((c == '(') || (c == '[')) {
                    stack.push(c);
                }
                else if(c == ')') {
                    if(stack.empty()) {
                        answer = "no";
                        break;
                    }
                    if(stack.peek() == '(') {
                        stack.pop();
                    }
                    else {
                        answer = "no";
                        break;
                    }
                }
                else if(c == ']') {
                    if(stack.empty()) {
                        answer = "no";
                        break;
                    }
                    if(stack.peek() == '[') {
                        stack.pop();
                    }
                    else {
                        answer = "no";
                        break;
                    }
                }
            }
            if(!stack.empty()) {
                answer = "no";
            }
            System.out.println(answer);
        }
        scanner.close();
    }
}