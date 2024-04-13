package Stacks;

import java.util.ArrayList;

public class Basic {

    public static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();

        public  boolean isEmpty(){
            return list.size() == 0;
        }

        // push
        public  void push(int data){
            list.add(data);
        }

        //pop
        public int pop(){
            if(list.isEmpty()){
                System.out.println("Stack is Empty");
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        //peek
        public  int peek(){
            if(list.isEmpty()){
                System.out.println("Stack is Empty");
                return -1;
            }
            return list.get(list.size()-1);
        }

        //print Stack
        public void display(Stack s){
            while (!s.isEmpty()){
                System.out.print(s.peek() + " ");
                s.pop();
            }
        }
    }


    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static class StackUsingLL{
        static Node head = null;

        public boolean isEmpty(){
            return head==null;
        }

        public void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
            }
            newNode.next = head;
            head = newNode;
        }

        public int pop(){
            if(head == null){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek(){
            if(head == null){
                return -1;
            }
            return head.data;
        }

        public void display(StackUsingLL s){
            if(head==null){
                System.out.println("empty Stack");
                while (s.isEmpty()){
                    System.out.print(s.peek()+" ");
                    s.pop();
                }
            }
        }
    }

    public static void main(String[] args){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        s.display(s);

        StackUsingLL sLL = new StackUsingLL();
        sLL.push(1);
        sLL.push(2);
        sLL.push(3);

        sLL.display(sLL);
    }
}