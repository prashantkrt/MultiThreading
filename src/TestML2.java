public class TestML2 {
    public static void main(String[] args) {
        ML2 ml2 = new ML2();
        Thread thread1 = new Thread(ml2);
        thread1.start();
    }
}
