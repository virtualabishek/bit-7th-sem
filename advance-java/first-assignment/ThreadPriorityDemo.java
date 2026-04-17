public class ThreadPriorityDemo {
    public static void main(String[] args) throws InterruptedException {

        // Java priority range: 1 (MIN) to 10 (MAX), default 5 (NORM)
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++)
                System.out.println("[T1 - priority 2] count = " + i);
        }, "T1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++)
                System.out.println("[T2 - priority 5] count = " + i);
        }, "T2");

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 5; i++)
                System.out.println("[T3 - priority 8] count = " + i);
        }, "T3");

        t1.setPriority(2);  // Low
        t2.setPriority(5);  // Normal (Thread.NORM_PRIORITY)
        t3.setPriority(8);  // High

        // Threads start in priority order here, but scheduling is OS-dependent
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("\nAll threads finished.");
        System.out.println("Note: On modern JVMs with many CPUs, all 3 may run simultaneously!");
    }
}