package BinaryTrees;

public class DiameterOfTree extends Basic{

//    Diameter is no of the longest path between 2 leaves

    public static int diameter1(Node root){      // O(n^2)
        if(root==null){
            return 0;
        }
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        int rootDiameter = (lh+rh)+1;
        int lDiameter = diameter1(root.left);
        int rDiameter = diameter1(root.right);

        return Math.max(rootDiameter,Math.max(lDiameter,rDiameter));
    }

    public static class Info{
        int diameter;
        int height;

        public Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
    public static Info diameter(Node root){
        if(root==null){
            return new Info(0,0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), (leftInfo.height+ rightInfo.height)+1);
        int ht = Math.max(leftInfo.height, rightInfo.height)+1;

        return new Info(diam,ht);
    }


    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);

        System.out.println(diameter1(root));
        System.out.println(diameter(root).diameter);
    }
}
