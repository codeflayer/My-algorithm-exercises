package BinarySearch;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryBearch {
    public static void main(String[] argu) {
        int[] a = {1, 3, 5, 6};
        int b = 7;
        int c = searchInsert(a, b);
        System.out.println(c);
    }

    public static int searchInsert(int[] nums, int target) {
        if (target<nums[0])return 0;
        if (target>nums[nums.length-1])return (nums.length);
        int max = nums.length - 1;
        int min = 0;
        return search(nums, max, min, target);
    }

    static int search(int[] nums, int max, int min, int target) {
        int mdx = (max - min) / 2;
        int mid = nums[mdx];
        if (mid > target) {
            max = mdx;
            if (target != nums[mdx-1] ){
                return mdx;
            }
            return search(nums, max, min, target);
        } else if (mid < target) {
            min = mdx;
            if ( target != nums[mdx + 1] ){
                return mdx+1;
            }
            return search(nums, max, min, target);
        } else {
            return mdx;
        }
    }
}
