package ArraySort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class SumOfNumbers {

    public static void main(String[] argu) {

//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {-4, -1, -1, 0, 1, 2};
//        int[] nums = {0, 0, 0};
//         int[] nums = {0, 0, 0,0};
//        int[] nums = {1,2,-2,-1};
        int[] nums = {-1, 0, 1, 0};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; (i < nums.length - 1) && nums[i] <= 0; i++) {
            int left = nums[i];
            for (int j = nums.length - 1; j >= 0 && nums[j] >= 0; j--) {
                int right = nums[j];
                int sum = left + right;
                if (sum > 0) {
                    int idx = i + 1;
                    while (idx <= (nums.length - 1) && nums[idx] < 0) {
                        addList(nums, lists, left, right, sum, idx, i, j);
                        idx++;
                    }

                } else if (sum < 0) {
                    int idx = nums.length - 2;
                    while (idx > i && nums[idx] > 0) {
                        addList(nums, lists, left, right, sum, idx, i, j);
                        idx--;
                    }
                } else {
                    int idx = i + 1;
                    while (idx < nums.length - 1) {
                        addList(nums, lists, left, right, sum, idx, i, j);
                        idx++;
                    }
                }
            }

        }
        return lists;
    }

    private static void addList(int[] nums, List<List<Integer>> lists, int left, int right, int sum, int idx, int i, int j) {
        List<Integer> list = new ArrayList<>();
        if (nums[idx] + sum == 0 && idx != i && idx != j && i != j) {
            list.add(nums[idx]);
            list.add(left);
            list.add(right);
            Collections.sort(list);
            if (!lists.contains(list)) {
                lists.add(list);
            }
        }
    }


}
