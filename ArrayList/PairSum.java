import java.util.ArrayList;

public class PairSum { //Provided Sorted List

    public static boolean pairsum1(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean pairsum1TwoPointer(ArrayList<Integer> list, int target) {
        int lp = 0, rp = list.size() - 1;
        while (lp <= rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    public static boolean pairsum2(ArrayList<Integer> list, int target) { // Contains Sorted And Rotated
        // Twopointer
        int bp = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }
        // assign pointers
        int lp = bp + 1, rp = bp;
        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % list.size();
            } else {
                rp = (list.size() + rp - 1) % list.size();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        // 1,2,3,4,5,6
        // for (int i = 1; i < 7; i++) {
        //     list.add(i);
        // }
        // 11,15,6,8,9,10
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println(pairsum2(list, target));
    }
}
