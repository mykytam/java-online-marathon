package softserve.sprint12;

// You need to create Accountant class with a static method sum that takes 2 int parameters and returns their sum.
// The sum must be evaluated in a separate thread (please, do not call run() method of ParallelCalculator.
// Use start() on Thread object). Use ParallelCalculator for this. Method sum doesn't throw any checked exceptions.
// Using Thread.sleep() is unwelcomed in this task.

class Accountant extends Thread {

    public static int sum(int x, int y) {
        ParallelCalculator target = new ParallelCalculator(Integer::sum, x, y);
        Thread thread = new Thread(target);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return target.result;
    }

    public static void main(String[] args) {

    }
}



