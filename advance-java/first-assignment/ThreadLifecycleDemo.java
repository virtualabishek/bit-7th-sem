class ThreadLifecycleDemo {
    public static void main(String[] args) throws Exception {

        Thread t = new Thread(() -> {
            try {
                System.out.println("Thread started");

                // Simulate I/O operation
                System.out.println("Performing I/O...");
                Thread.sleep(1000); // simulate delay

                // Sleep for 2 seconds
                System.out.println("Sleeping for 2 seconds...");
                Thread.sleep(2000);

                System.out.println("Thread finished");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("State after creation: " + t.getState());

        t.start();
        System.out.println("State after start: " + t.getState());

        Thread.sleep(500);
        System.out.println("State during execution: " + t.getState());

        Thread.sleep(1500);
        System.out.println("State during sleep: " + t.getState());

        t.join();
        System.out.println("State after completion: " + t.getState());
    }
}