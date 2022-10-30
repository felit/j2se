package com.livedrof.j2se.resource;

//import sun.misc.URLClassPath;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassloaderPath {
    public static void main(String args[]) throws IOException {
//        URLClassPath path = sun.misc.Launcher.getBootstrapClassPath();
        /**
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home/jre/lib/resources.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home/jre/lib/rt.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home/jre/lib/sunrsasign.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home/jre/lib/jsse.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home/jre/lib/jce.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home/jre/lib/charsets.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home/jre/lib/jfr.jar
         * /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home/jre/classes
         */
//        for (URL uri : path.getURLs()) {
//            System.out.println(uri.getPath());
//        }
//
//        ClassLoader cld = ClassloaderPath.class.getClassLoader();
//        ClassLoader tmp = cld;
//        while (tmp != null) {
//            System.out.println(tmp);
//            tmp = tmp.getParent();
//        }
//        Enumeration<URL> url = cld.getResources("hello.properties");
//        while (url.hasMoreElements()) {
//            System.out.println(url.nextElement());
//        }
    }
}
