package BinarySearchTrees;

import java.util.ArrayList;

public class Merge2Bst extends Basic{

    public static void getInorder(Node root,ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        getInorder(root.left,arr);
        arr.add(root.data);
        getInorder(root.right,arr);
    }

    public static Node createBst(ArrayList<Integer> arr, int st,int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBst(arr,st,mid-1);
        root.right = createBst(arr,mid+1,end);

        return root;
    }

    public static Node mergeBst(Node root1,Node root2){
        //step1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1,arr1);

        // step 2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2,arr2);

        // step 3 -> merge
        int i=0,j=0;
        ArrayList<Integer> ansArr = new ArrayList<>();
        while (i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                ansArr.add(arr1.get(i));
                i++;
            }else {
                ansArr.add(arr2.get(j));
                j++;
            }
        }

        while (i<arr1.size()){
            ansArr.add(arr1.get(i));
            i++;
        }
        while (j<arr2.size()){
            ansArr.add(arr2.get(j));
            j++;
        }

        // sorted Al -> balanced bst
        return createBst(ansArr,0,ansArr.size()-1);
    }

    public static void main(String[] args) {
        Node bst1 = new Node(2);
        bst1.left = new Node(1);
        bst1.right = new Node(4);

        Node bst2 = new Node(9);
        bst2.left = new Node(3);
        bst2.right = new Node(12);

        Node root = mergeBst(bst1,bst2);
        preorder(root);

    }
}
