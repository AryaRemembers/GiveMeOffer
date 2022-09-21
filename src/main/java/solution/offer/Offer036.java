package solution.offer;

import data.TreeNode;
import util.GenDataUtils;
import util.PrintUtils;

public class Offer036 {
    public static void main(String[] args) {
        TreeNode root = GenDataUtils.genFullBinarySearchTree(3);
        PrintUtils.printTreeNode(root);
         treeToDoublyList(root);

    }

    public static TreeNode treeToDoublyList(TreeNode root) {
        if(root==null) return root;
        dfs(root);
        prev.right = head;
        head.left = prev;
        return head;
    }

    static TreeNode head,prev;
    public static void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        if(prev==null){
            head = node;
        }else{
            prev.right = node;
        }
        node.left = prev;
        prev = node;
        dfs(node.right);
    }




}
