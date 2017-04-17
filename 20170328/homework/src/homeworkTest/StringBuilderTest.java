package homeworkTest;
//需求：操作StringBuilder的常用方法
//新建类
public class StringBuilderTest {
    //主方法
    public static void main(String[] args) {
        //调用构造方法，创建新对象
        StringBuilder a = new StringBuilder("excited");
        System.out.println(a.length());
        //构造一个不带任何字符的字符串生成器，初始容量为18
        StringBuilder b = new StringBuilder(18);
        //为a插入新内容
        a.append("!");
        System.out.println(a);
        //把某字符串插入到指定位置
        String str = "江主席说：";
        a.insert(0, str);
        System.out.println(a);
        //使用新字符串替换源字符串中的某部分内容
        String newstr = "见得多了，身经百战的江主席说：";
        //记住java中的范围是前闭后开
        a.replace(0, 5, newstr);
        System.out.println(a);
        //把字符串逆序排列
        a.reverse();
        System.out.println(a);
        //移除字符串的某部分
        a.reverse();
        a.delete(0, 5);
        System.out.println(a);
        //移除字符串的某个特定字符
        a.deleteCharAt(4);
        System.out.println(a);
        //String转为StringBuilder
        String test = "西方哪个国家我没去过";
        StringBuilder talk = new StringBuilder(test);
        //StringBuilder转为String
        String test02 = talk.toString();
        String strArray = "jikexueyuan";
        System.out.println(strArray.indexOf("u"));
    }

}
/**
 * 小结：StringBuilder是三种字符串中性能最高的，但由于不安全，所以推荐在单线程中使用
 */
