package JavaBasics.Queues;


import java.util.LinkedList;

public class Deque {
    public static void main(String[] args) {
//        java.util.Deque<Integer> dq = new LinkedList<>();
//        dq.addFirst(1);
//        dq.addFirst(2);
//        dq.addLast(3);
//        dq.addLast(4);
//        System.out.println(dq);
//        dq.removeLast();
//        System.out.println(dq);
//
//        System.out.println("First Ele " + dq.getFirst());
//        System.out.println("First Ele " + dq.getLast());

        QueueUsingDeque s = new QueueUsingDeque();
        s.add(1);
        s.add(2);
        s.add(3);

        System.out.println(s.peek());
        s.remove();
        s.remove();
        System.out.println(s.peek());
    }

    static class StackUsingDeque{
        java.util.Deque<Integer> deque = new LinkedList<>();

        public void push(int data){
            deque.addLast(data);
        }

        public int pop(){
            return deque.removeLast();
        }

        public int peek(){
            return deque.getLast();
        }
    }

    static class QueueUsingDeque{
        java.util.Deque<Integer> deque = new LinkedList<>();

        public void add(int data){
            deque.addLast(data);
        }

        public int remove(){
            return deque.removeFirst();
        }

        public int peek(){
            return deque.getFirst();
        }
    }

}
