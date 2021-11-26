package WindowSliding;

import java.util.HashMap;

public class LeetCode3 {

    public static int NoRepeatMax(String s){

        if(s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            //如果条件被触发
            if(map.containsKey(s.charAt(r))){
                //左节点的位置将会改到被删去节点的下一个

                //当abba这种情况 a发生在 bb之前 所以不能将l 调整到比原来l还小的地方
                l = Math.max(map.get(s.charAt(r)) + 1, l);
                map.put(s.charAt(r), r);
            }else{
                map.put(s.charAt(r), r);
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

}
