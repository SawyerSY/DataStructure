package neusoft.sawyer.learn.linked;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Created by sawyer on 2019-02-01.
 */
public interface LinkedList<E> {

    /**
     * Size int.
     *
     * @return the collection size
     */
    int size();

    /**
     * Add boolean.
     *
     * @param e not null element
     * @throws NullPointerException element is null
     */
    void add(E e);

    /**
     * Add boolean.
     *
     * @param index index at which the specified element is to be inserted
     * @param e     not null element
     * @throws NullPointerException      element is null
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    void add(int index, E e);

    /**
     * Add all boolean.
     *
     * @param c not null element
     * @return return true
     * @throws NullPointerException collection contain null element
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
     * @throws NoSuchElementException linked is empty
     */
    E getFirst();

    /**
     * Gets last.
     *
     * @return the last element
     * @throws NoSuchElementException linked is empty
     */
    E getLast();

    /**
     * Get element by index.
     *
     * @param index the index
     * @return the e
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    E get(int index);

    /**
     * Get the first specified index by element.
     *
     * @param e element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    int indexOf(E e);

    Object[] toArray();
}
