package BinarySearchTrees;

public class PrintInRange extends Basic{

    public static void printInRange(Node root,int k1,int k2){
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left,k1,k2);
            System.out.print(root.data + " ");
            printInRange(root.right,k1,k2);
        } else if (root.data < k1) {
            printInRange(root.left,k1,k2);
        }
        else {
            printInRange(root.right,k1,k2);
        }
    }

    public static void main(String[] args) {
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for (int i : values) {
            root = insert(root, i);
        }
        inorder(root);
        System.out.println();
        printInRange(root,5,12);
    }
}
