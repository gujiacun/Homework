package homeworkTest;

class RunnableDemo implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t01 = new Thread(new RunnableDemo(),"A");
        Thread t02 = new Thread(new RunnableDemo(),"B");
        Thread t03 = new Thread(new RunnableDemo(),"C");
        //可替换为t01.setPriority(Thread.MIN_PRIORITY);
        t01.setPriority(1);
        //可替换为t02.setPriority(Thread.NORM_PRIORITY);
        t02.setPriority(5);
        //可替换为t03.setPriority(Thread.MAX_PRIORITY);
        t03.setPriority(10);
        t01.start();
        t02.start();
        t03.start();
    }
}
