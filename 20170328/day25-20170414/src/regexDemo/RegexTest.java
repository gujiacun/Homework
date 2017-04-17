//需求：判断一个字符串是否全部由数字组成
//（1）新建字符串。用正则表达式，建字符串作为判断规则
//（2）以字符串.matches(判断规则)返回boolean类型结果
//需求：判断手机号码
package regexDemo;

public class RegexTest {

    public static void main(String[] args) {
        // 新建字符串
        String str = "123456789";
        // ^表示行的开头，$表示行的结尾，\d表示数字,要用\\,因为java中\\才表示反斜杠
        String regex = "^\\d*$";
        // string类有方法，matches(String regex) 告知此字符串是否匹配给定的正则表达式。
        System.out.println(str.matches(regex));
        // 表示数字必须出现5次，但这里有6个数字，false
        System.out.println("123456".matches("\\d{5}"));
        // 表示数字必须出现5次至7次，这里有6个数字，true
        System.out.println("123456".matches("\\d{5,7}"));
        System.out.println("------------------");

        String str02 = "12570439427";
        // ^1表示开头数字是1，[3 | 4 | 5 | 7 | 8]表示第二位数字是3/4/5/7/9，\\d{9}表数字要出现9次,$表结束
        String regex02 = "^1[3 | 4 | 5 | 7 | 8]\\d{9}$";
        System.out.println(str02.matches(regex02));
    }
}
/**
 * 小结：正则表达式最重要的是看懂各个符号之间表达的意思，记住规则
 */
