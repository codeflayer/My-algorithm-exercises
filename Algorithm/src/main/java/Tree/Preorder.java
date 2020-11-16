package Tree;

import java.util.Vector;

/**
 *
 题目来源于 LeetCode 上第 144 号问题：二叉树的前序遍历。题目难度为 Medium，目前通过率为 59.8% 。

 ### 题目描述

 给定一个二叉树，返回它的 *前序* 遍历。

 **示例:**

 ```
 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [1,2,3]
 ```

 **进阶:** 递归算法很简单，你可以通过迭代算法完成吗？
 */

public class Preorder {

    public static void main(String[] argu){

        //3,9,20,null,null,15,7
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.setLeft(node9);
        node3.setRight(node20);
        node20.setLeft(node15);
        node20.setRight(node7);
//        System.out.println(vectors.toString());
    }


}
