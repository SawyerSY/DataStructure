package neusoft.sawyer.learn.tree;

import neusoft.sawyer.learn.exception.OutOfCapacityException;
import neusoft.sawyer.learn.linked.SinglyLinkedList;

/**
 * Created by sawyer on 2019-02-11.
 * <p>
 * 孩子表示法
 */
public class CTree<E> implements Tree<E> {

    // region 静态常量

    private static final int DEFAULT_CAPACITY = 2 << 10;

    private static final CTNode[] EMPTY_ELEMENT_DATA = new CTNode[0];

    // endregion


    // region 成员变量

    private transient CTNode<E>[] nodes;
    private transient int capacity = 0;

    // endregion


    // region 实体

    private static class CTNode<E> {
        E item;
        SinglyLinkedList<E> children;

        CTNode(E item, E... children) {
            this.item = item;
            this.children = new SinglyLinkedList<>(children);
        }

        @Override
        public String toString() {
            return "element: " +
                    this.item +
                    ", children: " +
                    this.children;
        }
    }

    // endregion


    // region 构造方法

    @SuppressWarnings("unchecked")
    public CTree() {
        this.nodes = new CTNode[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    @SuppressWarnings("unchecked")
    public CTree(int initialCapacity) {
        if (initialCapacity > 0) {
            this.nodes = new CTNode[initialCapacity];
        } else if (initialCapacity == 0) {
            this.nodes = EMPTY_ELEMENT_DATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.capacity = initialCapacity;
    }

    // endregion


    // region 公共方法


    @Override
    @SuppressWarnings("unchecked")
    public void create(E[] elements, int[][] children) {
        this.checkCapacity(elements.length);
        for (int i = 0; i < elements.length; i++) {
            int[] childrenIndex = children[i];
            Object[] childrenElement = new Object[childrenIndex.length];
            for (int childIndex = 0; childIndex < childrenIndex.length; childIndex++) {
                childrenElement[childIndex] = elements[childrenIndex[childIndex]];
            }
            this.nodes[i] = new CTNode(elements[i], childrenElement);
        }
    }

    @Override
    public int size() {
        return this.nodes.length;
    }

    @Override
    public int degree() {
        return 0;
    }

    @Override
    public int depth() {
        return 0;
    }

    @Override
    public boolean insertChildren(E parent, E[] children) {
        return false;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E getRoot() {
        return this.nodes[0].item;
    }

    @Override
    public E[] getChildren(E e) {
        return null;
    }

    @Override
    public E getParent(E e) {
        return null;
    }

    @Override
    public int depthOf(E e) {
        return 0;
    }

    // endregion


    // region 方法重写

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (CTNode<E> node : this.nodes) {
            sb.append('{');
            sb.append(node);
            sb.append('}');
            sb.append(',');
            sb.append('\n');
        }
        return sb.toString();
    }


    // endregion


    // region 私有调用

    private void checkCapacity(int targetCapacity) {
        if (targetCapacity > this.capacity) {
            throw new OutOfCapacityException(this.capacity, targetCapacity);
        }
    }

    // endregion
}
