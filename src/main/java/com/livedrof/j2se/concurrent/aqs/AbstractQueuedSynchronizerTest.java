package com.livedrof.j2se.concurrent.aqs;
/**
 * AQS是AbstractQueuedSynchronizer的简称。AQS提供了一种实现阻塞锁和一系列依赖FIFO等待队列的同步器的框架，如下图所示。AQS为一系列同步器依赖于一个单独的原子变量（state）的同步器提供了一个非常有用的基础。子类们必须定义改变state变量的protected方法，这些方法定义了state是如何被获取或释放的。鉴于此，本类中的其他方法执行所有的排队和阻塞机制。子类也可以维护其他的state变量，但是为了保证同步，必须原子地操作这些变量。
 *src/share/vm/prims/unsafe.cpp类
 */

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class AbstractQueuedSynchronizerTest {

}

class A extends AbstractQueuedSynchronizer {

}

class Condition1 extends AbstractQueuedSynchronizer {

}