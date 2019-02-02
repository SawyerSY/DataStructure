package neusoft.sawyer.learn.linked;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sawyer on 2019-02-01.
 */
public class SinglyLinkedListTest {

    @Test
    public void test1() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println(linkedList.size());
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.remove(5));
        System.out.println(linkedList.remove(1));
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.size());
        linkedList.clear();
        System.out.println(linkedList.size());
    }

    @Test
    public void test2() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(linkedList.size());
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
    }

    @Test
    public void test3() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(linkedList.get(4));
        System.out.println(linkedList.indexOf(5));
        System.out.println(linkedList.indexOf(10));
        System.out.println(linkedList.get(5));
    }

    @Test
    public void test4() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        linkedList.add(0, 0);
        linkedList.add(6, 6);
        System.out.println(linkedList);
    }

    @Test
    public void test5() {
        LinkedList<Integer> linkedList = new SinglyLinkedList<>();
        System.out.println(linkedList);
    }
}
