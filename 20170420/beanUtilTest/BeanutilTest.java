// 需求：利用beanutil进行javabean和Map的互相转换
package beanUtilTest;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.StringConverter;
import org.apache.commons.lang3.ObjectUtils.Null;

public class BeanutilTest {

    public static void main(String[] args) throws Exception {
        // 两个javabean的类之间的拷贝
//        Member idol = new Member("Hirate Yurina", 15);
//        Member idol2 = new Member();
//        BeanUtils.copyProperties(idol2, idol);
//        System.out.println(idol2);
        // javabean转换为Map
//        Member idol = new Member("Hirate Yurina", 15);
//        Map<String, String> map = BeanUtils.describe(idol);
//        System.out.println(map);
        // Map转换为javabean
        Map<String, Object> map = new HashMap<>();
        map.put("age", 35L);
        map.put("name", "Risa");
        Member idol = new Member();
        
        //ConvertUtils.register(new LongConverter("11"),Long.class);
        BeanUtils.copyProperties(idol, map);
        System.out.println(idol);
    }

}
