class Brackets {
    //synchronized method acquires the lock for that particular object
    synchronized public void print(char open, char close) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            if (i < 5)
                System.out.print(open + " ");
            else
                System.out.print(close + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(25);
        }
    }
}

public class ML3Sync {
    public static void main(String[] args) {
        Brackets b = new Brackets();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                long start = System.currentTimeMillis();
                for (int i = 0; i < 5; i++) {
                    try {
                        b.print('[', ']');
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                long end = System.currentTimeMillis();
                System.out.println("Thread1 time taken in millis" + (end - start));
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                long start = System.currentTimeMillis();
                for (int i = 0; i < 5; i++) {
                    try {
                        b.print('{', '}');
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                long end = System.currentTimeMillis();
                System.out.println("Thread2 time taken in millis" + (end - start));
            }
        });
        thread1.start();
        thread2.start();
    }
}
