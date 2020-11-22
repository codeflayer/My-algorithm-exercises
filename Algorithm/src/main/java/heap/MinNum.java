package heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 40. 最小的k个数
 * 难度
 * 简单
 * <p>
 * 162
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class MinNum {

    public static void main(String[] argu) {
//        int[] arr = {3, 2, 1};
        int[] arr = {5,4,1,3,6,2,9};
        int k = 2;
        int[] a = getLeastNumbers(arr, k);
        System.out.println(a);
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }

        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));
        for (int i = 0; i <arr.length; i++) {
            int e = arr[i];
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }
        System.out.println(heap);
        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;

     }
}
