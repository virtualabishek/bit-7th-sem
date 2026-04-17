public class DaemonVsUserDemo {

    public static void main(String[] args) throws InterruptedException {

        // ── DAEMON THREAD ────────────────────────────────────────────────────
        // This thread runs forever but is a daemon — JVM will kill it
        Thread daemonThread = new Thread(() -> {
            int count = 0;
            while (true) {
                count++;
                System.out.println("[Daemon] Heartbeat #" + count);
                try { Thread.sleep(500); } catch (InterruptedException e) { break; }
            }
            // This line will NEVER print — JVM kills daemon without cleanup
            System.out.println("[Daemon] Cleanup done."); // ← NEVER REACHED
        }, "DaemonHeartbeat");
        daemonThread.setDaemon(true); // ← Must be before start()

        // ── USER THREAD ──────────────────────────────────────────────────────
        // JVM MUST wait for this to finish before exiting
        Thread userThread = new Thread(() -> {
            System.out.println("[User] Starting 3-second task...");
            try { Thread.sleep(3000); } catch (InterruptedException e) {}
            System.out.println("[User] Task complete. Exiting.");
            // After this, no more user threads → JVM will exit
        }, "UserWorker");

        daemonThread.start();
        userThread.start();

        // Main thread exits here — but JVM stays alive because userThread is running
        System.out.println("[Main] Main thread exiting now.");
        // After this line, main thread (a user thread) is done.
        // JVM keeps running because userThread is still alive.
        // When userThread finishes at ~3s, JVM kills DaemonHeartbeat mid-beat and exits.
    }
}