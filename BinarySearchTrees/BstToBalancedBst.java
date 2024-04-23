package BinarySearchTrees;

import java.util.ArrayList;

public class BstToBalancedBst extends Basic{

    public static void inorderList(Node root, ArrayList<Integer> values){
        if(root == null){
            return;
        }
        inorderList(root.left,values);
        values.add(root.data);
        inorderList(root.right,values);
    }

    public static Node createBST(ArrayList<Integer> inorder,int st,int end){
        if(st>end){
            return null;
        }

        int mid = (st+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder,st,mid-1);
        root.right = createBST(inorder,mid+1,end);
        return root;
    }

    public static Node balancedBst(Node root){
        // inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderList(root,inorder);
        // sorted inorder
        root = createBST(inorder,0,inorder.size()-1);

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = balancedBst(root);
        preorder(root);


    }
}
