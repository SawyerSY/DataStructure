package neusoft.sawyer.learn.tree;

/**
 * Created by sawyer on 2019-02-11.
 *
 * @param <E> the type parameter
 */
public interface Tree<E> {

    void create(E[] elements, int[][] children);

    /**
     * Node total.
     */
    int size();

    /**
     * Tree degree.
     */
    int degree();

    /**
     * Tree Depth.
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
     * Get parent's children.
     *
     * @param e parent element.
     * @return the children.
     */
    E[] getChildren(E e);

    /**
     * Get child's parent.
     *
     * @param e the child element.
     * @return the parent element, if not found element return null.
     */
    E getParent(E e);

    /**
     * Depth of element.
     *
     * @param e the element's depth
     */
    int depthOf(E e);
}
