public class TreeNode {
    private Point value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Point value) {
        this.value = value;
    }

    public Point getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
