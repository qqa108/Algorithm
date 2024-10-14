import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> hash = new HashMap<>();
        boolean answer = true;
        
        for(int i=0; i<phone_book.length; i++) {
            hash.put(phone_book[i], true);
        }
        
        for(int i=0; i<phone_book.length; i++) {
            StringBuilder sb = new StringBuilder();
            String now = phone_book[i];
            
            for(int j=0; j<now.length()-1; j++) {
                sb.append(now.charAt(j));
                String s = sb.toString();
                
                if(hash.containsKey(s)) {
                    answer = false;
                }
            }
        }
        return answer;
    }
}