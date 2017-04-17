//需求：判断字符串非空（null）和空字符串
//步骤：判断，要用if语句。null为没有引用内存地址，空字符串有内存空间，但没有内容,"" 和 "  " 都属于这种情况。
//因此，判断前者用 == ，后者用 equals
package homeworkTest;

public class StringEmptyTest {
    // 主方法
    public static void main(String[] args) {
        String name = "   ";
        // 注意运算符的选择要与方法体的语句符合
        if (name == null || "".equals(name.trim())) {
            // trim()方法忽略字符串的前导和尾部空白
            System.out.println("该字符串为空。");
        } else {
            System.out.println("该字符串不为空。");
        }
    }

}
/**
 * 小结：在网页填入表单时会经常使用，注意代码的简洁
 */
