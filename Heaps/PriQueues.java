package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriQueues {

    static class Student implements Comparable<Student> {   // Overriding
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        pq.add(5);  // O(log n)
//        pq.add(1);
//        pq.add(2);
//        while (!pq.isEmpty()){
//            System.out.println(pq.remove());
//        }


        PriorityQueue<Student> pqObj = new PriorityQueue<>(Comparator.reverseOrder());
        pqObj.add(new Student("A",4));
        pqObj.add(new Student("C",5));
        pqObj.add(new Student("B",1));
        pqObj.add(new Student("D",14));

        while (!pqObj.isEmpty()){
            System.out.println(pqObj.peek().name + " " + pqObj.peek().rank);
            pqObj.remove();
        }

    }
}
