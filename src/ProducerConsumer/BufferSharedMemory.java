package ProducerConsumer;

public class BufferSharedMemory {

    boolean flag = false;
    int buffer;

    synchronized public void produceItems(int item) throws InterruptedException {
        if(flag)
        {
            wait();//item is getting consumed so wait till then
        }
        buffer = item;
        System.out.println("Item has been produced "+buffer);
        flag=true;
        notify();
    }

    synchronized public int consumeItems() throws InterruptedException {
        if(!flag){
            wait();//item not yet produced for wait
        }
        System.out.println("Item has been consumed "+buffer);
        flag=false;
        notify(); //will notify the producer to produce the items
        return buffer;
    }
}
