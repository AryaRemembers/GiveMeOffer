package solution;

import data.TreeNode;
import util.GenDataUtils;
import util.PrintUtils;

// https://leetcode.cn/problems/pOCWxh/
public class Offer047 {
    public static void main(String[] args) {
        TreeNode root = GenDataUtils.genTree(3,2);
        PrintUtils.printTreeNode(root);
        System.out.println("*************************");
        PrintUtils.printTreeNode(pruneTree(root));
    }




    public  static TreeNode pruneTree(TreeNode root) {
        if(isZeroTree(root)){
            return null;
        }else{
            return root;
        }
    }

    public static boolean isZeroTree(TreeNode root){
        if(root==null){
            return true;
        }
        boolean leftZero = false;
        boolean rightZero = false;
        if(isZeroTree(root.left)){
            root.left = null;
            leftZero = true;
        }
        if(isZeroTree(root.right)){
            root.right = null;
            rightZero = true;
        }
        if(root.val == 0){
            return leftZero&&rightZero;
        }else{
            return  false;
        }
    }

}
