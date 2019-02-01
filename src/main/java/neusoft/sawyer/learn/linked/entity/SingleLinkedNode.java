package neusoft.sawyer.learn.linked.entity;

import java.io.Serializable;

/**
 * Created by sawyer on 2019-02-01.
 */
public class SingleLinkedNode implements Serializable {

    private int data;

    private SingleLinkedNode node;

    public SingleLinkedNode(int data, SingleLinkedNode node) {
        this.data = data;
        this.node = node;
    }

    public int getData() {
        return data;
    }

    public SingleLinkedNode getNode() {
        return node;
    }
}
