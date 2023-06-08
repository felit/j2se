package com.livedrof.algs.graph.direct;

public interface EachCallback<T> {
    void execute(Vertex<T> vertex);

    void execute(Edge<T> edge);
}
