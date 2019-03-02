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
    