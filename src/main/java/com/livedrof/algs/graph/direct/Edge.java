package com.livedrof.algs.graph.direct;

import java.util.Arrays;

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

    @Override
    protected Edge<T> clone() {
        return new Edge<>(this.vertex[0], this.vertex[1]);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "weight=" + weight +
                ", vertex=" + vertex[0].getKey() + "," + vertex[1].getKey() +
                ", next=" + next +
                '}';
    }
}
