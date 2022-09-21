package solution.offer;

import data.TreeNode;
import util.GenDataUtils;
import util.PrintUtils;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/hPov7L/

public class Offer044 {

    public static void main(String[] args) {
        TreeNode root = GenDataUtils.genTree(3);
        PrintUtils.printTreeNode(root);
        List<Integer> res = largestValues(root);
        for (int val:res){
            System.out.println(val);
        }
    }

    public static List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> maxValueOfLevel = new ArrayList<>();
        largestValues(root,0,maxValueOfLevel);
        return maxValueOfLevel;
    }

    public static void largestValues(TreeNode root,int curLevel,ArrayList<Integer> res) {
        if(root==null){
            return;
        }
        if(res.size()<=curLevel){
            res.add(root.val);
        }else{
            int preMax = res.get(curLevel);
            if(root.val>preMax){
                res.set(curLevel,root.val);
            }
        }
        largestValues(root.left,curLevel+1,res);
        largestValues(root.right,curLevel+1,res);
    }


}
