##4. 实例锁 和 全局锁
实例锁 -- 锁在某一个实例对象上。如果该类是单例，那么该锁也具有全局锁的概念。
               实例锁对应的就是synchronized关键字。
全局锁 -- 该锁针对的是类，无论实例多少个对象，那么线程都共享该锁。
               全局锁对应的就是static synchronized（或者是锁在该类的class或者classloader对象上）。

关于“实例锁”和“全局锁”有一个很形象的例子：

pulbic class Something {
    public synchronized void isSyncA(){}
    public synchronized void isSyncB(){}
    public static synchronized void cSyncA(){}
    public static synchronized void cSyncB(){}
}
假设，Something有两个实例x和y。分析下面4组表达式获取的锁的情况。
(01) x.isSyncA()与x.isSyncB() 
(02) x.isSyncA()与y.isSyncA()
(03) x.cSyncA()与y.cSyncB()
(04) x.isSyncA()与Something.cSyncA()