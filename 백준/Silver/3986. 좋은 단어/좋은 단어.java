import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack <Character> stack = new Stack<>();
        int count = 0;

        for(int i=0; i<n; i++) {
            String s = scanner.next();
            for(int j=0; j<s.length(); j++) {
                if(stack.empty()) {
                    stack.push(s.charAt(j));
                }
                else {
                    if(s.charAt(j) == stack.peek()) {
                        stack.pop();
                    }
                    else {
                        stack.push(s.charAt(j));
                    }
                }
            }
            if(stack.empty()) {
                count++;
            }
            stack.clear();
        }
        System.out.println(count);
        
        scanner.close();
    }
}