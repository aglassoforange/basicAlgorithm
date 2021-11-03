import java.util.HashMap;

public class Offer011 {
    public static int subarraySum(int[] nums, int k) {

        int pre_sum = 0;
        int ret = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : nums) {
            pre_sum += i;
            ret += map.getOrDefault(pre_sum - k, 0);
            map.put(pre_sum, map.getOrDefault(pre_sum, 0) + 1);
        }
        return ret;
    }


    //psvm
    public static void main(String[] args) {
        int[] ques = {1,1,1};
        System.out.println(subarraySum(ques, 2));
    }

}
