public class ML4StaticSync {
    synchronized static public void printTable(int n) throws InterruptedException {
        for(int i=1;i<=10;i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        }

    public static void main(String[] args) {
        ML4StaticSync obj = new ML4StaticSync();
        ML4StaticSync obj2 = new ML4StaticSync();
        ML4StaticSync obj3 = new ML4StaticSync();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
                try {
                    obj.printTable(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
                try {
                    obj2.printTable(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
                try {
                    obj3.printTable(4);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
