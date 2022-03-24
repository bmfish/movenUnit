package wk.lear.algorithm.binaryTree;

import java.util.Stack;

/**
 *         1
 *     2       3
 *   4       9   5
 *     6
 *   7   8
 */
public class TreeDemoRe {

    public static void main(String[] args) {
        TreeNode tree=initTree();
        endPrintR(tree);

    }
    public static void endPrintR(TreeNode tree){
        Stack<TreeNode> stack =new Stack<TreeNode>();
        TreeNode node =tree;
        TreeNode lastPrintNode=tree;
        while(!stack.isEmpty()||node!=null){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            node =stack.peek();
            if(node.right==null||node.right==lastPrintNode){
                System.out.print(node.data+ " ");
                stack.pop();
                lastPrintNode=node;
                node=null;
            }else{
                node=node.right;
            }
        }
    }

     public static void prePrintR(TreeNode tree){
        Stack<TreeNode> stack =new Stack<TreeNode>();
        TreeNode node =tree;
        while(!stack.isEmpty()||node!=null){
            while(node!=null){

                stack.push(node);
                node=node.left;
            }
            if(!stack.isEmpty()){
                node =stack.pop();
                System.out.print(node.data+ " ");
                node=node.right;
            }
        }
     }
     public  static void endPrint(TreeNode tree){
        if(null==tree) return;
         endPrint(tree.left);
         endPrint(tree.right);
         System.out.print(tree.data+" ");
     }
     public static void midPrint(TreeNode tree){
        if(null!=tree){
            midPrint(tree.left);
            System.out.print(tree.data+" ");
            midPrint(tree.right);
        }
     }
     public  static void prePrint(TreeNode tree){
        if(null!=tree) {
            System.out.println(tree.data);
            prePrint(tree.left);
            prePrint(tree.right);
        }
     }
    /**
     *
     */
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
