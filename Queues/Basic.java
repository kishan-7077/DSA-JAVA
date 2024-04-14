package Queues;

public class Basic {
    static class QueueUsingArray{
        static int[] arr;
        static int size;
        static int rear;

        QueueUsingArray(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public  boolean isEmpty(){
            return rear == -1;
        }

        //add
        public  void add(int data){
            if(rear==size-1){
                System.out.println("Queue is Full");
                return;
            }

            rear = rear+1;
            arr[rear] = data;
        }

        //remove
        public  int remove(){ //O(n)
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            int front = arr[0];
            for(int i=0;i<rear;i++){
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }

        //peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return arr[0];
        }
    }


    static class CircularQueueUsingArray{
        static int[] arr;
        static int front;
        static int rear;
        static int size;

        CircularQueueUsingArray(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public boolean isEmpty(){
            return rear==-1 && front==-1;
        }

        public boolean isFull(){
            return (rear+1)%size==front;
        }

        //add
        public void add(int data){
            if(isFull()){
                System.out.println("Queue is Full");
                return;
            }
            if(front==-1){ // add a first element
                front=0;
            }
            rear = (rear+1)%size;
            arr[rear] = data;
        }

        //remove
        public int remove(){ //O(1)
            if (isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }

            int result = arr[front];
            // last delete
            if(rear==front){
                rear=front=-1;
            }else {
                front = (front+1) % size;
            }
            return result;
        }

        //peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return arr[front];
        }

    }


    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class QueueUsingLinkedLists{
        static Node head=null;
        static Node tail=null;

        public boolean isEmpty(){
            return head==null && tail==null;
        }

        //add
        public void add(int data){
            Node newNode = new Node(data);
            if(head==null){
                head=tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }

        //remove
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }

            int front = head.data;
            if(tail==head){
                tail=head=null;
            }else {
                head=head.next;
            }
            return front;
        }

        //peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }

            return head.data;
        }
    }

    public static void main(String[] args) {
        QueueUsingArray q = new QueueUsingArray(5);
        q.add(1);
        q.add(2);
        q.add(3);

//        while (!q.isEmpty()){
//            System.out.println(q.peek());
//            q.remove();
//        }

        CircularQueueUsingArray cq = new CircularQueueUsingArray(3);
        cq.add(1);
        cq.add(2);
        cq.add(3);
//        System.out.println(cq.remove());
//        cq.add(4);
//        System.out.println(cq.remove());
//        cq.add(5);

//        while (!cq.isEmpty()){
//            System.out.println(cq.peek());
//            cq.remove();
//        }


        QueueUsingLinkedLists qll = new QueueUsingLinkedLists();
        qll.add(1);
        qll.add(2);
        qll.add(3);

        while (!qll.isEmpty()){
            System.out.println(qll.peek());
            qll.remove();
        }

    }
}
