// 利用DOM操作XML文件
// 需求1、得到某个具体的文本节点的内容:取出第二个联系人的名字
// 操作步骤：
// 1、获取Document对象
// 2、获取根元素(contacts)
// 3、获取到第二个联系人(linkman)
// 4、获取联系人(linkman)子元素(name)
// 5、打印子元素(name)的文本内容
package domTest;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


public class DomTest01 {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        // 获取XML文件的File对象
        File file = new File("D:\\classtest\\20170421\\src\\domTest\\Contacts.xml");
     // 1、获取Document对象
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
     // 2、获取根元素(contacts)
        Element root = document.getDocumentElement();
     // 3、先获得所有具有相同名字的节点组成的NodeList，再用NodeList中的item(index)获得指定索引的元素，获取到第二个联系人(linkman),右边返回Node类型
        Element linkman = (Element) root.getElementsByTagName("linkman").item(1);
     // 4、获取联系人(linkman)子元素(name)
        Element name = (Element) linkman.getElementsByTagName("name").item(0);
     // 5、打印子元素(name)的文本内容
        System.out.println(name.getTextContent());
    }
/**
 * 小结：String getAttribute(String name) 
          通过名称获得属性值。 
 */
}
