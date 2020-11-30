package jenkov.threads;

public class SharedObjects {

    public static void main(String[] args){

        Runnable runnable = new MyRunnable();

        Thread thread1 = new Thread(runnable, "THread1");
        Thread thread2 = new Thread(runnable, "Thread2");

        thread1.start();
        thread2.start();
    }
}
