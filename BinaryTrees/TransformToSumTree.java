package BinaryTrees;

public class TransformToSumTree extends Basic{

    public static int transformSumTree(Node root){
        if(root==null){
            return 0;
        }
        int lChild = transformSumTree(root.left);
        int rChild = transformSumTree(root.right);
        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = newLeft+lChild + newRight+rChild;

        return data;
    }

    public static void main(String[] args) {
//                1
//               / \
//              2   3
//             / \ / \
//            4  5 6  7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transformSumTree(root);
        preorder(root);


    }
}
