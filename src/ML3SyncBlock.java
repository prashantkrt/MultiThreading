class Bracket {
    //synchronized block acquires the lock for that particular object
    public void print(char open, char close) throws InterruptedException {
        synchronized (this) {
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
}

public class ML3SyncBlock {

    public static void main(String[] args) throws InterruptedException {
        Bracket b = new Bracket();
        Thread threadA = new Thread(new Runnable(){
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
                System.out.println("ThreadA executed in millis"+(end - start));
            }
        });

        Thread threadB = new Thread(new Runnable() {
            public void run() {
                long start = System.currentTimeMillis();
                for (int i = 0; i < 5; i++) {
                    try {
                        b.print('(', ')');
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                long end = System.currentTimeMillis();
                System.out.println("ThreadB executed in millis"+(end - start));
            }
        });
        threadA.start();
        threadB.start();
    }
}

//sync block takes lesser time , better go with block

