package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * ### 题目描述
 * <p>
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: `[3,9,20,null,null,15,7]`,
 * <p>
 * ```
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * ```
 * <p>
 * 返回其层次遍历结果：
 * <p>
 * ```
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class Traverse {

    public static void main(String[] argu) {

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
        Vector<Vector<Integer>> vectors = levelOrder(node3);
        System.out.println(vectors.toString());
    }

    public static Vector<Vector<Integer>> levelOrder(TreeNode root) {
        TreeNode node = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        Vector vector = new Vector();
        while (!q.isEmpty()) {
            Vector vector1 = new Vector();
            TreeNode node1 = q.poll();
            System.out.println(node1.getVal());
            if (node1.getLeft() != null) {
                q.offer(node1.getLeft());
                vector1.add(node1.getLeft().getVal());
            }
            if (node1.getRight() != null) {
                q.offer(node1.getRight());
                vector1.add(node1.getRight().getVal());
            }
            vector.add(vector1);
        }
        System.out.println(vector.toString());
        return vector;
    }


}


