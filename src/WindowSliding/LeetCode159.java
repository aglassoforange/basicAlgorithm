package WindowSliding;

import java.util.HashMap;

public class LeetCode159 {

    //在一个字符串S 找出之多 两个不同的最长子串
    public static int maxLength(String s){

        HashMap<Character, Integer> map = new HashMap<>();

        int maxLen = 0;

        //不断再往前走的是右坐标
        for(int l = 0,r = 0; r < s.length(); r++) {

            if (map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
            } else {
                map.put(s.charAt(r), 1);
            }

            while (map.size() > 2) {
                if (map.get(s.charAt(l)) > 1) {
                    map.put(s.charAt(l),  map.get(s.charAt(l)) - 1);
                }else{
                    map.remove(s.charAt(l));
                }
                l++;
            }

            maxLen = Math.max(maxLen, r - l);

        }
        return maxLen;
    }

}
