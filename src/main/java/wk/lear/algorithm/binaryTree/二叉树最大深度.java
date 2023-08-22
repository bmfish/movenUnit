package wk.lear.algorithm.binaryTree;

public class 二叉树最大深度 {
    private static int currentHigh=0;

    private static int currentVal;

    public static void main(String[] args) {
        int high=0;
        TreeNode root=  initTree();
        treeDepth(root,high);
        System.out.println(currentVal);
    }

    private static void treeDepth(TreeNode root,int high){
        if(root ==null){
            return ;
        }
        high++;
        treeDepth(root.left,high);
        treeDepth(root.right,high);
        if(high>currentHigh){
            currentHigh=high;
            currentVal= (int) root.getData();
            System.out.println(root.getData());
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
