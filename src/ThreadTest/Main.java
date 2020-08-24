package ThreadTest;

public class Main {
    public static void main(String[] args) {

        ThreadClass threadTest = new ThreadClass();
        Thread thread = new Thread(threadTest);
        ThreadClass threadTest2 = new ThreadClass();
        Thread thread2 = new Thread(threadTest2);
        thread.start();
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello");
    }
}
