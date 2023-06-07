package com.livedrof.algs.graph.direct;

import java.util.*;

public class Graph<T> {
    int verNum;
    int edgeNum;
    List<Vertex> verArr = new LinkedList<>();
    Map<T, Vertex<T>> vertexIndex=new HashMap<>();

    public void addVertex(Vertex<T> v) {
        verArr.add(v);
        vertexIndex.put(v.getKey(), v);
    }

    public Vertex<T> getVertex(T key) {
        return this.vertexIndex.get(key);
    }

    public void addEdge(Edge<T> edge) {
        Vertex<T> vertex = this.vertexIndex.get(edge.getFirst().getKey());
        this.addEdge(vertex, edge);
        this.addEdge(this.vertexIndex.get(edge.getLast().getKey()), edge);
    }

    private void addEdge(Vertex<T> vertex, Edge<T> edge) {
        Edge<T> endEdge = vertex.edge;
        if (endEdge == null) {
            vertex.edge = edge;
        } else {
            while (endEdge.next == null) {
                endEdge.next = edge;
            }
        }
    }

    public static void main(String args[]) {
        Graph<String> graph = new Graph<>();
        String[] vertex = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        for (String ss : vertex) {
            graph.addVertex(new Vertex(ss));
        }
        Map<String, String> edge = new HashMap<>();
        edge.put("A", "G");
        edge.put("A", "E");
        edge.put("B", "F");
        edge.put("C", "L");
        edge.put("B", "D");
        edge.put("E", "G");
        edge.put("G", "K");
        edge.put("G", "H");
        edge.put("G", "I");
        edge.put("C", "G");
        edge.put("C", "J");
        edge.put("C", "I");
        edge.forEach((k, v) -> {
            graph.addEdge(new Edge<>(graph.getVertex(k), graph.getVertex(v)));
        });
    }
}
