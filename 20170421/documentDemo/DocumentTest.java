// 需求：创建Document对象
package documentDemo;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;


public class DocumentTest {

    public static void main(String[] args) throws Exception {
        //（1）静态方法创建工厂类对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
        //（2）实例方法，通过工厂类对象建解析器对象
        DocumentBuilder builder = factory.newDocumentBuilder();
        //（3）创建/解析出Document对象
        Document document = builder.newDocument();
        
        Document document02 = builder.parse(new File("xmlTest/NewFile.xml"));
    }

}
