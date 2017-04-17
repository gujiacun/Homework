//需求：自定义异常，继承受检异常，java.lang.RuntimeException
//伟江要登陆游戏服务器，服务器要判断是否有此名字，没有就显示登录失败，有就显示登陆成功
//步骤：（1）在主方法建数组，模拟服务器存储的玩家名字
//（2）新建方法，用于判断名字是否在服务器内（数组）内，有就显示登陆，没有就报异常
//（3）新建异常类，模仿java里的异常类新建
package throwTest;

//新建异常类,由于throw的含义是手动抛出一个具体的异常对象，所以在自定义的异常类中，必须要有构造方法，去返回一个异常对象
class ServiceLogicException extends java.lang.RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServiceLogicException() {
        super();
    }

    public ServiceLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceLogicException(String message) {
        super(message);
    }

}

// 测试类
public class DiyExceptionTest {
    // 主方法
    // 新建数组,必须用static修饰，同一个类中，静态成员可以直接访问静态成员
    static String[] array = { "伟明", "吃年", "狗疯" };
    // 新建需要寻找的名字,必须用static修饰，同一个类中，静态成员可以直接访问静态成员
    static String name = "伟江";

    public static void main(String[] args) {
        // 假如whether方法有异常返回，在这里捕获并打印相关信息
        try {
            // 调用whether方法，传入需要搜索的名字
            DiyExceptionTest.whether(name);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    // 新建方法,要传入需要寻找的元素
    public static void whether(String name) {
        // 由于要在数组中寻找是否有元素与“伟江”相等，所以用for each
        for (String element : array) {
            // 如果相等，显示成功，不相等，返回异常
            if (element.equals(name)) {
                System.out.println("登陆成功，今天冲100Q币送5位QQ号哦！");
                return;
            } else {
                // 返回异常，调用自定义的业务逻辑异常
                System.out.println("请你想一想，不冲钱能变强吗？不充钱玩你妹游戏。我让你登陆都登陆不了");
                throw new ServiceLogicException("编程王在网络深海中埋藏了一种宝藏，叫ONECODE，你想得到它吗？");
            }
        }
    }
}
/**
 * 小结：写代码时要先了解需求，再把需求转为步骤，每次只做平级的时，做完后再做下一级的步骤。
 */
