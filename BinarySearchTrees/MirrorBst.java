package BinarySearchTrees;

public class MirrorBst extends Basic{

    public static Node mirror(Node root){

        if (root==null){
            return null;
        }

        Node leftS = mirror(root.left);
        Node rightS = mirror(root.right);
        root.left = rightS;
        root.right = leftS;
        return root;
    }

    public static void main(String[] args) {
        int[] values = {8,5,10,3,6,11};
        Node root = null;

        for (int i : values) {
            root = insert(root, i);
        }
        inorder(root);
        System.out.println();
        mirror(root);
        preorder(root);
    }
}
