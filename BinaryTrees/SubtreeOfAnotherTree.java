package BinaryTrees;

public class SubtreeOfAnotherTree extends Basic{



    public static boolean checkSubtree(Node root,Node subRoot){

        if(root==null){
            return false;
        }

        if(root.data == subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }

        boolean leftAns = checkSubtree(root.left,subRoot);
        boolean rightAns = checkSubtree(root.right,subRoot);

        return leftAns || rightAns;
    }

    private static boolean isIdentical(Node node, Node subRoot) {
        if(node == null && subRoot == null){
            return true;
        } else if (node==null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if(!isIdentical(node.left,subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right,subRoot.right)){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int[] subTree = {2,4,5};
        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);
        Node subtree = tree.buildTree(subTree);

        System.out.println(checkSubtree(root,subtree));
    }
}
