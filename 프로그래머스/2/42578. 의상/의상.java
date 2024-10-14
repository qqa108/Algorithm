import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> cloth = new HashMap<>();
        HashMap<String, Integer> kind = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            String c = clothes[i][0];
            String k = clothes[i][1];
            
            if(kind.containsKey(k)) {
                kind.put(k, kind.get(k)+1);
                cloth.put(c, 1);
            }
            else {
                kind.put(k, 1);
                cloth.put(c, 1);
            }
        }
        
        int sum = 1;
        for(int i : kind.values()) {
            sum = sum * (i+1);
        }
        
        int answer = sum - 1;
        return answer;
    }
}