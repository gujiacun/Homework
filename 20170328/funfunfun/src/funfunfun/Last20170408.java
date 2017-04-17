package funfunfun;

import java.util.ArrayList;
import java.util.List;

public class Last20170408 {

    public static void main(String[] args) {
        
        List<Worker_Last20170408> list = new ArrayList<>();
        Worker_Last20170408 worker01 = new Worker_Last20170408("AAA",13,3000);
        Worker_Last20170408 worker02 = new Worker_Last20170408("bbb",17,4333);
        Worker_Last20170408 worker03 = new Worker_Last20170408("cc",20,2333);
        list.add(worker01);
        list.add(worker02);
        list.add(worker03);
        System.out.println(list);
        Worker_Last20170408 worker04 = new Worker_Last20170408("DDD",21,5000);
        list.add(1, worker04);
        System.out.println(list);
    }

}
