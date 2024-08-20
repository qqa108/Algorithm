import java.util.*;
import java.io.*;

class Solution
{
    static String toBinary(int num) {
        String s = "";
        for(int i=32; i>0; i=i/2) {
            if(num / i == 1) {
                s = s + "1";
                num = num - i;
            }
            else {
                s = s + "0";
            }
        }
        return s;
    }
    static String toNum(String s) {
        int num = 0;
        int div = 128;
        String ans = "";
        
        for(int i=0; i<8; i++) {
            if(s.charAt(i) == '1') {
                num = num + div;
            }
            div = div / 2;
        }
        ans = ans + (char)num;
        
        num = 0;
        div = 128;
        for(int i=8; i<16; i++) {
            if(s.charAt(i) == '1') {
                num = num + div;
            }
            div = div / 2;
        }
        ans = ans + (char)num;
        
        num = 0;
        div = 128;
        for(int i=16; i<24; i++) {
            if(s.charAt(i) == '1') {
                num = num + div;
            }
            div = div / 2;
        }
        ans = ans + (char)num;
        //System.out.println("%%" + ans);
        
        return ans;
    }
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        HashMap <Character, Integer> map = new HashMap<>();
		int T;
		T=sc.nextInt();
        map.put('A', 0); map.put('B', 1); map.put('C', 2); map.put('D', 3); map.put('E', 4); map.put('F', 5); map.put('G', 6); map.put('H', 7);
        map.put('I', 8); map.put('J', 9); map.put('K', 10); map.put('L', 11); map.put('M', 12); map.put('N', 13); map.put('O', 14); map.put('P', 15);
        map.put('Q', 16); map.put('R', 17); map.put('S', 18); map.put('T', 19); map.put('U', 20); map.put('V', 21); map.put('W', 22); map.put('X', 23);
        map.put('Y', 24); map.put('Z', 25); map.put('a', 26); map.put('b', 27); map.put('c', 28); map.put('d', 29); map.put('e', 30); map.put('f', 31);
        map.put('g', 32); map.put('h', 33); map.put('i', 34); map.put('j', 35); map.put('k', 36); map.put('l', 37); map.put('m', 38); map.put('n', 39);
        map.put('o', 40); map.put('p', 41); map.put('q', 42); map.put('r', 43); map.put('s', 44); map.put('t', 45); map.put('u', 46); map.put('v', 47);
        map.put('w', 48); map.put('x', 49); map.put('y', 50); map.put('z', 51); map.put('0', 52); map.put('1', 53); map.put('2', 54); map.put('3', 55);
        map.put('4', 56); map.put('5', 57); map.put('6', 58); map.put('7', 59); map.put('8', 60); map.put('9', 61); map.put('+', 62); map.put('/', 63);
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String s = sc.next();
            String answer = "";
            int index = 0;
            for(int i=0; i<s.length()/4; i++) {
                String tmp = "";
                tmp = tmp + toBinary(map.get(s.charAt(index++)));
                tmp = tmp + toBinary(map.get(s.charAt(index++)));
                tmp = tmp + toBinary(map.get(s.charAt(index++)));
                tmp = tmp + toBinary(map.get(s.charAt(index++)));
                
                answer = answer + toNum(tmp);
                //System.out.println("^" + toNum(tmp));
            }
            System.out.println("#" + test_case + " " + answer);
		}
	}
}