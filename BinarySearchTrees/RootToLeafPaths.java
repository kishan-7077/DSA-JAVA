package BinarySearchTrees;

import java.util.ArrayList;

public class RootToLeafPaths extends Basic{
    public static void rootToLeafPaths(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            System.out.println(path);
        }

        rootToLeafPaths(root.left,path);
        rootToLeafPaths(root.right,path);
        path.removeLast();
    }

    public static void main(String[] args) {
        int[] values = {8,5,3,6,10,11,14};
        Node root = null;

        for (int i : values) {
            root = insert(root, i);
        }


        rootToLeafPaths(root,new ArrayList<>());
    }
}
