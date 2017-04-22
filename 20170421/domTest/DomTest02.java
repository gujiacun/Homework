//需求2、修改某个元素节点的主体内容：把第一个联系人的邮箱改掉
//操作步骤：
//       1、获取Document对象
//       2、获取根元素(contacts)
//       3、获取到第一个联系人(linkman)
//       4、获取联系人(linkman)子元素(email)
//       5、修改子元素(email)内容
//       6、同步操作：Transformer

package domTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


public class DomTest02 {
public static void main(String[] args) {
    
}
    @Test
    public void test() throws SAXException, IOException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
        // 获取XML文件的File对象
        File file = new File("D:\\classtest\\20170421\\src\\domTest\\Contacts.xml");
        // 拿XML文件的Document对象
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        // 通过Document对象拿到其根元素/根节点
        Element root = document.getDocumentElement();
        // 通过根元素拿联系人节点（linkman）
        Element linkman = (Element) root.getElementsByTagName("linkman").item(0);
        // 通过联系人对象拿邮箱节点（email）
        Element email = (Element) linkman.getElementsByTagName("email").item(0);
        // 修改节点上的元素
        email.setAttribute("email", "新邮箱@163.com");
        // 由于上面的步骤都是操作在内存中的DOM树，要改变硬盘中的XML文件，进行同步操作
        //（1）建转换器对象，以此调用transform方法
        Transformer tran = TransformerFactory.newInstance().newTransformer();
        //（2）上面的方法需要源文件和目标文件，源是XML文件在内存的Document对象，目标是硬盘的XML文件
        Source xmlSource = new DOMSource(document);
        Result outputTarget = new StreamResult(new FileOutputStream(file));
        tran.transform(xmlSource, outputTarget);
    }

}
/**
 * 小结：Document接口表示整个HTML或XML文件
 * 创建XML的Document对象非常麻烦，创建转换器对象，转换方法的两个参数还他妈麻烦，哪个即把设计的
 */
