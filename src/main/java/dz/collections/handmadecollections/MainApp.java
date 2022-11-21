package dz.collections.handmadecollections;

import dz.collections.handmadecollections.handMadeList.HandMadeLinkedList;
import dz.collections.handmadecollections.handmadearray.HandMadeArrayList;
import dz.collections.handmadecollections.handmadearray.HumanTest;

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {

       // HandMadeArrayList<HumanTest> test = new HandMadeArrayList();
        HandMadeLinkedList<HumanTest> test = new HandMadeLinkedList<>();
        test.add(new HumanTest("bob1",20,"m"));
        test.add(new HumanTest("bob2",22,"m"));

        System.out.println(test.get(0));
        System.out.println(test.get(1));
        System.out.println(test.size());
        test.clean();
        System.out.println(test.size());



    }
}
