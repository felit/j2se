package com.livedrof.algs.graph.direct;

public class Edge<T> {
    int weight;
    Vertex[] vertex;
    Edge<T> next;

    public Edge(Vertex<T> v1, Vertex<T> v2) {
        this.vertex = new Vertex[]{v1, v2};
    }

    public Vertex<T> getLast() {
        return vertex[1];
    }

    public Vertex<T> getFirst() {
        return vertex[0];
    }

}
