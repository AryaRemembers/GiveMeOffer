package util;

import data.ListNode;
import data.TreeNode;

import java.util.HashSet;
import java.util.Random;

public class GenDataUtils {

    public static ListNode genNoRepeatValueList(int len){
        ListNode head = new ListNode(6);
        HashSet<Integer> choosen = new HashSet<>();
        ListNode tmp = head;
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            int val = rand.nextInt(len*10);
            while (choosen.contains(val)){
                val = rand.nextInt(len*10);
            }
            tmp = tmp.setNext(new ListNode(val));
            choosen.add(val);
        }
        return head;
    }

    /**
     * generate List according to str [1,2,3,4,5]
     * @param str [1,2,3,4,5]
     * @return head node of the list
     */
    public static ListNode genList(String str){
        String listStr = str.trim().substring(1,str.length()-1);
        if(listStr.length()<1){
            return null;
        }
        String[] treeArr = listStr.split(",");
        ListNode fakeHead = new ListNode(-1);
        ListNode head = fakeHead;
        for (int i = 0; i < treeArr.length; i++) {
            head = head.setNext(new ListNode(Integer.parseInt(treeArr[i])));
        }
        return fakeHead.next;
    }

    public static ListNode genList(int len){
        ListNode fakeHead = new ListNode(-1);
        ListNode head = fakeHead;
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            int val = rand.nextInt(len*10);
            head = head.setNext(new ListNode(val));
        }
        return fakeHead.next;
    }

    /**
     * 生成高度为height，树节点值为【0,100)树
     * @param height
     * @return 树根节点
     */
    public static TreeNode genTree(int height){
        return genTree(height,100);
    }


    /**
     * 生成高度为height，树节点值为【0,100)的满二叉树
     * @param height
     * @return 树根节点
     */
    public static TreeNode genFullTree(int height){
        return genFullTree(height,100);
    }

    private static int setValue(TreeNode root,int hasMax){
        if(root==null) return Math.max(hasMax,1);
        hasMax = setValue(root.left,hasMax);
        root.val = hasMax + 1 + new Random().nextInt(5);
        hasMax = setValue(root.right,root.val);
        return hasMax;
    }

    /**
     * 生成高度为height的二叉搜索树
     * @param height 树高度
     * @return 树根节点
     */
    public static TreeNode genBinarySearchTree(int height){
        TreeNode root = genTree(height);
        setValue(root,1);
        return root;
    }

    /**
     * 生成高度为height的满二叉搜索树
     * @param height 树高度
     * @return 树根节点
     */
    public static TreeNode genFullBinarySearchTree(int height){
        TreeNode root = genFullTree(height);
        setValue(root,1);
        return root;
    }


    /**
     * generate a Tree according to the str
     * @param str []
     * @return root node of the tree
     */
    public static TreeNode genTree(String str){
        if(!str.contains(",")){
            return null;
        }
       String[] treeArr = str.trim().substring(1,str.length()-1).split(",");
       TreeNode root = new TreeNode(Integer.parseInt(treeArr[0]));
       TreeNode[] childs = genTree(treeArr,0);
       root.left = childs[0];
       root.right = childs[1];
       return root;
    }

    private static TreeNode[] genTree(String[] treeStr,int preIdx){
        int left = preIdx*2+1;
        int right = left+1;
        if(left>treeStr.length){
            return new TreeNode[]{null,null};
        }

        TreeNode[] res = new TreeNode[2];
        if(left<treeStr.length&&!treeStr[left].equals("null")){
            TreeNode node = new TreeNode(Integer.parseInt(treeStr[left]));
            TreeNode[] childs = genTree(treeStr,left);
            node.left = childs[0];
            node.right = childs[1];
            res[0] = node;
        }else{
            res[0] = null;
        }

        if(right<treeStr.length&&!treeStr[right].equals("null")){
            TreeNode node = new TreeNode(Integer.parseInt(treeStr[right]));
            TreeNode[] childs = genTree(treeStr,right);
            node.left = childs[0];
            node.right = childs[1];
            res[1] = node;
        }else {
            res[1] = null;
        }

        return res;
    }

    public static TreeNode genTree(int height,int maxNumExclude){
        TreeNode head = new TreeNode(new Random().nextInt(maxNumExclude));
        genTree(head,1,height,maxNumExclude,false);
        return head;
    }

    public static TreeNode genFullTree(int height,int maxNumExclude){
        TreeNode head = new TreeNode(new Random().nextInt(maxNumExclude));
        genTree(head,1,height,maxNumExclude,true);
        return head;
    }

    private static void genTree(TreeNode node,int curLevel,int height,int maxNum,boolean fullTree){
        if(curLevel==height){
            return;
        }
        Random rand = new Random();
        int gen = rand.nextInt(4);
        if(fullTree){
            gen += 2;
        }

        switch (gen){
            case 0:{
                int val = rand.nextInt(maxNum);
                node.left = new TreeNode(val);
                genTree(node.left,curLevel+1,height,maxNum,fullTree);
                break;
            }
            case 1:{
                int val = rand.nextInt(maxNum);
                node.right = new TreeNode(val);
                genTree(node.right,curLevel+1,height,maxNum,fullTree);
                break;
            }
            default:{
                int val = rand.nextInt(maxNum);
                node.left = new TreeNode(val);
                genTree(node.left,curLevel+1,height,maxNum,fullTree);

                val = rand.nextInt(maxNum);
                node.right = new TreeNode(val);
                genTree(node.right,curLevel+1,height,maxNum,fullTree);
                break;
            }
        }
    }



}
