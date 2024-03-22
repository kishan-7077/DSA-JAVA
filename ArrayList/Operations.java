import java.util.ArrayList;

public class Operations {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // add operation - O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.add(2, 69);

        System.out.println(list);

        // get operation - O(1)
        int element = list.get(2);
        System.out.println(element);

        // delete element - O(n)
        list.remove(2);
        System.out.println(list);

        // set - O(n)
        list.set(2, 10);
        System.out.println(list);

        // contains - O(n)
        System.out.println(list.contains(10));
        System.out.println(list.contains(33));
    }
}
