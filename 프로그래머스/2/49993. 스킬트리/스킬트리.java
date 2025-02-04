import java.io.*;
import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        HashMap<Character, Integer> hash = new HashMap<>();
        
        int idx = 0;
        for(int i=0; i<skill.length(); i++) {
            hash.put(skill.charAt(i), ++idx);
        }
        
        int answer = 0;
        for(int t=0; t<skill_trees.length; t++) {
            String s = skill_trees[t];
            
            int pre = 1;
            boolean check = true;
            for(int i=0; i<s.length(); i++) {
                char now = s.charAt(i);
                
                
                if(hash.containsKey(now)) {
                    if(hash.get(now) > pre) {
                        check = false;
                        break;
                    }
                    pre++;
                
                    
                }
                
            }
            if(check) {
                answer++;
            }
        }
        
        return answer;
    }
}