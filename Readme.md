线程创建的三个方法：
    1、将类声明为Thread的子类。该子类应重写Thread类的run方法。接下来可以分配并启动<br>该子类的实例。例如，计算大于某一规定值的质数的线程可以写成：<br>
    class PrimeThread extends Thread {<br>
        long minPrime;<br>
        PrimeThread(long minPrime){<br>
            this.minPrime = minPrime;<br>
        }<br>
        public void run(){<br>
            // compute primes larger than minPrime<br>
            ...<br>
        }<br>
    }<br>
    然后，下列代码会创建并启动一个线程：<br>
        PrimeThread p = new PrimeThread(143);<br>
        p.start();<br>
    2、另一种方法是声明实现Runnable接口的类。该类然后实现run方法。然后可以分配该类<br>的实例，再创建Thread时作为一个参数来传递并启动。采用这种风格的同一个例子如下所示：<br>
    class PrimeRun implements Runnable {<br>
        long minPrime;<br>
        PrimeRun(long minPrime) {<br>
            this.minPrime = minPrime;<br>
        }<br>
        public void run() {<br>
            // compute primes larger than minPrime<br>
            ...<br>
        }<br>
    }<br>
    然后下列代码会创建并启动一个线程：<br>
        PrimeRun p = new PrimeRun(143);<br>
        new Thread(p).start();<br>
    #Thread.**currentThread**().getName(); 本类线程返回名字 <br>
    #实现方式的好处 实现了解耦 使得线程和线程任务得到了分离 还有就是资源共享 <br>而继承时资源独享<br>
    #运行方法main()的线程默认就是"main"<br>
    #而新建线程名字默认"Thread-0"、"Thread-1"以此类推<br>
    3、实现Callable接口方法call()<br>
    ##################################################################<br>
    **线程池**<br>
    1、原理  ArrayList<Thread>   Thread t = array.remove(0); add(t);<br>
    2、JDK5后自带线程池  <br>
        Executors:线程池创建工厂类 newFixedThreadPool(int nThreads)<br>
    ##################################################################<br>
    run()方法两个弊端： 无法抛出异常 返回值为void<br>
    所以有个类Callable<V>  --> _V_ call() throws Exception  用法和Runnable一样<br>
    ##################################################################<br>
    线程安全问题   <br>
        当一个线程进入共享数据操作的时候，无论是否休眠，其他线程只能等待 <br>
        使用同步技术 公式：<br>
            synchronized(任意对象){<br>
                线程要操作的共享数据（是一个整体，不一定是某个数据，是run方法中操作共享数据的整体）<br>
            }<br>
           即同步代码块
    <br>
    线程池内的线程数的大小相关的概念有两个，一个是核心池大小，还有最大池大小。<br>
    如果当前的线程个数比核心池个数小，当任务到来，会优先创建一个新的线程并执行任务。<br>
    当已经到达核心池大小，则把任务放入队列，为了资源不被耗尽，队列的最大容量可能也是有上限的，<br>
    如果达到队列上限则考虑继续创建新线程执行任务，如果此刻线程的个数已经到达最大池上限，则考虑把任务丢弃。<br>
    在 java.util.concurrent 包中，提供了 ThreadPoolExecutor 的实现。<br>
    public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue,<br>
    ThreadFactory threadFactory,RejectedExecutionHandler handler) {
    } 
    <br>
    corePoolSize- 核心池大小，既然如前原理部分所述。需要注意的是在初创建线程池时线程不会立即启动，<br>
    直到有任务提交才开始启动线程并逐渐时线程数目达到corePoolSize。若想一开始就创建所有核心线程需调用prestartAllCoreThreads方法。
    <br>
    maximumPoolSize-池中允许的最大线程数。需要注意的是当核心线程满且阻塞队列也满时才会判断当前线程数是否小于最大线程数，并决定是否创建新线程。
    <br>
    keepAliveTime - 当线程数大于核心时，多于的空闲线程最多存活时间
    <br>
    unit - keepAliveTime 参数的时间单位。
    <br>
    workQueue - 当线程数目超过核心线程数时用于保存任务的队列。主要有3种类型的BlockingQueue可供选择：无界队列，有界队列和同步移交。将在下文中详细阐述。从参数中可以看到，此队列仅保存实现Runnable接口的任务。 别看这个参数位置很靠后，但是真的很重要，因为楼主的坑就因这个参数而起，这些细节有必要仔细了解清楚。
    <br>
    threadFactory - 执行程序创建新线程时使用的工厂。
    <br>
    handler - 阻塞队列已满且线程数达到最大值时所采取的饱和策略。java默认提供了4种饱和策略的实现方式：中止、抛弃、抛弃最旧的、调用者运行。将在下文中详细阐述。
    <br>
    ...详见：https://zhuanlan.zhihu.com/p/32867181
    