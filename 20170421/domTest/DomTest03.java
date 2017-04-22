//需求3、向指定元素节点中增加子元素节点：增加一个新的联系人信息  
// 操作步骤：
//       1、获取Document对象
//       2、获取根元素(contacts)
//       3、创建linkman 、 name、email、address、 group 元素， 
//       4、设置(添加)元素关系：
//               4.0> 设置对应的元素内容
//               4.1> 给 linkman元素添加name  email, address, group 子元素
//               4.2> 将linkman元素添加到根元素
//       5、同步操作：Transformer

package domTest;

import java.io.File;
import java.io.FileOutputStream;

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

public class DomTest03 {
    @Test
    public void test() throws Exception {
        File file = new File("D:\\classtest\\20170421\\src\\domTest\\Contacts.xml");
        // 先获得硬盘中的XML文件在内存的Document对象
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        // 要增加新的联系人信息，先得创建联系人及其四个子元素的元素对象
        Element linkman = document.createElement("linkman");
        Element name = document.createElement("name");
        Element email = document.createElement("email");
        Element address =  document.createElement("address");
        Element group = document.createElement("group");
        // 把联系人中的姓名，邮箱，地址，群组四个子节点设置元素内容
        name.setTextContent("manaka");
        email.setTextContent("keyakizaka@blog");
        address.setTextContent("Tokyo");
        group.setTextContent("keyakizaka46");
        // 把以上四个子节点添加在联系人节点（父节点），把联系人节点添加到根元素（先创建根元素）
        linkman.appendChild(name);
        linkman.appendChild(email);
        linkman.appendChild(address);
        linkman.appendChild(group);
        Element root = document.getDocumentElement();
        root.appendChild(linkman);
        // 同步
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Source xmlSource = new DOMSource(document);
        Result outputTarget = new StreamResult(file);
        transformer.transform(xmlSource, outputTarget);
    }

}
/**
 * 小结：Document接口表示整个HTML或XML文件
 * 创建XML的Document对象非常麻烦，同步时创建转换器对象，转换方法的两个参数还他妈麻烦，哪个即把设计的
 * 创建节点要用Document对象调用createElement("String")方法,返回Element对象
 * 把子节点加进父节点下面，用appendChild
 */