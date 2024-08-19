import java.util.*;
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String base = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Stack <Character> stack = new Stack<>();
        Stack <Character> tmp = new Stack<>();

        for(int i=0; i<base.length(); i++) {
            stack.push(base.charAt(i));
        }
        for(int i=0; i<n; i++) {
            String s[] = br.readLine().split(" ");
            if(s[0].equals("L")) {
                if(!stack.isEmpty()) {
                    tmp.push(stack.pop());
                }
            }
            else if(s[0].equals("D")) {
                if(!tmp.isEmpty()) {
                    stack.push(tmp.pop());
                }
            }
            else if(s[0].equals("B")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                String c = s[1];
                stack.push(c.charAt(0));
            }
        }
        
        while(!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        while(!tmp.isEmpty()) {
            bw.write(tmp.pop());
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}