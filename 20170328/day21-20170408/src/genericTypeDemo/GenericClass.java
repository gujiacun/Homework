//需求：用泛型类，在类中先不指定元素类型，等调用者指定不同类型
package genericTypeDemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//类，使用泛型，暂不指定需要传入其内部的数据类型
class Father<T> {
    private T xT;
    private T yT;

    public Father() {

    }

    public T getxT() {
        return xT;
    }

    public void setxT(T xT) {
        this.xT = xT;
    }

    public T getyT() {
        return yT;
    }

    public void setyT(T yT) {
        this.yT = yT;
    }
}

// 测试类
public class GenericClass {
    // 主方法
    public static void main(String[] args) {
        // 创建泛型类的对象,这里指定为String
        Father<String> f = new Father<String>();
        // 设置值
        f.setxT("辛苦劳作，安享晚年");
        // 输出值
        System.out.println(f.getxT());
        // 创建泛型类的对象,这里指定为Integer
        Father<Integer> a = new Father<Integer>();
        // 设置值
        a.setyT(53);
        // 输出值
        System.out.println(a.getyT());
        // 调用方法,传入的f此时为String类型
        GenericClass.tell(f);
        // 调用方法,传入的a此时为Integer类型
        GenericClass.tell(a);

        // 新建集合的各个对象，分别用泛型定义不同的传入数据类型
        List<Double> num01 = new ArrayList<Double>();
        List<String> num02 = new ArrayList<String>();
        List<Float> num03 = new ArrayList<Float>();
        List<Object> num04 = new ArrayList<Object>();
        // 调用两种方法
        doWork01(num01);
        // num02是String类型，不是Number类或其子类
        //doWork01(num02);
        doWork01(num03);
        // num04是Object类型，不是Number类或其子类
        //doWork01(num04);

        // num01是Double类型，不是Number类或其父类
        //doWork02(num01);
        // num02是String类型，不是Number类或其父类
        //doWork02(num02);
        // num03是Float类型，不是Number类或其父类
        //doWork02(num03);
        doWork02(num04);

    }

    // 调用通配符,当不确定该传入什么数据类型时，用?
    public static void tell(Father<?> e) {
        System.out.println(e);
    }

    // 泛型的上限
    public static void doWork01(List<? extends Number> list) {

    }

    // 泛型的下限
    public static void doWork02(List<? super Number> list) {

    }
}
/**
 * 小结：掌握泛型上限和下限的格式，用extends表示下限，super表示上限
 * 类名<? extends/super 类> 对象名
 */
