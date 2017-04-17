package funfunfun;

import java.util.Iterator;

public class MainDemo {

    public static void main(String[] args) {
        WorkerDemo worker01 = new WorkerDemo();
        WorkerDemo worker02 = new WorkerDemo();
        WorkerDemo worker03 = new WorkerDemo();
        
        worker01.setName("zhang3");
        worker01.setAge(18);
        worker01.setSalary(3000);
        
        worker02.setName("li4");
        worker02.setAge(25);
        worker02.setSalary(3500);
        
        worker03.setName("wang5");
        worker03.setAge(22);
        worker03.setSalary(200);
        
        ListDemo list =  new ListDemo(10);
        list.add(worker01);
        list.add(worker02);
        list.add(worker03);
        
        WorkerDemo worker04 = new WorkerDemo();
        worker04.setName("zhao6");
        worker04.setAge(24);
        worker04.setSalary(3300);
        list.add(1,worker04);
        
        list.remove(worker03);
        
        list.print();
        
        //Iterator iter = list.iterator();
    }

}
