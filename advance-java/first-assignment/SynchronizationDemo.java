public class SynchronizationDemo {

    // ── UNSYNCHRONIZED VERSION ───────────────────────────────────────────────
    static class UnsafeCounter {
        private int count = 0;

        public void increment() {
            // THIS IS 3 CPU STEPS — not atomic!
            // Step 1: READ  count into CPU register
            // Step 2: ADD   1 to register
            // Step 3: WRITE register back to count
            // Another thread can interrupt BETWEEN any of these steps!
            count++;
        }

        public int getCount() { return count; }
    }

    // ── SYNCHRONIZED VERSION ─────────────────────────────────────────────────
    static class SafeCounter {
        private int count = 0;

        // synchronized keyword = only 1 thread can execute this at a time
        // The thread acquires the INTRINSIC LOCK of this object
        public synchronized void increment() {
            count++; // Now atomic from other threads' perspective
        }

        // Also sync the read to get the latest value (visibility guarantee)
        public synchronized int getCount() { return count; }
    }

    // ── ALTERNATIVE: Use AtomicInteger (best practice for counters) ──────────
    // java.util.concurrent.atomic.AtomicInteger — lock-free, hardware-level atomic
    // AtomicInteger atomicCount = new AtomicInteger(0);
    // atomicCount.incrementAndGet(); // Truly atomic CAS operation

    static void runTest(String label, Runnable increment, java.util.function.IntSupplier getCount)
            throws InterruptedException {
        // Reset by re-running fresh instances
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) increment.run();
        }, "T1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) increment.run();
        }, "T2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.printf("%-20s → Final count = %d (expected 2000)%n", label, getCount.getAsInt());
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Two threads, each incrementing 1000 times. Expected = 2000.\n");

        // ── WITHOUT SYNCHRONIZATION ──────────────────────────────────────────
        for (int run = 1; run <= 5; run++) {
            UnsafeCounter unsafe = new UnsafeCounter();
            runTest("Run " + run + " (UNSAFE)", unsafe::increment, unsafe::getCount);
        }

        System.out.println();

        // ── WITH SYNCHRONIZATION ─────────────────────────────────────────────
        for (int run = 1; run <= 5; run++) {
            SafeCounter safe = new SafeCounter();
            runTest("Run " + run + " (SAFE)", safe::increment, safe::getCount);
        }
    }
}