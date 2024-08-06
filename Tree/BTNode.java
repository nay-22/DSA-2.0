package Tree;

public class BTNode<T> {
    public T val;
    public BTNode<T> left;
    public BTNode<T> right;

    public BTNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
