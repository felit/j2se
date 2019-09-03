package com.livedrof;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.net.URL;
import java.util.Enumeration;

public class ObjectLayout {
    public static void main(String[] args) throws Exception {
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(A.class).toPrintable());

    }
}

class A {
    boolean f = true;
    ObjectLayout out;

}
//rm -fr ~/.m2/repository/org/openjdk/jol/jol-*
//rm -fr ~/.m2/repository/net/sourceforge/groboutils