//需求：综合考察今天的异常内容
//步骤:（1）工人开车上班，在主方法创建对象工人和汽车，同时另外创建类工人和汽车，让工人对象调用工人类中的上班方法
//（2）在类工人的上班方法中，调用类汽车中的驾驶方法
//（3）驾驶方法正常情况下会被正确调用，若不幸爆胎下产生异常（自定义），异常传递给工人，工人只能抛弃驾驶方法，转为使用走路方法
//（4）由于是走路，会导致迟到（自定义异常），把异常抛给主方法的调用者
//（5）主方法调用者捕获并处理
package throwTest;

//测试类
public class GoWorkingTest {
    // 主方法
    public static void main(String[] args) {
        Worker officer = new Worker();
        Car BMW = new Car();
        try {
            officer.goToWork(BMW);
            System.out.println("又拿全勤奖，excited！");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("上班迟到，扣奖金，以后要多锻炼身体，5分钟跑到公司，卖掉破车");
        }
    }

}

// 创建类工人
class Worker {
    // 把Car类的对象作为Worker类的字段
    Car car;

    // 创建goToWork方法
    public void goToWork(Car car) {
        // 由于两个方法都是实例方法，不能通过下面的方式来调用Car类中的drive方法
        // Car.drive();
        // 因此可以把Car类的对象作为Worker类的字段，通过字段（对象）调用它所属的类的实例方法
        // 把传入的对象赋给本类字段
        this.car = car;
        // 通过对象（字段）调用Car类的方法
        // 可能会传入异常，在这里进行捕获
        try {
            this.car.drive();
        } catch (Exception e) {
            e.printStackTrace();
            // 转为使用步行方法
            this.walk();
            // 测试
            throw new BeingLateException("迟到的原因" + e.getMessage(), e);
            //throw new BeingLateException("迟到的原因" + e.getMessage(), e);
        }
    }

    // 创建步行方法，只有当驾驶方法出现异常时才调用此方法
    public void walk() {
        System.out.println("鬼叫你穷啊，顶硬上啊，嘿哟，嘿哟");
        // 由于是走路，会导致迟到（自定义异常），把异常抛给主方法的调用者
        throw new BeingLateException("肾亏啊，走路上班迟到了啊");
    }
}

// 创建类汽车
class Car {
    // 车况正常为1，其余情况为异常
    int a = 0;

    // 创建方法
    public void drive() {
        if (a == 1) {
            System.out.println("开车准时上班，一颗赛艇");
        } else {
            // 异常时，抛出异常对象给方法的调用者（异常类需要自己创建）
            throw new BrokenCarException("汽车爆胎，只能走路上班");
        }
    }
}

// 自定义异常类
class BrokenCarException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // 由于要抛出具体的异常对象，必须用到构造方法，所以给它
    public BrokenCarException(String message) {
        super(message);
    }

    public BrokenCarException() {
        super();
    }

}

// 自定义异常类
class BeingLateException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public BeingLateException() {
        super();
    }

    public BeingLateException(String message) {
        super(message);
    }

    public BeingLateException(String message, Throwable cause) {
        super(message, cause);
    }

}
/**
 * 小结：加强锻炼逻辑思维，在写代码前拆分需求，想好步骤流程，深入理解面向对象思想，完全掌握基本只是
 */
