public class ThreadPropertiesDemo {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Thread current = Thread.currentThread();

            // ── Thread ID ───────────────────────────────────────────────────
            // Unique long assigned by JVM. Never reused in same JVM run.
            System.out.println("Thread ID:     " + current.getId());        // e.g. 14

            // ── Thread Name ─────────────────────────────────────────────────
            // Default: "Thread-0", "Thread-1", etc.
            // Always set a meaningful name — invaluable for debugging!
            System.out.println("Thread Name:   " + current.getName());      // MyWorker

            // ── Priority ────────────────────────────────────────────────────
            System.out.println("Priority:      " + current.getPriority());  // 5 (NORM)

            // ── Daemon status ───────────────────────────────────────────────
            System.out.println("Is Daemon:     " + current.isDaemon());     // false

            // ── Thread Group ────────────────────────────────────────────────
            System.out.println("Thread Group:  " + current.getThreadGroup().getName()); // main
        }, "MyWorker");

        // Must set daemon BEFORE start() — cannot change after
        t.setDaemon(false);  // user thread: JVM waits for it
        t.setPriority(Thread.NORM_PRIORITY); // 1(MIN) to 10(MAX), default 5
        t.start();
    }
}