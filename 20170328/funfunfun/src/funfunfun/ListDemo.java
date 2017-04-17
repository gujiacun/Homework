package funfunfun;

import java.util.Arrays;
import java.util.Iterator;

public class ListDemo {

    private static WorkerDemo[] array = null;
    private static int size = 0;

    public ListDemo(int num) {
        this.init(num);
    }

    public void init(int initialCapacity) {
        array = new WorkerDemo[initialCapacity];
    }

    public void add(WorkerDemo worker) {
        if (size == array.length) {
            WorkerDemo[] temp = Arrays.copyOf(array, array.length * 2);
            array = temp;
        }
        array[size] = worker;
        size++;
    }

    public void add(int index, WorkerDemo worker) {
        if (size == array.length) {
            WorkerDemo[] temp = Arrays.copyOf(array, array.length * 2);
            array = temp;
        }
        for (int i = index; i < size; i++) {
            array[i + 1] = array[i];
        }
        array[index] = worker;
        size++;
    }

    public int indexOf(WorkerDemo worker) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(worker)) {
                return i;
            }
        }
        return -1;
    }

    public void remove(WorkerDemo worker) {
        int index = this.indexOf(worker);
        if (index < 0) {
            return;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }
    
    public void work(){
        System.out.println("正在工作");
    }

    public Iterator iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}
