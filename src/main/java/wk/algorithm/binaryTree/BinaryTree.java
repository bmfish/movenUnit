package wk.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> {
    private TreeNode<E> root;

    public BinaryTree(){
    }

    public BinaryTree(TreeNode<E> root){
        super();
        this.root=root;
    }
    public BinaryTree(E[] elements){
        super();
        this.buildTree(elements);
    }
    private void buildTree(E[] elements){
        if(null==elements||elements.length==0){

        }
        Queue<TreeNode<E>> queue=new LinkedList<TreeNode<E>>();
        TreeNode<E> node=new TreeNode();
        this.root=node;
        for (E element : elements) {
            node.data=element;
            node.left=new TreeNode<E>();
            node.right=new TreeNode<E>();
            queue.offer(node.left);
            queue.offer(node.right);
            node=queue.poll();
        }
    }
}
