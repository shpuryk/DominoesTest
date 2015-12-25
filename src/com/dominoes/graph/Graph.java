package com.dominoes.graph;
import java.util.*;

/**
 * Created by vlad on 12/25/15.
 */
public class Graph {

    private Set<Node> nodes;
    private Set<Route> routes;

    public Node getByValue(int val) {
        for (Node n : nodes) {
            if (n.getValue() == val)
                return n;
        }
        return null;
    }

    public Graph(int[][] model) {
        initNodes(model);
        initRoutes(model);
    }

    private void initNodes(int[][] model) {
        nodes = new HashSet<>();
        for (int i = 0; i < model.length; i++) {
            Node nodeI = new Node(i);
            for (int j = 0; j < model.length; j++) {
                if (model[i][j] == 1) {
                    if (!nodes.contains(nodeI)) {
                        nodes.add(nodeI);
                    }
                    break;
                }
            }
        }
    }

    private void initRoutes(int[][] model) {
        routes = new HashSet<>();
        for (int i = 0; i < model.length; i++) {
            for (int j = i; j < model.length; j++) {
                if (model[i][j] == 1) {
                    Route route = new Route(getByValue(i), getByValue(j));
                    routes.add(route);
                    getByValue(i).addRoute(route);
                    getByValue(j).addRoute(route);
                }
            }
        }
    }


    private ArrayList<Route> maxChain = new ArrayList<>();
    private ArrayList<Route> tmpChain = new ArrayList<>();
    private Map<Route, Boolean> visited = new HashMap<>();

    public ArrayList<Route> getLongestChain() {
        for (Route route : routes) {
            visited.put(route, false);
        }
        for (Node node : nodes) {
            for (Route route : routes) {
                visited.put(route, false);
            }
            depthFirstSearch(node);
        }
        return maxChain;
    }

    void depthFirstSearch(Node node ) {
        for (Route route : node.getRoutes()) {
            if (!visited.get(route)){
                visited.put(route, true);
                tmpChain.add(route);
                if(tmpChain.size() > maxChain.size()) {
                    maxChain = (ArrayList)tmpChain.clone();
                }
                depthFirstSearch(route.getSecondNode(node));
                tmpChain.remove(tmpChain.size()-1);
            }
        }
    }


    public ArrayList<Route> outOfMaxChain() {
        ArrayList<Route> outOfMaxChain = new ArrayList<>(routes);
        for (Route r : maxChain) {
            if (routes.contains(r)) {
                outOfMaxChain.remove(r);
            }
        }
        return outOfMaxChain;
    }
}
