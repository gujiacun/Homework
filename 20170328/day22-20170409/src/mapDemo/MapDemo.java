//需求：操作HashMap类的常用方法
package mapDemo;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        // 新建映射
        Map<String, Object> shoot = new HashMap<String, Object>();
        // 将指定的值与此映射中的指定键关联
        shoot.put("咖啡","Java");
        shoot.put("蟒蛇","Python");
        shoot.put("蛤丝克尔","Haskell");
        
        // 此映射是否包含此键
        System.out.println(shoot.containsKey("咖啡"));
        // 此映射是否包含此值
        System.out.println(shoot.containsValue("C++"));
        
        // 返回指定键所映射的值
        System.out.println(shoot.get("蟒蛇"));
        // 从指定映射中将所有映射关系复制到此映射中
        Map<String, Object> shooter = new HashMap<String, Object>();
        shooter.put("F", "facebook");
        shooter.put("L", "linkedin");
        shooter.put("A", "apple");
        shooter.put("G", "google");
        shoot.putAll(shooter);
        System.out.println(shoot);
        // 如果存在一个键的映射关系，则将其从此映射中移除
        shoot.remove("L");
        System.out.println(shoot);
        // 返回此映射中的键-值映射关系数
        System.out.println(shoot.size());
        // 从此映射中移除所有映射关系
        shoot.clear();
        System.out.println(shoot);
        

    }
}
/**
 * 小结：在HashMap中，key和value可以是任意类型（包括自定义），key不能重复，value能重复
 */
