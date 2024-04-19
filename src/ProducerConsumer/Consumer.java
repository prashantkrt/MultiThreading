package ProducerConsumer;

public class Consumer extends Thread {
    private BufferSharedMemory bufferSharedMemory;

    public Consumer(BufferSharedMemory bufferSharedMemory) {
        this.bufferSharedMemory = bufferSharedMemory;
    }

    public void run() {
        while (true) {
            try {
                int value = bufferSharedMemory.consumeItems();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
