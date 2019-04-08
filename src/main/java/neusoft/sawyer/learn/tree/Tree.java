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
     * @return the max children count
     */
    int degree();

    /**
     * Tree Depth.
     *
     * @return the max depth size
     */
    int depth();

    /**
     * Insert children to specified parent.
     *
     * @param parent   the parent, if there are multiple, insert to the first
     * @param children the children
     * @return if not exists specified parent, return false
     */
    boolean insertChildren(E parent, E[] children);

    /**
     * Remove element, if there are multiple, insert to the first.
     *
     * @param e specified element
     * @return if not exists specified parent, return false
     */
    boolean remove(E e);

    /**
     * Clear tree.
     */
    void clear();

    /**
     * Gets root.
     *
     * @return the root element
     */
    E getRoot();

    /**
     * Return specified element children index arr.
     *
     * @param e specified element
     * @return if not exists the element, return empty arr
     */
    int[] getChildren(E e);

    /**
     * Get specified element index.
     *
     * @param e element
     * @return first found element index, if not exists element, return -1
     */
    int indexOf(E e);

    /**
     * Get element.
     *
     * @param index specified index
     * @return the first found
     * @throws IndexOutOfBoundsException index is out of bounds
     */
    E get(int index);

    /**
     * Get parent.
     *
     * @param index the index
     * @return if root index, return -1
     * @throws IndexOutOfBoundsException index is out of bounds
     */
    int getParent(int index);

    /**
     * Root to element depth.
     *
     * @param e the element's depth
     * @return if not exists return -1
     */
    int depthOf(E e);

    /**
     * Contains boolean.
     *
     * @param e the e
     */
    boolean contains(E e);

    /**
     * Get leaf node to root path arr.
     *
     * @return the path
     */
    List<Integer>[] getPath();

    /**
     * Gets leaf node.
     *
     * @return the leaf node
     */
    List<Integer> getLeafNode();
}
