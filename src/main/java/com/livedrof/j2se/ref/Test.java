package com.livedrof.j2se.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


class VeryBig{
    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;
    public VeryBig(String id) {
        ident = id;
    }
    @Override
    public String toString() {
        return ident;
    }
    protected void finalize() {
        System.out.println("finalize...." + ident);
    }
}

public class Test{
    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();
    public static void checkQueue() {
        Reference<? extends VeryBig> inq = rq.poll();
        if (inq != null) {
            System.out.println("in Queue : " + inq.get());
        }
    }
    public static void main(String[] args) {
        int size = 10;
        System.out.println("--------Soft------------");
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<SoftReference<VeryBig>>();
        for (int i = 0; i < size; ++i) {
            sa.add(new SoftReference<VeryBig>(new VeryBig("soft" + i), rq));
            System.out.println("just created soft: " + sa.getLast().get());
            checkQueue();
        }
        SoftReference<VeryBig> s = new SoftReference<VeryBig>(new VeryBig("soft"));

        System.out.println("--------Weak------------");
        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<WeakReference<VeryBig>>();
        for (int i = 0; i < size; ++i) {
            wa.add(new WeakReference<VeryBig>(new VeryBig("weak" + i), rq));
            System.out.println("just create weak : " + wa.getLast().get());
            checkQueue();
        }
        WeakReference<VeryBig> w = new WeakReference<VeryBig>(new VeryBig("Weak"));

        System.gc();




        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<PhantomReference<VeryBig>>();
        for (int i = 0; i < size; ++i) {
            pa.add(new PhantomReference<VeryBig>(new VeryBig("phantom " + i), rq));
            System.out.println("just create Phantom : " + pa.getLast().get());
            checkQueue();
        }
    }
}