//需求4、操作XML文件属性：设置/获取第一联系人的id属性  
// 操作步骤：
//       1、获取Document对象
//       2、获取根元素(contacts)
//       3、获取到第一个联系人(linkman)
//       4、设置或获取联系人id属性
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

public class DomTest04 {

  @Test
  public void test() throws Exception{
      File file = new File("D:\\classtest\\20170421\\src\\domTest\\Contacts.xml");
      // 拿XML文件在内存中的DOM对象
      Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
      // 树状结构。一个节点一个节点地去找，先去根节点
      Element root = document.getDocumentElement();
      Element linkman = (Element) root.getElementsByTagName("linkman").item(0);
      // 获取联系人id属性，getAttribute方法返回String类型
      String id = linkman.getAttribute("id");
      System.out.println(id);
      //设置联系人id属性
      linkman.setAttribute("id", "3");
      // 同步
      Transformer transformer = TransformerFactory.newInstance().newTransformer();
      Source xmlSource = new DOMSource(document);
      Result outputTarget = new StreamResult(file);
      transformer.transform(xmlSource, outputTarget);
  }
}
 /**
  * 小结：getAttribute方法返回String类型
  * 设置联系人id属性，两个参数都用双引号包围
    linkman.setAttribute("id", "3");
  */
