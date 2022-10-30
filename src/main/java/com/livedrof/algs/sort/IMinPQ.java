package com.livedrof.algs.sort;

/**
 * 最小优先队列，抽象数据结构；时间、空间复杂度。
 */
public interface IMinPQ<Key> {
    void insert(Key v);

    Key delMax();

    Key max();

    boolean isEmpty();

    int size();
}
