package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BTRunner {
    public static void main(String[] args) throws Exception {
        List<Integer> nodes = new ArrayList<>(List.of(1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1));
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.buildTree(nodes);
        System.out.println(tree.inorder());
        System.out.println(tree.preorder());
        System.out.println(tree.postorder());
        System.out.println(tree.levelorder());
        System.out.println(tree.levelorderWithLevel());
        System.out.println(tree.zigzagLevelorder());
        System.out.println(tree.countNodes());
        System.out.println(tree.height());
        System.out.println(tree.diameter());
    }
}
