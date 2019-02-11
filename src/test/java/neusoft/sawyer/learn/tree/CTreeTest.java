package neusoft.sawyer.learn.tree;

import org.junit.Test;

/**
 * Created by sawyer on 2019-02-11.
 */
public class CTreeTest {

    @Test
    public void testCreate() {
        int size = 'J' - 'A' + 1;

        Tree<String> tree = new CTree<>();

        String[] elements = new String[size];

        for (int i = 'A'; i <= 'J'; i++) {
            elements[i - 'A'] = String.valueOf((char) i);
        }
        int[][] children = new int[size][0];
        children[0] = new int[]{1, 2};
        children[1] = new int[]{3};
        children[2] = new int[]{4, 5};
        children[3] = new int[]{6, 7, 8};
        children[4] = new int[]{9};
        tree.create(elements, children);

        System.out.println(size);
        System.out.println(tree);
    }
}