package JavaBasics.Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueUsingStacks {

    static class QueueUsing2Stacks{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty(){
            return s1.isEmpty();
        }

        //add
        public void add(int data){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        //remove
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }

            return s1.pop();
        }

        //peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return s1.peek();
        }
    }

    static class StackUsing2Queues{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else {
                q2.add(data);
            }
        }

        public int pop(){
            if(isEmpty()){
                System.out.println("Empty stack");
                return -1;
            }
            int top=-1;

            //case1
            if(!q1.isEmpty()){
                while ((!q1.isEmpty())){
                    top=q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }else { //case2
                while (!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Empty stack");
                return -1;
            }
            int top=-1;

            //case1
            if(!q1.isEmpty()){
                while ((!q1.isEmpty())){
                    top=q1.remove();
                    q2.add(top);
                }
            }else { //case2
                while (!q2.isEmpty()){
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }


    public static void main(String[] args) {
        StackUsing2Queues q = new StackUsing2Queues();
        q.push(1);
        q.push(2);
        q.push(3);

        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.pop();
        }
    }
}
