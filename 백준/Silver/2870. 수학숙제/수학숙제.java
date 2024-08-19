import java.math.BigInteger;
import java.util.*;

public class Main {
    static boolean isInteger(char c) {
        if((int)c >= 97 && (int)c <= 122) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList <BigInteger> v = new ArrayList<>();

        for(int i=0; i<n; i++) {
            String s = "a" + scanner.next() + "a";
            String num = "";

            for(int j=1; j<s.length(); j++) {
                if(isInteger(s.charAt(j))) {
                    num = num + (s.charAt(j));
                }
                else {
                    if(num != "") {
                        v.add(new BigInteger(num));
                        num = "";
                    }
                }
            }
        }
        
        /*long arr[] = new long[v.size()];
        for(int i=0; i<v.size(); i++) {
            arr[i] = v.get(i);
        }

        Arrays.sort(v);*/
        Collections.sort(v);
        
        for(int i=0; i<v.size(); i++) {
            System.out.println(v.get(i));
        }

        scanner.close();
    }
}