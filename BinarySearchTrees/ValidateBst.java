package BinarySearchTrees;

public class ValidateBst extends Basic{

    public static boolean isValidBst(Node root, Node min,Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }

        return isValidBst(root.left,min,root) && isValidBst(root.right,root,max);
    }

    public static void main(String[] args) {
        int[] values = {1,1,1};
        Node root = null;

        for (int i : values) {
            root = insert(root, i);
        }
        inorder(root);
        System.out.println(isValidBst(root,null,null));
    }
}
