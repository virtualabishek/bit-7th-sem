
public class EvenOdd {

    // ─── APPROACH 1: Extend Thread ──────────────────────────────────────────
    static class EvenThread extends Thread {

        public EvenThread() {
            super("EvenThread"); // set thread name
        }

        @Override
        public void run() {
            for (int i = 2; i <= 20; i += 2) {
                System.out.println(Thread.currentThread().getName() + " Even: " + i);
                // Small sleep to make interleaving visible (remove to see raw racing)
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // ─── APPROACH 2: Implement Runnable (preferred) ─────────────────────────
    static class OddTask implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 19; i += 2) {
                System.out.println(Thread.currentThread().getName() + " Odd:  " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // System.out.println("=== Starting Even/Odd Thread Demo ===\n");

        Thread evenThread = new EvenThread();               // Approach 1
        Thread oddThread = new Thread(new OddTask(), "OddThread"); // Approach 2

        evenThread.start(); // JVM calls run() in a new thread
        oddThread.start();

        // Wait for both to complete before printing summary
        evenThread.join();
        oddThread.join();

        // System.out.println("\n=== Both threads completed ===");
    }
}
/* 
The output varies because: the OS thread scheduler uses time-slicing — each thread gets a short CPU burst (a "quantum"), then it's paused and the other thread may run. There is no guaranteed ordering between independent threads. The JVM has no control over which thread the CPU picks next. The sleep(10) call forces a context switch at each step, making the interleaving very visible. Without sleep(), one thread may fully complete before the other even starts, because the first start() call may get the full CPU before the second thread is even initialized by the JVM.
*/
