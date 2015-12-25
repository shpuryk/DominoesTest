package com.dominoes;

import com.dominoes.graph.Graph;
import com.dominoes.graph.Route;

import java.util.*;

/**
 * Created by vlad on 12/25/15.
 */
public class Dominoes {

    private static int MAX_NUMBER = 6;
    private static int SIZE = MAX_NUMBER + 1;
    private int[][] model;

    public int[][] getModel() {
        return model;
    }

    public static int getAllTilesCount() {
        return (MAX_NUMBER + 1) * (MAX_NUMBER + 2) / 2;
    }

    public Dominoes(int n) {
        if (n > getAllTilesCount()) {
            throw new IllegalArgumentException("Number shouldn't be more " + getAllTilesCount());
        } else {
            model = new int[SIZE][SIZE];
            List<Integer> list = new LinkedList<>();
            for (int i = 1; i <= getAllTilesCount(); i++) {
                list.add(i);
            }
            Collections.shuffle(list);
            Iterator<Integer> iterator = list.iterator();
            for (int i = 0; i < SIZE; i++) {
                for (int j = i; j < SIZE; j++) {
                    if (iterator.next() <= n) {
                        model[i][j] = 1;
                        model[j][i] = 1;
                    } else {
                        model[i][j] = 0;
                        model[j][i] = 0;
                    }
                }
            }
        }
    }

    public Chain getLongestChain() {
        Graph graph = new Graph(this.getModel());
        ArrayList<Route> routes = graph.getLongestChain();
        Chain chain = new Chain(routes);
        return chain;
    }

    public Chain[] getLongestChainWithOut() {
        Graph graph = new Graph(this.getModel());
        ArrayList<Route> routes = graph.getLongestChain();
        Chain chain = new Chain(routes);
        Chain out = new Chain(graph.outOfMaxChain());
        return new Chain[]{chain, out};
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < model.length; i++)
            for (int j = 0; j < model.length; j++)
            {
                str.append(model[i][j] + " ");
                if (j == model.length - 1)
                    str.append( "\n");
            }
        return str.toString();
    }

}
