package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Queue.DoublyEnded.LinkedDeque;
import Queue.Interface.Queue;
import Tree.BTNode;

public class BinaryTree<T> {
    private BTNode<T> root;
    private static int idx = -1;

    public BinaryTree() {
        root = null;
    }

    public void buildTree(List<T> preorder) {
        root = buildTreeInternal(preorder);
        idx = -1;
    }

    public List<T> inorder() {
        List<T> nodes = new ArrayList<>();
        if (root == null) return nodes;
        inorder(root, nodes);
        return nodes;
    }

    public List<T> postorder() {
        List<T> nodes = new ArrayList<>();
        if (root == null) return nodes;
        postorder(root, nodes);
        return nodes;
    }

    public List<T> preorder() {
        List<T> nodes = new ArrayList<>();
        if (root == null) return nodes;
        preorder(root, nodes);
        return nodes;
    }

    public List<T> levelorder() throws Exception {
        List<T> nodes = new ArrayList<>();
        if (root == null) return nodes;
        Queue<BTNode<T>> queue = new LinkedDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                BTNode<T> curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
                nodes.add(curr.val);
            }
        }
        return nodes;
    }

    public List<List<T>> levelorderWithLevel() throws Exception {
        List<List<T>> level = new ArrayList<>();
        if (root == null) return level;
        Queue<BTNode<T>> queue = new LinkedDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<T> nodes = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                BTNode<T> curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
                nodes.add(curr.val);
            }
            level.add(nodes);
        }
        return level;
    }

    public List<List<T>> zigzagLevelorder() throws Exception {
        List<List<T>> level = new ArrayList<>();
        if (root == null) return level;
        boolean left = true;
        Queue<BTNode<T>> queue = new LinkedDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<T> nodes = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                BTNode<T> curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
                nodes.add(curr.val);
            }
            if (!left) {
                Collections.reverse(nodes);
            }
            level.add(nodes);
            left = !left;
        }
        return level;
    }

    public int countNodes() {
        return countNodes(root);
    }

    public int height() {
        return height(root);
    }

    public int diameter() {
        diameter(root);
        return diam;
    }

    private static int diam = 0;
    private int diameter(BTNode<T> root) {
        if (root == null) return 0;
        int left = diameter(root.left);
        int right = diameter(root.right);
        diam = Math.max(diam, left + right);
        return 1 + Math.max(left, right);
    }

    private int countNodes(BTNode<T> root) {
        if (root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }

    private int height(BTNode<T> root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    private BTNode<T> buildTreeInternal(List<T> preorder) {
        idx += 1;
        if (
            (preorder.get(idx) instanceof Integer && (Integer) preorder.get(idx) == -1) ||
            (preorder.get(idx) == null)
        ) return null;
        BTNode<T> node = new BTNode<T>(preorder.get(idx));
        node.left = buildTreeInternal(preorder);
        node.right = buildTreeInternal(preorder);
        return node;
    }

    private void inorder(BTNode<T> root, List<T> nodes) {
        if (root == null) return;
        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }

    private void postorder(BTNode<T> root, List<T> nodes) {
        if (root == null) return;
        postorder(root.left, nodes);
        postorder(root.right, nodes);
        nodes.add(root.val);
    }

    private void preorder(BTNode<T> root, List<T> nodes) {
        if (root == null) return;
        nodes.add(root.val);
        preorder(root.left, nodes);
        preorder(root.right, nodes);
    }
}
