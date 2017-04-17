//需求：创建URL对象创建URL对象:
//URL(String protocol, String host, int port, String file) 

package url_Test;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http","java",8080,"index.jsp");

    }
}
/**
 * 小结：创建URL对象有多种构造方法，注意区分
 */
