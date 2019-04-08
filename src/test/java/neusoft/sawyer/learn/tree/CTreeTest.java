package neusoft.sawyer.learn.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sawyer on 2019-02-11.
 */
public class CTreeTest {

    // region 测试方法

    @Test
    public void create() {
        Tree tree = createTree();
        System.out.println(tree);
    }

    @Test
    public void size() {
        Tree tree = createTree();
        int size = tree.size();
        System.out.println(size);
        Assert.assertEquals('K' - 'A' + 1, size);
    }

    @Test
    public void degree() {
        Tree tree = this.createTree();
        int degree = tree.degree();
        System.out.println(degree);
        Assert.assertEquals(3, degree);
    }

    @Test
    public void depth() {
        Tree<String> tree = this.createTree();
        int depth = tree.depth();
        System.out.println(depth);
        Assert.assertEquals(5, depth);
    }

    @Test
    public void insertChildren() {
        Tree<String> tree = this.createTree();
        System.out.println(tree.insertChildren("K", new String[]{"L", "M"}));
        System.out.println(tree);
        Assert.assertEquals('K' - 'A' + 3, tree.size());
    }

    @Test
    public void remove() {
        Tree<String> tree = this.createTree();
        System.out.println(tree.remove("D"));
        System.out.println(tree.remove("Z"));
        int size = tree.size();
        System.out.println(tree);
        System.out.println(size);
        Assert.assertEquals(6, size);
    }

    @Test
    public void clear() {
        Tree<String> tree = this.createTree();
        tree.clear();
        System.out.println(tree);
    }

    @Test
    public void getRoot() {
        Tree<String> tree = this.createTree();
        System.out.println(tree.getRoot());
    }

    @Test
    public void getChildren() {
        Tree<String> tree = this.createTree();
        System.out.println(Arrays.toString(tree.getChildren("D")));
        System.out.println(Arrays.toString(tree.getChildren("Z")));
    }

    @Test
    public void indexOf() {
        Tree<String> tree = this.createTree();
        System.out.println(tree.indexOf("K"));
    }

    @Test
    public void get() {
        Tree<String> tree = this.createTree();
        System.out.println(tree.get(10));
    }

    @Test
    public void getParent() {
        Tree<String> tree = this.createTree();
        System.out.println(tree.getParent(10));
    }

    @Test
    public void depthOf() {
        Tree<String> tree = this.createTree();
        System.out.println(tree.depthOf("K"));
        System.out.println(tree.depthOf("A"));
        System.out.println(tree.depthOf("Z"));
    }

    @Test
    public void contains() {
        Tree<String> tree = this.createTree();
        System.out.println(tree.contains("A"));
    }

    @Test
    public void getPath() {
        Tree<String> tree = this.createTree();
        System.out.println(Arrays.toString(tree.getPath()));
    }

    @Test
    public void getLeafCount() {
        Tree<String> tree = this.createTree();
        System.out.println(tree.getLeafNode());
    }

    // endregion


    // region 私有方法

    private Tree<String> createTree() {
        char begin = 'A';
        char end = 'K';

        int size = end - begin + 1;

        String[] elements = new String[size];
        for (int i = begin; i <= end; i++) {
            elements[i - begin] = String.valueOf((char) i);
        }

        int[][] children = new int[size][0];
        children[0] = new int[]{1, 2};
        children[1] = new int[]{3};
        children[2] = new int[]{4, 5};
        children[3] = new int[]{6, 7, 8};
        children[4] = new int[]{9};
        children[6] = new int[]{10};

        return new CTree<>(elements, children);
    }

    // endregion
}