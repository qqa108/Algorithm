import java.util.*;

public class Main {
    public static void main(String agrs[]) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        HashMap<String, Integer> hash = new HashMap<>();

        hash.put("ChongChong", 1);

        for(int i=0; i<N; i++) {
            String a = scanner.next();
            String b = scanner.next();

            if(hash.containsKey(a)) {
                hash.put(b, 1);
            }
            else if(hash.containsKey(b)) {
                hash.put(a, 1);
            }
        }

        int count = 0;
        for(int val : hash.values()) {
            if(val == 1) {
                count++;
            }
        }

        System.out.println(count);
        
        scanner.close();
    }
}
