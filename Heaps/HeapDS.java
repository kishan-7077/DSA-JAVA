package Heaps;

import java.util.ArrayList;

public class HeapDS {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void addHeap(int data){  //O(log n)
            // add at last idx
            arr.add(data);

            int x = arr.size()-1;   // Child idx
            int parent = (x-1)/2;   // Parent idx

            while (arr.get(x)<=arr.get(parent)){    //O(log n)
                // swap
                int temp = arr.get(x);
                arr.set(x,arr.get(parent));
                arr.set(parent,temp);

                x=parent;
                parent=(x-1)/2;
            }
        }

        public int peekHeap(){
            return arr.getFirst();
        }

        public int removeHeap(){
            int data = arr.getFirst();

            //step 1 -> swap first and last
            int temp = arr.getFirst();
            arr.set(0,arr.getLast());
            arr.set(arr.size()-1,temp);

            //step 2 -> delete last
            arr.remove(arr.getLast());

            //step 3 -> heapify
            heapify(0);
            return data;
        }

        private void heapify(int i){
            int left = (2*i)+1; // left child
            int right = (2*i)+2; // right child
            int minIdx = i;

            if(left<arr.size() && arr.get(minIdx) > arr.get(left)){
                minIdx=left;
            }
            if(right<arr.size() && arr.get(minIdx)>arr.get(right)){
                minIdx=right;
            }

            if (minIdx != i){
                // swap
                int temp = arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);

                heapify(minIdx);
            }
        }

        public boolean isEmptyHeap(){
            return arr.getLast()==0;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.addHeap(1);
        heap.addHeap(2);
        heap.addHeap(3);

        while (!heap.isEmptyHeap()){
            System.out.println(heap.peekHeap());
            heap.removeHeap();
        }
    }
}
