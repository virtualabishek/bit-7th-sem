import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ThreadQn {

    static final Object io_locked = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread workerThread = new Thread(() -> {
            System.out.println("Starting run()...");
            // ── PHASE 1: Simulate I/O with a synchronized block ──────────────
            // The thread will try to acquire io_locked.
            // If another thread holds it → state goes RUNNABLE → BLOCKED
            System.out.println("Requesting i/o lock");
            synchronized (io_locked) {
                System.out.println("Lock acquired! Performing file I/O");
                try {
                    Files.writeString(
                            Path.of("output.txt"), "Thread I/O data written at: " + System.currentTimeMillis()
                    );
                    System.out.println("File write complete");
                } catch (IOException e) {
                    System.out.println("I/O error: " + e.getMessage());
                }
            }
            // lock released here.
            // sleep for 2 sec.
            System.err.println("Going to sleep for 2 sec.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted! ");
                Thread.currentThread().interrupt();
            }
            System.out.println("Woke up, finishing run()");
            // state becomes runnable then terminated
        });

        // ── OBSERVER: Monitor thread states from main thread ─────────────────
        Thread observer = new Thread(() -> {
            while (true) {
                Thread.State state = workerThread.getState();
                System.err.println("Worker State: " + state);
                if (state == Thread.State.TERMINATED) break;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }, "ObserverThread");

        // ── PRINT STATE: NEW ──────────────────────────────────────────────────
        System.out.println("Before start() → State: " + workerThread.getState()); // NEW

        observer.setDaemon(true);
        observer.start();

        // Hold the io_locked briefly so workerThread hits BLOCKED state
        synchronized (io_locked) {
            workerThread.start(); // ← NEW → RUNNABLE
            System.out.println("Lock held by main. Worker will BLOCK...");
            Thread.sleep(500); // Hold for 500ms so BLOCKED state is visible
        } // Lock released → Worker can proceed

        workerThread.join(); // Wait for worker to finish
        System.out.println("Worker finished → Final state: " + workerThread.getState()); // TERMINATED
    }
}
