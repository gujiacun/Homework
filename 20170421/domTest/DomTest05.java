//需求5、删除指定元素节点：删除第四个联系人信息邮箱
//操作步骤：
//       1、获取Document对象
//       2、获取根元素(contacts)
//       3、获取到第三个联系人(linkman)
//       4、删除联系人  
//       5、同步操作：Transformer

package domTest;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class DomTest05 {

    @Test
    public void test() throws Exception{
        File file = new File("D:\\classtest\\20170421\\src\\domTest\\Contacts.xml");
        // 拿XML文件的Document对象
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        // 拿根元素
        Element root = document.getDocumentElement();
        // 拿第三个联系人元素
        Element linkman = (Element) root.getElementsByTagName("linkman").item(3);
        // 拿联系人元素的邮箱元素
        Element email = (Element) linkman.getElementsByTagName("email").item(0);
        // 先拿邮箱元素的父节点，通过联系人元素删除邮箱元素
        email.getParentNode().removeChild(email);
        // 同步
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Source xmlSource = new DOMSource(document);
        Result outputTarget = new StreamResult(file);
        transformer.transform(xmlSource, outputTarget);
    }
}
/**
 * 小结：通过Document对象拿根元素，方法为Document对象.getDocumentElement()
 * 通过根元素拿里面的某个子元素，方法为根元素.getElementsByTagName("元素名字").item(index)
 */
