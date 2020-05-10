package softserve.sprint12;

// Please, fix the problem with the preloaded implementation of the class MyThread.
// Test starts both threads with the code: MyThreads.t1.start(); MyThreads.t2.start();
// The goal of each thread is to update fields m and n and not switch between threads while in the loop.

class MyThreads {
    public static final Object den = new Object();
    public static final Object ada = new Object();

    public static int n;
    public static int m;

    public static Thread t1 = new Thread() {
        @Override
        public void run() {
            synchronized (ada) {
                for (int i = 0; i < 5; i++, n++)
                    System.out.println("Thread1 n = " + n);
                Thread.yield();
            }
            synchronized (den) {
                try {
                    den.wait(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < 5; i++, m++)
                    System.out.println("Thread1 m = " + m);
                System.out.println("Thread1 success!");
            }
        }
    };

    public static Thread t2 = new Thread() {
        @Override
        public void run() {
            synchronized (ada) {
                for (int i = 0; i < 5; i++, m++)
                    System.out.println("Thread2 m = " + m);
                Thread.yield();
            }
            synchronized (den) {
                for (int i = 0; i < 5; i++, n++)
                    System.out.println("Thread2 n = " + n);
                System.out.println("Thread2 success!");
                den.notifyAll();
            }
        }
    };


    public static void main(String[] args) {
        MyThreads.t1.start();
        MyThreads.t2.start();
    }
}