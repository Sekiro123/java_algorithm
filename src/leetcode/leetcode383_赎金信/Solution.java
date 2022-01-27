package leetcode.leetcode383_Êê½ðÐÅ;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        char[] charArray1 = ransomNote.toCharArray();
        char[] charArray2 = magazine.toCharArray();
        for (char c : charArray1) {
            if(map1.containsKey(c)){
                map1.put(c, map1.get(c)+1);
            }else{
                map1.put(c, 0);
            }
        }
        for (char c : charArray2) {
            if(map2.containsKey(c)){
                map2.put(c, map2.get(c)+1);
            }else{
                map2.put(c, 0);
            }
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if(!map2.containsKey(entry.getKey())){
                return false;
            }else if(map2.get(entry.getKey()) < entry.getValue()){
                return false;
            }
        }
        return true;
    }
}
