package neusoft.sawyer.learn.linked;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Created by sawyer on 2019-02-01.
 */
public class SinglyLinkedList<E> implements LinkedList<E> {

    // region 成员变量

    private transient int size = 0;

    private transient SinglyLinkedList.Node<E> first;

    private transient SinglyLinkedList.Node<E> last;

    // endregion


    // region 实体

    private static class Node<E> {
        E item;
        SinglyLinkedList.Node<E> next;

        Node(E element, SinglyLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    // endregion


    // region 构造方法

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(Collection<? extends E> c) {
        this.addAll(c);
    }

    // endregion


    // region 公共方法

    @Override
    public int size() {
        return this.size;
    }

    public void add(E e) {
        if (Objects.isNull(e)) {
            throw new NullPointerException();
        }
        this.linkLast(e);
    }

    @Override
    public void add(int index, E e) {
        if (Objects.isNull(e)) {
            throw new NullPointerException();
        }
        this.checkPositionIndex(index);

        if (Objects.equals(size, index)) {
            this.linkLast(e);
        } else {
            Node<E> pre = Objects.equals(0, index) ? null : this.node(index - 1);
            Node<E> succ = Objects.equals(0, index) ? this.first : this.node(index);
            this.linkBefore(e, pre, succ);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        c.forEach(this::add);
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

    @Override
    public E get(int index) {
        this.checkElementIndex(index);
        return this.node(index).item;
    }

    @Override
    public int indexOf(E e) {
        if (Objects.isNull(e)) {
            throw new NullPointerException();
        }

        int index = 0;
        for (Node<E> x = this.first; Objects.nonNull(x); x = x.next) {
            if (Objects.equals(e, x.item)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arrays = new Object[this.size];
        int index = 0;
        for (Node<E> x = this.first; Objects.nonNull(x); x = x.next) {
            arrays[index++] = x.item;
        }
        return arrays;
    }

    // endregion


    // region 方法重写

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (Node<E> x = this.first; Objects.nonNull(x); x = x.next) {
            sb.append(x.item.toString());
            if (!Objects.isNull(x.next)) {
                sb.append(',').append(' ');
            }
        }
        sb.append(']');
        return sb.toString();
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

    /**
     * Inserts element e before non-null Node succ.
     */
    private void linkBefore(E e, Node<E> pre, Node<E> succ) {
        // assert succ != null;
        Node<E> newNode = new Node<>(e, succ);
        if (Objects.isNull(pre)) {
            this.first = newNode;
        } else {
            pre.next = newNode;
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

    /**
     * Returns the (non-null) Node at the specified element index.
     */
    private Node<E> node(int index) {
        // assert isElementIndex(index);
        Node<E> x = this.first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    private void checkElementIndex(int index) {
        if (!this.isElementIndex(index)) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(index));
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private void checkPositionIndex(int index) {
        if (!this.isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(index));
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    // endregion
}
