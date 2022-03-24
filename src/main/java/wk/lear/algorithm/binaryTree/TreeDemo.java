package wk.lear.algorithm.binaryTree;

import java.util.Stack;

/**
 *         1
 *     2       3
 *   4       9   5
 *     6
 *   7   8
 */
public class TreeDemo {

    public static void main(String[] args) {
        // 初始化二叉树
        TreeNode tree=initTree();
        print(tree);
    }

    // 前序，中序，后续 排序   递归
    public static void print( TreeNode tree){

        System.out.print("前序递归排序：");
        proPrint(tree);
        System.out.println();
        System.out.print("前置排序：");
        proPrintR(tree);
        System.out.println();

        System.out.print("中序递归排序：");
        midPrint(tree);
        System.out.println();
        System.out.print("中序排序：");
        minPrintR(tree);
        System.out.println();
        System.out.print("后序递归排序：");
        endPrint(tree);
        System.out.println();
        endPrintR(tree);


    }
    static void endPrintR(TreeNode root){
        TreeNode node =root;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode  lastRightStack=root;
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            node =stack.peek();
            if(node.right==null||node.right==lastRightStack){
                System.out.print(node.data + " ");
                stack.pop();
                lastRightStack=node;
                node=null;
            }else{
                node=node.right;
            }

        }
    }
    static void minPrintR(TreeNode  root){
        TreeNode node =root;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            if(!stack.isEmpty()){
                node=stack.pop();
                System.out.print(node.data + " ");
                node=node.right;
            }
        }
    }

    static void  proPrintR(TreeNode root){
        TreeNode node=root;
        Stack<TreeNode> stack=new Stack<TreeNode>();

        while(null!=node||!stack.isEmpty()){
            while(node!=null) {
                System.out.print(node.data+" ");
                stack.push(node);
                node=node.left;
            }
            if(!stack.isEmpty()){
                node=stack.pop();
                node=node.right;
            }
        }


    }

    static void proPrint(TreeNode<Integer> node){
        if(node ==null) return;
        else{
            System.out.print((node.getData())+" ");
            proPrint(node.left);
            proPrint(node.right);
        }
    }
    static void midPrint(TreeNode<Integer> node){
        if(node ==null) return;
        else{

            midPrint(node.left);
            System.out.print((node.getData())+" ");
            midPrint(node.right);
        }
    }

    static void endPrint(TreeNode<Integer> node){
        if(node ==null) return;
        else{

            endPrint(node.left);
            endPrint(node.right);
            System.out.print((node.getData())+" ");
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
