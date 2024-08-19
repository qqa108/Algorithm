import java.util.*;

public class Main {
    public static void main(String agrs[]) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        HashMap <String, Integer> hash = new HashMap<>();

        int count = 0;
        int num = 0;
        for(int i=0; i<N; i++) {
            String s = scanner.next();
            if(s.equals("ENTER")) {
                num++;
            }
            else {
                if(hash.containsKey(s)) {
                    if(hash.get(s) != num) {
                        hash.put(s, num);
                        count++;
                    }
                }
                else {
                    hash.put(s, num);
                    count++;
                }
            }
        }
        System.out.println(count);
        scanner.close();
    }
}
