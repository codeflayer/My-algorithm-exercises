package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目来源于 LeetCode 上第 144 号问题：二叉树的前序遍历。题目难度为 Medium，目前通过率为 59.8% 。
 * <p>
 * ### 题目描述
 * <p>
 * 给定一个二叉树，返回它的 *前序* 遍历。
 * <p>
 * *示例:**
 * <p>
 * ```
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * ```
 * <p>
 * *进阶:** 递归算法很简单，你可以通过迭代算法完成吗？
 */

public class Preorder {

    public static void main(String[] argu) {

//        //3,9,20,null,null,15,7
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node9 = new TreeNode(9);
//        TreeNode node20 = new TreeNode(20);
//        TreeNode node15 = new TreeNode(15);
//        TreeNode node7 = new TreeNode(7);
//
//        node3.setLeft(node9);
//        node3.setRight(node20);
//        node20.setLeft(node15);
//        node20.setRight(node7);

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);

        node1.setLeft(null);
        node1.setRight(node2);
        node2.setLeft(node3);
        node3.setLeft(node5);
        node3.setRight(node7);
        node2.setRight(node4);
        node4.setRight(node6);

        node2.setParent(node1);
        node3.setParent(node2);
        node5.setParent(node3);
        node7.setParent(node3);
        node4.setParent(node2);
        node6.setParent(node4);
        List<Integer> list = preorderTraversal(node1);
        System.out.println(list.toString());
    }
    //利用栈先进后出的特性，把后面的先push 进去，然后pop 出来
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        //当它的孩子不为空时，将孩子压入栈，一定是先压右孩子再压左孩子
        while (!stack.isEmpty()) {
            //此处的root只是一个变量的复用
            root = stack.pop();
            list.add(root.getVal());

            System.out.println("------");
            System.out.println(list.toString());
            stack.forEach(treeNode -> {
                System.out.println(treeNode.getVal().toString());
            });
            System.out.println("========");

            if (root.getRight() != null) {
                stack.push(root.getRight());
            }
            if (root.getLeft() != null) {
                stack.push(root.getLeft());
            }
        }
        return list;
    }


}
