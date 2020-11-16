package Tree;

import java.util.*;

/**
 *
 ### 题目描述

 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

 例如:
 给定二叉树: `[3,9,20,null,null,15,7]`,

 ```
 3
 / \
 9  20
 /  \
 15   7
 ```

 返回其层次遍历结果：

 ```
 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class Traverse {

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
        Vector<Vector<Integer>> vectors = levelOrder(node3);
        System.out.println(vectors.toString());
    }

    public  static   Vector<Vector<Integer>> levelOrder(TreeNode root) {
        TreeNode node = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        Vector vector = new Vector();
        while (!q.isEmpty()){
            Vector vector1 = new Vector();
            TreeNode node1 = q.poll();
            System.out.println(node1.getVal());
           if (node1.getLeft()!=null){
               q.offer(node1.getLeft());
               vector1.add(node1.getLeft().getVal());
           }
           if (node1.getRight()!=null){
               q.offer(node1.getRight());
               vector1.add(node1.getRight().getVal());
           }
            vector.add(vector1);
        }
        System.out.println(vector.toString());
        return vector;
    }


}

class TreeNode{

    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;
    private Integer val;

    public TreeNode(Integer val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

}
