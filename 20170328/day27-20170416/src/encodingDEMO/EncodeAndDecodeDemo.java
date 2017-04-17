//需求：用URLEncoder把字符串编码成application/x-www-form-urlencoded MIME字符串
//用URLDecoder把application/x-www-form-urlencoded MIME字符串解码成字符串
//（1）新建字符串，用空格和汉字数字英文
//（2）先返回此时平台用的字符集System.getProperty("file.encoding")
//(3)用encode方法（静态）把string转为XXXXX，传入字符集
//（4）用decode方法（静态）把xxxx转为string，传入字符集
package encodingDEMO;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodeAndDecodeDemo {

    public static void main(String[] args) throws Exception {
        String str = "江主席 ： 你们给我搞的这个东西，excited！    ";
        System.out.println(System.getProperty("file.encoding"));
        String result = URLEncoder.encode(str,"UTF-8");
        System.out.println(result);
        System.out.println(URLDecoder.decode(result, "UTF-8"));
    }
}
/**
 * 小结：注意，application/x-www-form-urlencoded MIME字符串也是字符串
 * 即它也是属于string类型
 */
