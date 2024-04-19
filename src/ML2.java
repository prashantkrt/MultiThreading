public class ML2 implements Runnable {

    private ML2(int a) {
        System.out.println("Hello World!");
    }

    public ML2() {
        this(10);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
