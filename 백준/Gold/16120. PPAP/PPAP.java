import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char arr[] = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
            int size = stack.size();

            if (stack.size() - 4 >= 0 && stack.get(size - 4) == 'P' && stack.get(size - 3) == 'P' && stack.get(size - 2) == 'A' && stack.get(size - 1) == 'P') {
                stack.pop();
                stack.pop();
                stack.pop();
            }
        }

        String answer = "NP";
        if (stack.size() == 1 && stack.peek() == 'P') {
            answer = "PPAP";
        }

        System.out.println(answer);
    }
}