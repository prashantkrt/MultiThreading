package ProducerConsumer;

public class Main {
    public static void main(String[] args) {
        BufferSharedMemory buffer1 = new BufferSharedMemory();
        Producer producer1 = new Producer(buffer1);
        Consumer consumer1 = new Consumer(buffer1);
        BufferSharedMemory buffer2 = new BufferSharedMemory();
        Producer producer2 = new Producer(buffer2);
        Consumer consumer2 = new Consumer(buffer2);
        BufferSharedMemory buffer3 = new BufferSharedMemory();
        Producer producer3 = new Producer(buffer3);
        Consumer consumer3 = new Consumer(buffer3);
        BufferSharedMemory buffer4 = new BufferSharedMemory();
        Producer producer4 = new Producer(buffer4);
        Consumer consumer4 = new Consumer(buffer4);
        producer1.start();
        consumer1.start();
        producer2.start();
        consumer2.start();
        producer3.start();
        consumer3.start();
        producer4.start();
        consumer4.start();
    }
}
