package com.livedrof.algs.graph.direct;

import java.util.*;

public class Vertex<T> {
    T key;
    Edge<T> edge;

    public Vertex(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public List<String> getEdgeKeys() {
        List<String> keys = new LinkedList<>();
        Edge<T> edge = this.edge;
        while (edge != null) {
            keys.add(edge.getFirst().getKey()+"->"+edge.getLast().getKey());
            edge = edge.next;
        }
        return keys;
    }

}
