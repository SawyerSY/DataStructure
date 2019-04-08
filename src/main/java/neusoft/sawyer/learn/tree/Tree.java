package neusoft.sawyer.learn.tree;

import java.util.List;

/**
 * Created by sawyer on 2019-02-11.
 *
 * @param <E> the type parameter
 */
public interface Tree<E> {

    /**
     * Node total.
     *
     * @return the int
     */
    int size();

    /**
     * Tree degree.
     *
     * @return the int
     */
    int degree();

    /**
     * Tree Depth.
     *
     * @return the int
     */
    int depth();

    /**
     * Insert children to specified parent.
     *
     * @param parent   the parent, if there are multiple, insert to the first.
     * @param children the children.
     * @return if not exists specified parent, return false.
     */
    boolean insertChildren(E parent, E[] children);

    /**
     * Remove element, if there are multiple, insert to the first.
     *
     * @param e specified element
     * @return if not exists specified parent, return false.
     */
    boolean remove(E e);

    /**
     * Clear tree.
     */
    void clear();

    /**
     * Gets root.
     *
     * @return the root element.
     */
    E getRoot();

    /**
     * 返回目标元素的索引
     *
     * @param e parent element.
     * @return the children.
     */
    int[] getChildren(E e);

    /**
     * 获取匹配的元素索引
     *
     * @param index 索引
     * @return 找到一个则返回 ，如果找不到则返回-1
     */
    int indexOf(E index);

    /**
     * Get e.
     *
     * @param index the index
     * @return the e
     */
    E get(int index);

    /**
     * 获取父节点索引
     *
     * @param index the index
     * @return 返回父节点索引 ，Root节点则返回-1
     */
    int getParent(int index);

    /**
     * Depth of element.
     *
     * @param e the element's depth
     * @return the int
     */
    int depthOf(E e);

    /**
     * Contains boolean.
     *
     * @param e the e
     * @return the boolean
     */
    boolean contains(E e);

    /**
     * Get path linked list [ ].
     *
     * @return the linked list [ ]
     */
    List<Integer>[] getPath();

    /**
     * Gets leaf node.
     *
     * @return the leaf node
     */
    List<Integer> getLeafNode();
}
