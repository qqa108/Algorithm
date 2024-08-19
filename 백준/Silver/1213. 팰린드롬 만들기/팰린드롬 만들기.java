import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char word[] = s.toCharArray();
        Arrays.sort(word);
        
        char result[] = new char[word.length];
        int index=0;

        if(word.length % 2 == 0) {
            int count = 0;
            for(int i=1; i<word.length; i++) {
                if(word[i] == word[i-1]) {
                    result[index] = word[i-1];
                    result[word.length-index-1] = word[i];
                    index++;
                    i++;
                }
                else {
                    count++;
                    break;
                }
            }
            if(count == 1) {
                System.out.println("I'm Sorry Hansoo");
            }
            else {
                System.out.println(result);
            }
        }
        else {
            int count = 0;
            for(int i=1; i<word.length; i++) {
                if(word[i] == word[i-1]) {
                    result[index] = word[i-1];
                    result[word.length-index-1] = word[i];
                    index++;
                    i++;
                }
                else {
                    result[word.length/2] = word[i-1];
                    count++;
                }
                if(count == 2) {
                    break;
                }
            }
            if(count == 2) {
                System.out.println("I'm Sorry Hansoo");
            }
            else if(count == 0) {
                result[word.length/2] = word[word.length-1];
                System.out.println(result);
            }
            else {
                System.out.println(result);
            }
        }
        
        scanner.close();
    }
}