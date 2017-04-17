// 需求：操作编码和解码，把字符串和byte数组互相转换，解决乱码问题
package file_writer_reader;

import java.util.Arrays;

public class EncodingDemo {

    public static void main(String[] args) throws Exception {
        // 编码，把string转为byte数组
        String str = "春哥纯爷们铁血真汉子";
        // 传入编码所需的字符集
        byte[] array = str.getBytes("UTF-8");
        // 输出此时经过字符集编码后的byte数组
        System.out.println(Arrays.toString(array));
        // 解码，把byte数组转为string，由于要传入字符集，所以只能通过构造器转入
        String str02 = new String(array, "UTF-8");
        System.out.println(str02);
        System.out.println("===============================");
        // 使用了错误的字符集，变成乱码，把它改正
        String str03 = new String(array, "ISO-8859-1");
        System.out.println(str03);
        // 先把发生乱码的字符串按照错误的字符集变为byte数组
        byte[] array02 = str03.getBytes("ISO-8859-1");
        System.out.println(Arrays.toString(array02));
        // 再把byte数组按照新的字符集解码为字符串（按照正确的字符集）
        String strCorrect = new String(array02, "UTF-8");
        System.out.println(strCorrect);
    }
}
/**
 * 小结：编码格式：把string转为byte数组，调用string里的getBytes方法
 * byte[] 数组名 = 字符串.getBytes("字符集");
 * 解码格式：把byte数组转为string，只能通过string构造器转入（因为要传字符集）
 * String 字符串名字 = new String(数组名, "字符集");
 */
