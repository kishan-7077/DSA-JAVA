public class LinkedLists {
    public static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Methods

    public void display() {
        if (head==null) {
            System.out.println("Empty");
            return;
        }
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("Null");
        System.out.println();
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        tail = newNode;
        size++;
    }

    public void add(int data, int idx) {
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }
    
    public void removeFirst() {
        if (size == 0) {
            System.out.println("Empty LL");
            return;
        } else if (size == 1) {
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        size--;
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("Empty LL");
            return;
        } else if (size == 1) {
            head = tail = null;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    public int searchItr(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int searchRec(int key) {
        return helper(head, key);
    }
    
    private int helper(Node head, int key) {
        // Base case
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        // Work
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;
        tail = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthNodeFromEnd(int n) {
        // calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        // if tobe deleted is at first i.e nth
        if (n == sz) {
            head = head.next;
            return;
        }
        // if to be deleted is at nth distance from start
        // to be at that position sz-n+1
        int i = 1;
        Node prev = head;
        while (i < sz - n) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public static void main(String[] args) {
        LinkedLists ll = new LinkedLists();
        ll.addFirst(1);
        ll.addFirst(2);
        // ll.display();
        ll.addLast(3);
        ll.add(4, 1);
        ll.display();
        System.out.println(ll.size);
        ll.removeFirst();
        ll.removeLast();
        ll.reverse();
        ll.display();
        System.out.println(ll.searchRec(4));
        ll.addLast(6);
        ll.addLast(5);
        ll.addLast(3);
        ll.display();
        ll.deleteNthNodeFromEnd(2);
        ll.display();
    }
}
