package wk.lear.algorithm.binaryTree;

import java.util.Stack;

/**
 *         1
 *     2       3
 *   4       9   5
 *     6
 *   7   8
 */
public class 二叉树打印2 {

    public static void main(String[] args) {
        // 初始化二叉树
        TreeNode tree=initTree();
        midPrint(tree);
        System.out.println();
    }


    private  static void proPrint(TreeNode treeNode){
        TreeNode root= treeNode;
        Stack<TreeNode> stack =new Stack<>();
        while(null!=treeNode||!stack.isEmpty()){
            while (null!=treeNode) {
                System.out.print(treeNode.getData() +" ");
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
           if(!stack.isEmpty()){
               treeNode=stack.pop();
               treeNode=treeNode.right;
           }
        }
    }

    private static void midPrint(TreeNode treeNode){
        Stack<TreeNode>stack =new Stack<>();
        while (null!=treeNode||!stack.isEmpty()){
            while(null!=treeNode){
                stack.push(treeNode);
                treeNode=treeNode.left;
            }
            if(!stack.isEmpty()){
                treeNode=stack.pop();
                System.out.print(treeNode.getData()+" ");
                treeNode=treeNode.right;
            }
        }
    }

    private static void endPrint(TreeNode root){
        Stack<TreeNode> stack= new Stack<>();
        TreeNode treeNode =root;
        TreeNode lastRightNode=treeNode;
        while (null!=treeNode||!stack.isEmpty()){
            while(null!=treeNode){
                stack.push(treeNode);
                treeNode=treeNode.left;
            }
            treeNode=stack.peek();
            if(treeNode.right==null||treeNode==lastRightNode){
                System.out.println(treeNode.getData());
                lastRightNode=treeNode;
                stack.pop();
                treeNode=null;
            }else{
                treeNode=treeNode.right;
            }

        }
    }
    private  static TreeNode<Integer>initTree(){
        TreeNode<Integer> root=new TreeNode<Integer>();
        root.setData(1);
        TreeNode node4=new TreeNode(4);
        TreeNode node6=new TreeNode(6,new TreeNode(7),new TreeNode(8));
        node4.setRight(node6);
        root.setLeft(new TreeNode<Integer>(2,node4,null));
        root.setRight(new TreeNode<Integer>(3,new TreeNode<Integer>(9),new TreeNode<Integer>(5)) );
       return root;

    }
}
