package BinarySearchTrees;

public class SortedArrayToBalancedBst extends Basic{

    public static Node buildBst(int[] values, int st, int end){
        if(st > end){
            return null;
        }
        int mid = (st + end)/2;
        Node root = new Node(values[mid]);
        root.left = buildBst(values, st,mid-1);
        root.right = buildBst(values,mid+1, end);

        return root;
    }

    public static void main(String[] args) {
        int[] values = {3,5,6,8,10,11,12};
        Node root = buildBst(values,0, values.length-1);
        preorder(root);
    }
}
