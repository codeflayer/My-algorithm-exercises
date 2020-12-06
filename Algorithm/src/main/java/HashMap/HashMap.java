package HashMap;

import java.util.Hashtable;

public class HashMap {

    /**
     * 1. 两数之和
     * 难度
     * 简单
     * <p>
     * 9767
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] r = twoSum(nums, target);
        System.out.println(r.toString());
    }

    public static int[] twoSum(int[] nums, int target) {
        Hashtable<Integer,Integer> t = new Hashtable();
        int[] re = null;
        for (int i = 0; i < nums.length; i++) {
            int te = target - nums[i];
            if (t.containsKey(te)) {
                re = new int[]{t.get(te), i};
            }
            t.put(nums[i], i);
        }
        return re;
    }
}
