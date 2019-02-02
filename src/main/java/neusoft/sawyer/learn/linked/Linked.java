package neusoft.sawyer.learn.linked;

import java.util.Collection;

/**
 * Created by sawyer on 2019-02-01.
 *
 * @param <E> the type parameter
 */
public interface Linked<E> {

    /**
     * Size int.
     *
     * @return the int
     */
    int size();

    /**
     * Add boolean.
     *
     * @param e not null element
     * @return return true
     */
    boolean add(E e);

    /**
     * Add all boolean.
     *
     * @param c not null element
     * @return return true
     */
    boolean addAll(Collection<? extends E> c);

    /**
     * Remove boolean.
     *
     * @param e remove element
     * @return if is null, return false. Other return true.
     */
    boolean remove(E e);

    /**
     * clear the linked
     */
    void clear();

    /**
     * Gets first.
     *
     * @return the first element
     */
    E getFirst();

    /**
     * Gets last.
     *
     * @return the last element
     */
    E getLast();
}
