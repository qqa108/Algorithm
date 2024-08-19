import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        int test = scanner.nextInt();

        for(int i=0; i<test; i++) {
            int num = scanner.nextInt();
            HashMap <String, Integer> hash = new HashMap<>(num);

            for(int j=0; j<num; j++) {
                String kind = scanner.next();
                kind = scanner.next();
                
                if(hash.containsKey(kind)) {
                    int count = hash.get(kind);
                    count++;
                    hash.put(kind, count);
                }
                else {
                    hash.put(kind, 1);
                }
            }

            int answer = 1;
            for(int val : hash.values()) {
                answer = answer * (val + 1);
            }
            System.out.println(answer - 1);
        }

        scanner.close();
    }
}