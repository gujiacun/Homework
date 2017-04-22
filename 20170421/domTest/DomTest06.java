//需求6、如果xml文件存在，把新的linkman加进去。若不存在，新创建Document对象，再把新的linkman加进去
// 操作步骤：
//       1、创建一个Document对象
//       2、创建根目录(contacts)，linkman 、 name、email、address、 group 元素， 
//       3、设置(添加)元素关系：
//               3.00>  contacts 根目录设置到document中
//               3.0> 设置对应的元素内容
//               3.1> 给 linkman元素添加name  email, address, group 子元素
//               3.2> 将linkman元素添加到根元素
//       4、同步操作：Transformer


package domTest;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class DomTest06 {

    public static void main(String[] args) throws Exception {
        File file = new File("D:\\classtest\\20170421\\src\\domTest\\Contacts.xml");
        // 在内存中建上面的XML文件的Document对象
        Document document = null;
        Element root = null;
        if (file.exists()) {
            document =   DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            // 获取根节点
            root = document.getDocumentElement();
        } else {
            // 不存在XML文件就要创建新的Document对象
            document =   DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument() ;
            // 由于Document对象是新创建的，里面什么都没有，根节点也要新创建
            root = document.createElement("contacts");
            // 连接根节点和文件对象
            document.appendChild(root);
        }
        // 创建新的linkman节点
        Element linkman = document.createElement("linkman");
        // 建里面的子节点
        Element name = document.createElement("name");
        Element email = document.createElement("email");
        Element address = document.createElement("address");
        Element group = document.createElement("group");
        // 设置值
        name.setAttribute("name", "risa");
        email.setAttribute("email", "keyaki@blog");
        address.setAttribute("address", "Tokyo");
        group.setAttribute("group", "keyakizaka46");
        // 把子节点加进父节点
        linkman.appendChild(name);
        linkman.appendChild(email);
        linkman.appendChild(address);
        linkman.appendChild(group);
        root.appendChild(linkman);
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
 * 给元素设置值
        元素名.setAttribute("元素名", "值");
 */