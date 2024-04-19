package ProducerConsumer;

public class Producer extends Thread{
    BufferSharedMemory bufferSharedMemory;

    public Producer(BufferSharedMemory bufferSharedMemory) {
        this.bufferSharedMemory = bufferSharedMemory;
    }

    public void run() {
        int i=1;
        while(true) {
            try {
                bufferSharedMemory.produceItems(i++);
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
