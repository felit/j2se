package com.livedrof.jvm.object;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.FieldLayout;
import org.openjdk.jol.vm.VM;
import org.openjdk.jol.vm.VirtualMachine;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;

/**
 * /Users/congsl/work/self/weblog-viewer/marketing11/20191022/dljsearch5_20191021_235850.jstack
 */
public class ObjectLayoutExample {
    public static void main(String args[]) {
        Object object = new Object();
        //打印虚拟机的信息
        System.out.println(VM.current().details());
        VirtualMachine vm = VM.current();
//        vm.sizeOf()
        User user = new User();
        ClassLayout layout = ClassLayout.parseInstance(user);
        Set<FieldLayout> fieldLayoutSet = layout.fields();
        Iterator<FieldLayout> it = fieldLayoutSet.iterator();
        while (it.hasNext()) {
            FieldLayout fl = it.next();
            System.out.println(fl.shortFieldName());
            System.out.println(fl.size());
        }
//        Arena arena;
        System.out.println(ClassLayout.parseInstance(user).headerSize());
        System.out.println(ClassLayout.parseInstance(user).instanceSize());

        //打印对象头大小
        System.out.println(ClassLayout.parseInstance(object).headerSize());

        //打印对象大小
        System.out.println(ClassLayout.parseInstance(object).instanceSize());

        //打印对象信息
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
        System.out.println(object.hashCode());
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
        System.out.println(user.hashCode());

    }
}



