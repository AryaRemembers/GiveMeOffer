package solution;

import data.TreeNode;
import util.GenDataUtils;
import util.PrintUtils;

public class Offer026 {

    public static void main(String[] args) {
        TreeNode A = GenDataUtils.genTree("[1,0,1,-4,-3]");
        PrintUtils.printTreeNode(A);
        TreeNode B = GenDataUtils.genTree("[1,-4]");
        PrintUtils.printTreeNode(B);
        System.out.println(isSubStructure(A,B));
    }


    public static boolean helper(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        return A.val == B.val && helper(A.left, B.left) && helper(A.right, B.right);
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null||A==null){
            return false;
        }
        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }




}
