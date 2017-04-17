//需求：写单例模式中的懒汉式，由于它存在线程安全问题，所以用synchornized修饰并加以改进
//（1）写原始的懒汉式
//（2）写改进的懒汉式
package synchronizedTest;

public class ArrayUtilLazy {
    // 先私有化构造器
    private ArrayUtilLazy() {
    }

    // 声明对象而不进行初始化,并进行私有化和静态化
    private static ArrayUtilLazy lazy = null;

    // 暴露静态公共方法，外界调用时能返回本类的对象
    public static ArrayUtilLazy getInstance() {
        // 如果对象还没有实例化，就实例化
        if (lazy == null) {
            lazy = new ArrayUtilLazy();
        }
        return lazy;
    }
    // 本类中包含的方法

}

// 由于同时有多个线程调用类的静态方法时，会产生线程安全问题，用synchronized保护
class ArrayUtilLazyBetter {
    // 先私有化构造器
    private ArrayUtilLazyBetter() {
    }

    // 声明对象而不进行初始化,并进行私有化和静态化
    private static ArrayUtilLazyBetter lazy = null;

    // 暴露静态公共方法，外界调用时能返回本类的对象
    synchronized public static ArrayUtilLazyBetter getInstance() {
        // 如果对象还没有实例化，就实例化
        if (lazy == null) {
            lazy = new ArrayUtilLazyBetter();
        }
        return lazy;
    }
    // 本类中包含的方法

}

// 由于同时有多个线程调用类的静态方法时，会产生线程安全问题，单例模式中的懒汉式用synchronized保护
class ArrayUtilLazyBest {
    // 先私有化构造器
    private ArrayUtilLazyBest() {
    }

    // 声明对象而不进行初始化,并进行私有化和静态化
    private static volatile ArrayUtilLazyBest lazy = null;

    // 暴露静态公共方法，外界调用时能返回本类的对象
    public static ArrayUtilLazyBest getInstance() {
        //先进行判断，进入方法后，先不同步，先进行判断对象是否为空，若非则直接返回对象
        if (lazy == null) {
            //同步块
            synchronized (ArrayUtilLazyBest.class) {

                if (lazy == null) {
                    // 如果对象还没有实例化，就实例化
                    lazy = new ArrayUtilLazyBest();
                }
            }
        }
        return lazy;
    }
    // 本类中包含的方法

}
/**
 * 小结：当synchronized修饰静态方法时，同步锁为当前方法所在类的字节码文件
 */
