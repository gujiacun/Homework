package homeworkTest;

public class ThreadTest extends Thread {
    // 线程的名字
    private String name;

    public ThreadTest(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + ":" + i);
        }
        super.run();
    }

}
