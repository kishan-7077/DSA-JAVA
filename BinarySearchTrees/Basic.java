package BinarySearchTrees;

public class Basic {

    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.right=null;
            this.left=null;
        }
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node insert(Node root,int val){
        if(root==null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            // left subtree
            root.left = insert(root.left,val);
        }else {
            // right subtree
            root.right = insert(root.right,val);
        }

        return root;
    }

    public static boolean search(Node root, int key){
        if(root==null){
            return false;
        }

        if(root.data==key){
            return true;
        }

        if(root.data > key){
            return search(root.left,key);
        }

        else {
            return search(root.right, key);
        }

    }

    public static Node delete(Node root,int val){
        if(root.data<val){
            root.right = delete(root.right,val);
        }
        if(root.data>val){
            root.left = delete(root.left,val);
        }
        else {
            // case 1 - leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            // case 2 - one child
            if(root.left==null){
                return root.right;
            } else if (root.right==null) {
                return root.left;
            }
            //case 3 - both children -> InorderSuccessor = leftmost node in right Subtree
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    private static Node findInorderSuccessor(Node root) {
        while (root.left!=null){
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for (int i : values) {
            root = insert(root, i);
        }
        inorder(root);
//        System.out.println(search(root,2));
        delete(root,3);
        inorder(root);
    }
}
