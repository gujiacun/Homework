// 需求：做第八题，运用两个基本方法实现新功能
package playDemo;

public class StringDemo {

    public static void main(String[] args) {
        // 定义字符串和要检索的字符串
        String str = "sunjavaandroidjavajavasejavaeejavamec#java.netjavaphpjava";
        String subStr = "java";
        // 通过replaceAll方式，把字符串中该字母替换成空
        String newStr = str.replaceAll(subStr, "");
        // 获取原来的字符串长度
        int len = str.length();
        System.out.println(len);
        // 获取替换后的字符串长度
        int len2 = newStr.length();
        System.out.println(len2);
        // 原来的字符串长度减去替换后的字符串长度，再除以它的长度，就是检索的字符串的出现次数
        int result = (len - len2) / subStr.length();
        System.out.println(result);
    }

}
/**
 * 小结：在类中的方法，可以通过几个组合而实现各种不同的，原来没有的功能，要多加思考，同时掌握基本方法的作用
 */