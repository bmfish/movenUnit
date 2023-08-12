package wk.lear.algorithm.binaryTree;

/**
 *         1
 *     2       3
 *   4       9   5
 *     6
 *   7   8
 */
public class 二叉树打印 {

    public static void main(String[] args) {
        // 初始化二叉树
        TreeNode tree=initTree();
        midPrint(tree);
        System.out.println();
    }


    private  static void proPrint(TreeNode treeNode){
      if(null==treeNode){
          return;
      }
        System.out.println(treeNode.getData()+" ");
        proPrint(treeNode.left);
        proPrint(treeNode.right);
    }

    private static void midPrint(TreeNode treeNode){
        if(null==treeNode){
            return;
        }
        midPrint(treeNode.getLeft());
        midPrint(treeNode.getRight());
        System.out.print(treeNode.getData()+" ");
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
