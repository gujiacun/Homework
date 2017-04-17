//需求：用对象流来序列化，反序列化。
//（1）在UserDemo.java文件中，建姓名，密码，年龄字段
//（2）在测试类的主方法中，建writeObject方法，实现序列化操作；在方法内建ObjectOutputStream对象，用系统的writeObject方法，填入User对象，关闭
//（3）在测试类的主方法中，建readObject方法，实现反序列化操作；在方法内建ObjectInputStream对象，用系统的readObject方法，填入User对象，关闭
package objectDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import printDemo.UserDemo;

//测试类
public class ObjectTest {

    public static void main(String[] args) throws Exception {
        //创建文件对象
        File file = new File("11111/Untitled 1");
        // writeObject方法,序列化操作就是把内存中的对象数据输入到文件
        writeObject(file);
        //readObject方法，实现反序列化操作,即把硬盘/网络中的数据转换为内存中的对象数据
        readObject(file);
    }

    private static void readObject(File file) throws Exception {
        // 建ObjectInputStream对象
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        // 从文件中读入数据到内存中，存为对象数据,注意readObject返回的是Object对象,这里强转
        UserDemo user02 = (UserDemo)in.readObject();
        System.out.println(user02);
        in.close();
    }

    private static void writeObject(File file) throws Exception {
        // 建ObjectOutputStream对象
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        //writeObject(Object obj) 将指定的对象写入 ObjectOutputStream
        UserDemo user = new UserDemo("辣妹子","有事找大哥",50);
        out.writeObject(user);
        // 此时报错，因为需要做序列化的对象的类,必须实现序列化接口:java.io.Serializable接口
        out.close();
    }
}
/**
 * 小结：用对象流做序列化和反序列化，一定要存在内存中的对象文件，硬盘中的文件
 */
