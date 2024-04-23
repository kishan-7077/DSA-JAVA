package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class KthLevel extends Basic{

    public static void kLevelItr(Node root,int level){
        // level order
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int count=1;
        while (!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                count++;
                if(q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }
            }else {
                if (count==level){
                    System.out.print(currNode.data+ " ");
                }
                if (currNode.left!=null){
                    q.add(currNode.left);
                }
                if (currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void kLevelRec(Node root, int level, int k){
        if (root==null){
            return;
        }
        if (level==k){
            System.out.print(root.data+" ");
            return;
        }
        kLevelRec(root.left,level+1,k);
        kLevelRec(root.right,level+1,k);
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

        kLevelItr(root,3);
        kLevelRec(root,1,3);
    }
}
