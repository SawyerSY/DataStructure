package neusoft.sawyer.learn.linked;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sawyer on 2019-02-01.
 */
public class SingleLinkedTest {

    @Test
    public void test() {
        Linked<Integer> linked = new SingleLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        System.out.println(linked.size());
        System.out.println(linked.getFirst());
        System.out.println(linked.getLast());
        System.out.println(linked.remove(5));
        System.out.println(linked.remove(1));
        System.out.println(linked.getFirst());
        System.out.println(linked.getLast());
        System.out.println(linked.size());
        linked.clear();
        System.out.println(linked.size());
    }

    @Test
    public void test1() {
        Linked<Integer> linked = new SingleLinked<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(linked.size());
        System.out.println(linked.getFirst());
        System.out.println(linked.getLast());
    }
}
