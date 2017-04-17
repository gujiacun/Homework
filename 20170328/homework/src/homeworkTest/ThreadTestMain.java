package homeworkTest;

public class ThreadTestMain {

    public static void main(String[] args) {
        // ThreadTest shinji = new ThreadTest("EVA_theFirst");
        // ThreadTest rei = new ThreadTest("EVA_theSecond");
        // 以下两行代码是普通的通过对象调用方法，从输出结果可看出，先执行完第一行，再执行第二行
        // shinji.run();
        // rei.run();
        // System.out.println("-------------------");
        // 线程的启动是通过start()方法,并发执行
        // shinji.start();
        // rei.start();
        MyRunnable shinji = new MyRunnable("EVA_theFirst");
        MyRunnable rei = new MyRunnable("EVA_theSecond");
        Thread r1 = new Thread(shinji);
        Thread r2 = new Thread(rei);
        r1.start();
        r2.start();

    }

}
