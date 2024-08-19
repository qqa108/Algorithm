import java.util.*;

public class Main {
    static boolean isInteger(char c) {
        if(c >= '1' && c <= '9') {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        HashMap<Integer, String> getname = new HashMap<>();
        HashMap<String, Integer> getnum = new HashMap<>();

        for(int i=0; i<n; i++) {
            String s = scanner.next();
            getname.put(i+1, s);
            getnum.put(s, i+1);
        }
        for(int i=0; i<m; i++) {
            String s = scanner.next();

            if(isInteger(s.charAt(0))) {
                String answer = getname.get(Integer.valueOf(s));
                System.out.println(answer);
            }
            else {
                int answer = getnum.get(s);
                System.out.println(answer);
            }
        }

        scanner.close();
    }
}