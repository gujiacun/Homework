
class ThreadDemo00 implements Runnable {
    int ticket = 5;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // this表示调用此run方法的对象
            this.tell();
        }
    }

    // 同步方法
    public synchronized void tell() {
        if (ticket > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("车票：" + ticket--);
        }
    }

}

public class MyThreadDemo {

    public static void main(String[] args) {
        ThreadDemo00 eggegg = new ThreadDemo00();
        Thread r1 = new Thread(eggegg);
        Thread r2 = new Thread(eggegg);
        Thread r3 = new Thread(eggegg);
        r1.start();
        r2.start();
        r3.start();

    }

}
