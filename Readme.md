线程创建的三个方法：
    1、将类声明为Thread的子类。该子类应重写Thread类的run方法。接下来可以分配并启动该子类的实例。例如，计算大于某一规定值的质数的线程可以写成：
    class PrimeThread extends Thread {
        long minPrime;
        PrimeThread(long minPrime){
            this.minPrime = minPrime;
        }
        public void run(){
            // compute primes larger than minPrime
            ...
        }
    }
    然后，下列代码会创建并启动一个线程：
        PrimeThread p = new PrimeThread(143);
        p.start();
    2、另一种方法是声明实现Runnable接口的类。该类然后实现run方法。然后可以分配该类的实例，再创建Thread时作为一个参数来传递并启动。采用这种风格的同一个例子如下所示：
    class PrimeRun implements Runnable {
        long minPrime;
        PrimeRun(long minPrime) {
            this.minPrime = minPrime;
        }
        public void run() {
            // compute primes larger than minPrime
            ...
        }
    }
    然后下列代码会创建并启动一个线程：
        PrimeRun p = new PrimeRun(143);
        new Thread(p).start();
    #Thread.**currentThread**().getName(); 本类线程返回名字 
    #实现方式的好处 实现了解耦 使得线程和线程任务得到了分离 还有就是资源共享 而继承时资源独享
    #运行方法main()的线程默认就是"main"
    #而新建线程名字默认"Thread-0"、"Thread-1"以此类推
    3、实现Callable接口方法call()
    ##################################################################
    **线程池**
    1、原理  ArrayList<Thread>   Thread t = array.remove(0); add(t);
    2、JDK5后自带线程池  
        Executors:线程池创建工厂类 newFixedThreadPool(int nThreads)
    ##################################################################
    run()方法两个弊端： 无法抛出异常 返回值为void
    所以有个类Callable<V>  --> _V_ call() throws Exception  用法和Runnable一样