package neusoft.sawyer.learn.linked;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Created by sawyer on 2019-02-01.
 */
public class SingleLinked<E> implements Linked<E> {

    // region 成员变量

    private transient int size = 0;

    private transient SingleLinked.Node<E> first;

    private transient SingleLinked.Node<E> last;

    // endregion


    // region 实体

    private static class Node<E> {
        E item;
        SingleLinked.Node<E> next;

        Node(E element, SingleLinked.Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    // endregion


    // region 构造方法

    public SingleLinked() {
    }

    // endregion


    // region 公共方法


    @Override
    public int size() {
        return this.size;
    }

    public boolean add(E e) {
        if (Objects.isNull(e)) {
            throw new NullPointerException();
        }
        this.linkLast(e);
        return true;
    }

    public boolean remove(E e) {
        if (Objects.isNull(e)) {
            return false;
        }
        for (Node<E> x = this.first; Objects.nonNull(x); x = x.next) {
            if (Objects.equals(x.item, e)) {
                this.unlink(x);
                return true;
            }
        }

        return false;
    }

    public void clear() {
        for (Node<E> x = this.first; Objects.nonNull(x); ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    public E getFirst() {
        final Node<E> first = this.first;
        if (Objects.isNull(first)) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    public E getLast() {
        final Node<E> last = this.last;
        if (Objects.isNull(last)) {
            throw new NoSuchElementException();
        }
        return last.item;
    }

    // endregion


    // region 私有方法

    private void linkLast(E e) {
        final Node<E> last = this.last;
        final Node<E> newNode = new Node<>(e, null);
        this.last = newNode;
        if (Objects.isNull(last)) {
            this.first = newNode;
        } else {
            last.next = newNode;
        }
        this.size++;
    }

    private E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        if (Objects.isNull(next)) {
            this.last = null;
        }
        if (Objects.equals(x, this.first)) {
            this.first = first.next;
        }
        x.item = null;

        this.size--;
        return element;
    }

    // endregion
}
