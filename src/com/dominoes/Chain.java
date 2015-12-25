package com.dominoes;

import com.dominoes.graph.Route;

import java.util.*;

/**
 * Created by vlad on 12/25/15.
 */
public class Chain {

    private List<Tile> tiles;

    public Chain(ArrayList<Route> routes) {
        tiles = new LinkedList<>();
        for (Route r : routes) {
            tiles.add(new Tile(r.getNode1().getValue(), r.getNode2().getValue()));
        }
    }

    public void normaize() {
        Tile prev = null;
        for (Tile t : tiles) {
            if (prev != null && prev.getSecond() != t.getFirst()) {
                t.revert();
            }
            prev = t;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (Tile t : tiles) {
            str.append(t + " ");
        }
        str.append("]");
        return str.toString();
    }
}
