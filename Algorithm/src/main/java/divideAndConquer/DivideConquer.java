package divideAndConquer;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DivideConquer {


    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = f(nums, 0, nums.length);
        System.out.println(res);

    }

    //左闭右开区间，包含begin，不包含end
    private static int f(int[] nums, int begin, int end) {
        if (end - begin == 1) {
            return nums[begin];
        }

        int k = (end + begin) / 2;
        int t1 = f(nums, begin, k);
        int t2 = f(nums, k, end);

        int t3a = Integer.MIN_VALUE;  //保存中点左边的最大值，不包含中点
        int sum = 0; //初始值为0，代表不从中点左边选择任何一个数
        for (int i = k - 1; i >= begin; i--) {
            sum += nums[i];
            if (sum >= t3a) {
                t3a = sum;
            }
        }

        int t3b = Integer.MIN_VALUE; //保存中点右边的最大值，包含中点
        sum = 0; //同上
        for (int i = k; i < end; i++) {
            sum += nums[i];
            if (sum > t3b) {
                t3b = sum;
            }
        }

        int t3 = t3a + t3b; //左右两边的最大值加起来就是包含该中点的连续子序和的最大值

        //从左中右之中选择最大的那个值返回
        int max = t1;
        if (t2 > max) max = t2;
        if (t3 > max) max = t3;

        return max;
    }


}
