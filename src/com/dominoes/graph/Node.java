package com.dominoes.graph;

import java.util.*;

/**
 * Created by vlad on 12/25/15.
 */
public class Node implements Comparable {

    private int value;

    private Set<Route> routes = new HashSet<>();

    Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public List<Route> getRoutes() {
        List<Route> res = new ArrayList<>();
        for (Route r : routes) {
            if (r.hasSameValues()) {
                res.add(0, r);
            } else {
                res.add(r);
            }
        }
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.value == ((Node) obj).value);
    }

    @Override
    public int hashCode() {
        return 31 * value;
    }

    @Override
    public int compareTo(Object o) {
        if (this.value == ((Node) o).value)
            return 0;
        else if (this.value < ((Node) o).value)
            return -1;
        else
            return 1;
    }
}
