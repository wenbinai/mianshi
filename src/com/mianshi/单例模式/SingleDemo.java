package com.mianshi.单例模式;

public class SingleDemo {
    /**
     * 为什么使用volatile?
     * 指令重排, 内存可见性, 不能保证原子性
     * new 分为三大步:
     * 1. 分配内存
     * 2. 初始化intance
     * 3. 将instance指向内存地址
     * <p>
     * JVM存在指令重排, 1 3 2, 线程T1 执行了1, 3,
     * 此时线程T2调用getInstance()
     * 发现了不为空, 但是此时的instance 还没有初始化
     */
    private volatile static SingleDemo instance;

    private SingleDemo() {
    }

    public static SingleDemo getInstance() {
        // 第一次判断可以减少锁竞争的情况, 提高了并发的效率
        if (instance == null) {
            synchronized (SingleDemo.class) {
                // 线程A, B都通过了第一次判断, A创建完后,
                // B进去不判断的话, 又创建了一个, 不符合单例
                if (instance == null) {
                    instance = new SingleDemo();
                }
            }
        }
        return instance;
    }
}
