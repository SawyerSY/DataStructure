package neusoft.sawyer.learn.tree;

import java.util.*;

/**
 * Created by sawyer on 2019-02-11.
 * <p>
 * 孩子表示法
 */
public class CTree<E> implements Tree<E> {

    // region 静态常量

    private static final int DEFAULT_CAPACITY = 2 << 5;

    // endregion


    // region 成员变量

    private List<CTNode<E>> nodeList;

    // endregion


    // region 实体

    private static class CTNode<E> {
        E item;
        List<Integer> children;

        CTNode(E item, int[] children) {
            this.item = item;
            this.children = new LinkedList<>();
            for (Integer child : children) {
                this.children.add(child);
            }
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

    public CTree() {
        this.nodeList = new ArrayList<>(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public CTree(E[] es, int[][] children) {
        this.nodeList = new ArrayList<>(es.length);
        for (int i = 0; i < es.length; i++) {
            this.nodeList.add(new CTNode(es[i], children[i]));
        }
    }

    // endregion


    // region 公共方法


    @Override
    public int size() {
        return this.nodeList.size();
    }

    @Override
    public int degree() {
        int maxDegree = 0;
        for (CTNode<E> node : this.nodeList) {
            maxDegree = Math.max(maxDegree, node.children.size());
        }
        return maxDegree;
    }

    @Override
    public int depth() {
        int max = 0;
        for (List<Integer> path : this.getPath()) {
            max = Math.max(max, path.size());
        }
        return max;
    }

    @Override
    public boolean insertChildren(E parent, E[] children) {
        int index = this.indexOf(parent);
        if (0 > index || Objects.isNull(children) || Objects.equals(0, children.length)) {
            return false;
        }

        for (E child : children) {
            this.nodeList.add(new CTNode<>(child, new int[]{}));
        }
        int[] childrenIndexes = new int[children.length];
        for (int i = 0; i < children.length; i++) {
            childrenIndexes[children.length - i - 1] = this.nodeList.size() - i - 1;
        }
        for (int childrenIndex : childrenIndexes) {
            this.nodeList.get(index).children.add(childrenIndex);
        }

        return true;
    }

    @Override
    public boolean remove(E e) {
        int index = this.indexOf(e);
        if (0 > index) {
            return false;
        }
        if (Objects.equals(0, index)) {
            this.clear();
            return true;
        }

        List<E> elementList = new ArrayList<>();
        elementList.add(e);
        List<Integer> descList = this.getDesc(index);
        descList.forEach(descIndex -> elementList.add(get(descIndex)));
        this.nodeList.removeIf(node -> elementList.contains(node.item));

        int parent = this.getParent(index);
        CTNode<E> parentNode = this.nodeList.get(parent);
        parentNode.children.removeIf(child -> Objects.equals(index, child));

        return true;
    }

    @Override
    public void clear() {
        this.nodeList.clear();
    }

    @Override
    public E getRoot() {
        return this.nodeList.get(0).item;
    }

    @Override
    public int[] getChildren(E e) {
        if (!this.contains(e)) {
            return new int[]{};
        }
        int index = this.indexOf(e);
        List<Integer> children = this.nodeList.get(index).children;
        int[] childrenIndexes = new int[children.size()];
        for (int i = 0; i < children.size(); i++) {
            childrenIndexes[i] = children.get(i);
        }
        return childrenIndexes;
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < nodeList.size(); i++) {
            if (Objects.equals(e, nodeList.get(i).item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        this.checkIndex(index);
        return this.nodeList.get(index).item;
    }

    @Override
    public int getParent(int index) {
        this.checkIndex(index);

        if (Objects.equals(0, index)) {
            return -1;
        }

        for (int i = 0; i < this.nodeList.size(); i++) {
            List<Integer> children = this.nodeList.get(i).children;
            for (Integer child : children) {
                if (Objects.equals(index, child)) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int depthOf(E e) {
        int index = this.indexOf(e);
        if (0 > index) {
            return -1;
        }
        return this.getParentPath(index).size() + 1;
    }

    @Override
    public boolean contains(E e) {
        return this.indexOf(e) >= 0;
    }

    @SuppressWarnings("unchecked")
    public List<Integer>[] getPath() {
        List<Integer> leafNodeIndexList = this.getLeafNode();
        List[] paths = new ArrayList[leafNodeIndexList.size()];
        for (int i = 0; i < leafNodeIndexList.size(); i++) {
            int leafNode = leafNodeIndexList.get(i);
            List<Integer> path = this.getParentPath(leafNode);
            Collections.reverse(path);
            path.add(leafNode);
            paths[i] = path;
        }
        return paths;
    }

    @Override
    public List<Integer> getLeafNode() {
        List<Integer> leafNodeList = new ArrayList<>();
        for (int i = 0; i < this.nodeList.size(); i++) {
            if (Objects.equals(0, this.nodeList.get(i).children.size())) {
                leafNodeList.add(i);
            }
        }
        return leafNodeList;
    }

    // endregion


    // region 方法重写

    @Override
    public String toString() {
        if (this.nodeList.isEmpty()) {
            return "The tree is empty.";
        }

        StringBuilder sb = new StringBuilder();
        this.nodeList.forEach(node -> {
            sb.append('{');
            sb.append(node);
            sb.append('}');
            sb.append(',');
            sb.append('\n');
        });
        return sb.toString();
    }


    // endregion


    // region 私有调用

    private List<Integer> getDesc(int index) {
        List<Integer> descList = new ArrayList<>();
        CTNode<E> node = this.nodeList.get(index);
        if (Objects.equals(0, node.children.size())) {
            return descList;
        } else {
            for (int i = 0; i < node.children.size(); i++) {
                int child = node.children.get(i);
                descList.add(child);
                descList.addAll(getDesc(child));
            }
        }
        return descList;
    }

    private List<Integer> getParentPath(int index) {
        List<Integer> path = new ArrayList<>();
        int parent = this.getParent(index);
        if (Objects.equals(-1, parent)) {
            return path;
        } else {
            path.add(parent);
            path.addAll(getParentPath(parent));
        }
        return path;
    }

    private void checkIndex(int index) {
        if (!this.isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < this.nodeList.size();
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + this.nodeList.size();
    }

    // endregion
}
