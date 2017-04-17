//需求：表示基本数据类型的字节码对象，
//（1）所有数据类型都有class属性，通过此返回基本数据类型的字节码对象(Class类对象)
//(2)所有包装类都有TYPE字段，返回该包装类对应的基本数据类型的Class实例(字节码对象)
package class_instance;

public class DateTypeClassInstanceDemo {

    public static void main(String[] args) {
        // 
        int num = 36;
        // 可以不加泛型，注意泛型不能用基本数据类型
        // 这里不可以写为Class<Integer> intClass = num.class;
        Class<Integer> intClass = int.class;
        Class<Boolean> booleanClass = boolean.class;
        Class voidClass = Void.class;
        
        // 注意Integer类的Class实例与int的Class实例不相等
        Class<Integer> IntegerClass = Integer.class;
        // 错误
        System.out.println(intClass == IntegerClass);
        System.out.println(Integer.TYPE == Integer.class);
        System.out.println(Integer.TYPE == int.class);
        
        //表示数组的class实例
        int[] arr01 = {1,2,3,4,5,6};
        // 方法一：数组对象.getClass()
        Class a = arr01.getClass();
        // 方法二：数组类型.class()
        Class b = int[].class;
        Class c = byte[].class;
        // 所有具有相同维数和元素类型的数组共享同一份字节码对象
        System.out.println(a == b);
        // c和a类型不同
        System.out.println(a == c);
    }
}
/**
 * 小结：所有具有相同维数和元素类型的数组共享同一份字节码对象，与元素的个数无关
 */
