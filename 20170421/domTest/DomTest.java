// 需求：创建XML的Document对象
//步骤：（1）通过静态方法创建工厂类对象factory
//（2）通过factory建解析器对象builder
//（3）通过builder建Document对象/解析已存在的XML的File文件对象
package domTest;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class DomTest {
    public static void main(String[] args) throws Exception {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //（2）实例方法，通过工厂类对象建解析器对象
        DocumentBuilder builder = factory.newDocumentBuilder();
        //（3）创建/解析出Document对象
        Document document = builder.newDocument();
        File file = new File("xmlTest/NewFile.xml");
        Document document02 = builder.parse(file);
    }
}
/**
 * 小结：Document接口表示整个HTML或XML文件
 * 创建XML的Document对象非常麻烦，哪个即把设计的
 */