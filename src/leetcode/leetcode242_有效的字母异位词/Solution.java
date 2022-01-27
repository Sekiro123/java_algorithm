package leetcode.leetcode242_有效的字母异位词;
import org.junit.Test;

import java.util.HashMap;

public class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        char[] CharArrayS = s.toCharArray();
        char[] CharArrayT = t.toCharArray();
        for (int i = 0; i < CharArrayS.length; i++) {
            if(!mapS.containsKey(CharArrayS[i])){
                mapS.put(CharArrayS[i], 1);
            }
            else if(mapS.containsKey(CharArrayS[i])){
                mapS.put(CharArrayS[i], mapS.get(CharArrayS[i])+1);
            }
        }
        for (int i = 0; i < CharArrayT.length; i++) {
            if(!mapT.containsKey(CharArrayT[i])){
                mapT.put(CharArrayT[i], 1);
            }
            else if(mapT.containsKey(CharArrayT[i])){
                mapT.put(CharArrayT[i], mapT.get(CharArrayT[i])+1);
            }
        }

        return mapS.equals(mapT);
    }
    @Test
    public void test(){
        String s = "abababa";
        String t = "abababa";
        System.out.println(isAnagram(s, t));
    }
}
