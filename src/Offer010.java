import java.util.HashMap;

public class Offer010 {
    //给定一个整数数组， 和一个目标数，找数组中和符合目标的连续数组的个数

    public static int subarraySum(int[] nums, int k) {

        //前缀和
        int preSum = 0;
        int res = 0;
        HashMap<Integer, Integer> map  = new HashMap<>();
        map.put(0, 1);
        for(int a = 0; a < nums.length; a++){
            preSum += nums[a];
            res += map.getOrDefault(preSum - k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }

    public static int subarrayMult(int[] nums, int k){
        int preMult = 1;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //为什么这里面是零
        map.put(1, 1);
        for(int a = 0; a < nums.length; a++){
            preMult *= nums[a];
            res += map.getOrDefault(preMult/k, 0);
            map.put(preMult, map.getOrDefault(preMult, 0)+1);
        }
        return res;
    }

    //psvm
    public static void main(String[] args) {
        int[] ques = {1,0,1,0,0,0,0,1};
        System.out.println(subarraySum(ques, 1));
    }

}
