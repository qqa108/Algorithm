import java.util.*;
import java.io.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = -1;
        int possible = 0;
        int len = skill.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < len; i++){
            map.put(skill.charAt(i), i);
        }
        int size = skill_trees.length;
        for(int i = 0; i < size; i++){
            boolean []isUsed = new boolean[len];
            boolean check = true;
            for(int j = 0; j < skill_trees[i].length(); j++){
                char now = skill_trees[i].charAt(j);
                if(map.containsKey(now)){
                    int idx = map.get(now);
                    System.out.println("1. now : " + now);
                    System.out.println("2. idx : " + idx);
                    System.out.println("3. 현재 단어 : " + skill_trees[i]);
                    if(idx == 0){
                        isUsed[idx] = true;
                        System.out.println("idx가 0입니다.");
                    }
                    else{
                        System.out.println("우선 idx는 0이 아님");
                        if(isUsed[idx-1] == false){
                            System.out.println("4. idx : " + idx);
                            System.out.println("이전 idx가 사용되지 않았어요.");
                            check = false;
                            break;
                        }
                        else{
                            isUsed[idx] = true;
                            System.out.println("5. 현재 idx 통과");
                        }
                    }
                }
            }
            System.out.println("한 단어 끝남..");
            if(check)
                possible++;
        }
        if(possible > 0)
            return possible;
        else
            return answer;
    }
}