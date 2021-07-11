package wk.algorithm.binaryTree;

public class TreeNode<E> {

    public E data; //数据结点
    public TreeNode<E> left; //指向左子树
    public TreeNode<E> right; //指向右子树
    public TreeNode() {
    }
    public TreeNode(E data) {
        super();
        this.data=data;
    }
    public TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }
}
