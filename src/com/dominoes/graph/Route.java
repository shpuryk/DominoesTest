package com.dominoes.graph;

/**
 * Created by vlad on 12/25/15.
 */
public class Route {
    private Node node1;
    private Node node2;

    Route(Node node1, Node node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

    public Node getSecondNode(Node node) {
        return node1.equals(node) ? node2 : node1;
    }

    public boolean hasSameValues () {
        return node1.equals(node2);
    }

    @Override
    public boolean equals(Object obj) {
        Route nObj = (Route) obj;
        return ((this.node1.equals(nObj.node1) && this.node2.equals(nObj.node2)) ||
                (this.node1.equals(nObj.node2) && this.node2.equals(nObj.node1)));
    }

    @Override
    public String toString() {
        return node1.getValue() + "" + node2.getValue() + " ";
    }
}
