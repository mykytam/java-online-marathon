package softserve.sprint12;

// serve method should initialize x field with applied its first parameter to the second one. And the method should print the messages only about its own actions.
// consume method should wait until serve initializes x field and then change x by assigning it the result of applying the method's first parameter to the second and the third ones.
// This method also prints the messages only about its own actions. Assume that consume() should be able to execute without serve() after waiting for 3 seconds.
// Use synchronized blocks (or methods), wait() and notify() methods for the implementation.

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

class threadExample {
    public static void threadRun() {

        Interactor interactor = new Interactor();

        Thread t1 = new Thread(() -> {
            try {
                interactor.serve(x -> -x + 4, 11);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                interactor.consume((a, b) -> a + 2 * b, 20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            t2.start();
            t1.start();
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Interactor {

    int x;

    public void serve(UnaryOperator<Integer> uo, int initializer) throws InterruptedException {
        synchronized (this) {
            x = uo.apply(initializer);
            String output = "Serving thread running\n" + "Serving thread initializes the key" + "\nkey = " + x;
            System.out.println(output);
            notify();
        }

    }

    public void consume(BinaryOperator<Integer> bo, int operand2) throws InterruptedException {
        synchronized (this) {
            long start = System.nanoTime();
            wait(3000);
            long time = System.nanoTime() - start;
            String before = "Consuming thread received the key. key = " + x;
            x = bo.apply(x, operand2);
            String after = "\nConsuming thread changed the key. key = " + x;
            String resume = "\nServing thread resumed";
            if (time > 3000000000L) {
                System.out.println(before + after);
            } else {
                System.out.println(before + after + resume);
            }

        }
    }
}