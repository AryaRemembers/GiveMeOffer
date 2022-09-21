package util;

import data.ListNode;
import data.TreeNode;

public class PrintUtils {
    public static void printListNode(ListNode head){
        StringBuilder sb = new StringBuilder("ListNode:");
        while(head!=null){
            sb.append(head.val+"->");
            head = head.next;
        }
        int idx = sb.lastIndexOf("->");
        if(idx!=-1){
            sb.delete(idx,idx+2);
        }
        sb.append("\n");
        System.out.println(sb);
    }

    private static int heightOfTree(TreeNode head){
        if(head==null){
            return 0;
        }
        return 1+Math.max(heightOfTree(head.left), heightOfTree(head.right));
    }

    public static void main(String[] args) {
        TreeNode root = GenDataUtils.genTree(3);
        printTreeNode(root);
        System.out.println(heightOfTree(root));
    }

    public static void printTreeNode(TreeNode root) {
        printTreeNode(root,2);
    }

    public static void printTreeNode(TreeNode root,int maxNumLen) {
        if(root==null){
            return;
        }
        int h = heightOfTree(root);
        int W = maxNumLen*(int)Math.pow(2, h);
        StringBuilder[] lines = new StringBuilder[h*2-1];
        for(int i = 0; i < h*2-1; i++) {
            lines[i] = new StringBuilder(String.format("%" + W + "s", ""));
        }

        printNode(lines, W, root, 0, 0);
        for(StringBuilder line : lines) {
            System.out.println(line.toString());
        }

    }

    private static void printNode(StringBuilder[] lines, int W, TreeNode node, int h, int base) {
        if(node==null){
            return;
        }
        double nums = Math.pow(2, h);
        int pos = base + (int)( W / nums /2);

        String str = ""+node.val;
        for(int i = 0; i < str.length(); i++) {
            lines[h*2].setCharAt(pos + i, str.charAt(i));
        }

        if(node.left != null) {
            lines[h*2+1].setCharAt(pos-1, '/');
            printNode(lines, W, node.left, h+1, base);
        }

        if(node.right != null) {
            lines[h*2 + 1].setCharAt(pos + str.length() + 1, '\\');
            printNode(lines, W, node.right, h+1, pos);
        }


    }


//    public static void printTreeNode(TreeNode head){
//        int height = getHeight(head);
//        int maxOutWidth = (int)Math.pow(2,height-1)+height-1;
//        StringBuilder sb = new StringBuilder("Tree:");
//        char[][] trees = new char[height+height-1][maxOutWidth];
//
//        ArrayList<StringBuilder> treeStr = new ArrayList<>();
//        StringBuilder level = new StringBuilder();
//
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(head);
//        while(!queue.isEmpty()){
//            TreeNode treeNode = queue.poll();
//            if(treeNode.left!=null){
//                level.append(treeNode);
//            }
//            sb.append(head.val+"->");
//            head = head.next;
//        }
//        int idx = sb.lastIndexOf("->");
//        if(idx!=-1){
//            sb.delete(idx,idx+2);
//        }
//        sb.append("\n");
//        System.out.println(sb);
//    }

//    private void setTree(TreeNode node,int level,int idx,char[][] treeStr,int maxLevel){
//        if(level+1==maxLevel){
//              int targetIdx =
//                treeStr[level][0] = node.val;
//            }else{
//
//            }
//        }
//    }
}
