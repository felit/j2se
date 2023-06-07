package com.livedrof.algs.graph.direct;

public class    Vertex<T> {
    T  key;
    Edge<T> edge;

    public Vertex(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }
}
