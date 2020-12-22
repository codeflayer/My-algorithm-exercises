package DFS;

import Tree.TreeNode;

import java.util.LinkedList;

/**
 * 1080. 根到叶路径上的不足节点
 * 难度
 * 中等
 * <p>
 * 23
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 给定一棵二叉树的根 root，请你考虑它所有 从根到叶的路径：从根到任何叶的路径。（所谓一个叶子节点，就是一个没有子节点的节点）
 * <p>
 * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为「不足节点」，需要被删除。
 * <p>
 * 请你删除所有不足节点，并返回生成的二叉树的根。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
 * <p>
 * 输出：[1,2,3,4,null,null,7,8,9,null,14]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
 * <p>
 * 输出：[5,4,8,11,null,17,4,7,null,null,null,5]
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [5,-6,-6], limit = 0
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的树有 1 到 5000 个节点
 * -10^5 <= node.val <= 10^5
 * -10^9 <= limit <= 10^9
 */
public class SufficientSubset {
    public static void main(String[] args) {

        //构造二叉树
//        输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
        TreeNode node1 = getTreeNode();
        TreeNode r = sufficientSubset(node1, 1);
        System.out.println(r.toString());
    }

    private static TreeNode getTreeNode() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node99 = new TreeNode(-99);
        TreeNode node991 = new TreeNode(-99);
        TreeNode node992 = new TreeNode(-99);
        TreeNode node993 = new TreeNode(-99);
        TreeNode node994 = new TreeNode(-99);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node99);
        node4.setLeft(node8);
        node4.setRight(node9);
        node99.setLeft(node991);
        node99.setRight(node992);
        node3.setLeft(node993);
        node3.setRight(node7);
        node992.setLeft(node12);
        node992.setRight(node13);
        node7.setLeft(node994);
        node7.setRight(node14);
        return node1;
    }

    public static TreeNode sufficientSubset(TreeNode root, int limit) {
        LinkedList<TreeNode> list = new LinkedList();
        dealNode(root, 0, limit);
//        root = dealLeftNode(root, 0);
//        root = dealRightNode(root, 0);
        System.out.println(list.toString());
        return root;
    }

    private static void dealNode(TreeNode node, int total, int limit) {
        if (node != null) {
            System.out.println("current==" + node.getVal());
            total = total + node.getVal();
            dealNode(node.getLeft(), total, limit);
            dealNode(node.getRight(), total, limit);
        } else {
//            System.out.println("total>>>>" + total);
//            System.out.println("limit>>>>" + limit);
        }

    }


    private static TreeNode dealRightNode(TreeNode root, int total) {
        if (root != null) {
            if (root.getRight() != null) {
                total = total + root.getRight().getVal();
                System.out.println("right==" + root.getRight().getVal());
                System.out.println("total==" + total);
                root = root.getRight();
                dealRightNode(root, total);
            }
        }
        return root;
    }

    private static TreeNode dealLeftNode(TreeNode root, int total) {
        if (root != null) {
            if (root.getLeft() != null) {
                total = total + root.getLeft().getVal();
                System.out.println("left==" + root.getLeft().getVal());
                System.out.println("total==" + total);
                root = root.getLeft();
                dealLeftNode(root, total);
            }
        }
        return root;
    }

}
