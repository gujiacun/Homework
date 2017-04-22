// 需求：操作dom4j的几个方法，建对象，迭代，添加元素
package dom4jTest;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Dom4jDemo {
    @Test
    public void test() throws Exception {
        // 用DOM建XML文件在内存中的DOM对象
        File file = new File("D:\\classtest\\20170421\\src\\domTest\\Contacts.xml");
        // Document document =
        // DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        // 用dom4j建XML文件在内存中的DOM对象
        SAXReader reader = new SAXReader();
        // 注意，这里的Document不是org.w3c.dom.Document，而是org.dom4j.Document
        Document document = reader.read(file);

        // 迭代,注意Element类要导进dom4j里面的，不是w3c里面的
        // (1)获取根节点下面所有的子节点,得先获取根节点
        Element root = document.getRootElement();
        // 返回根节点下面的所有的子节点，组成数组
        List elements = root.elements();
        // 循环得到数组中的每一个元素（节点）
        for (Object object : elements) {
            // 强转为Element类型
            Element element = (Element) object;
            // 在这个元素上获得名为name的元素
            Element name = element.element("name");
            // 得到name元素的文本内容并打印
            System.out.println(name.getText());
            System.out.println(object);
        }
        System.out.println("=========================================");
        // (2)获取根节点下面指定名字的子节点
        List elementsList = root.elements("linkwoman");
        for (Object object : elementsList) {
            System.out.println(object);
        }
        // (3)往XML添加新的联系人,记住返回的是根元素下一级的节点
        Element linkman = root.addElement("linkman").addAttribute("name", "YUIs").addAttribute("email", "keyaki@blog")
                .addAttribute("address", "Tokyo").addAttribute("group", "keyakizaka46");
        // 新增联系人
        Element center = root.addElement("center").addAttribute("id", "0");
        center.addElement("name").addText("秋元康");
        center.addElement("email").addText("email@");
        center.addElement("address").addText("Japan");
        center.addElement("group").addText("坂道系");
        // 同步,注意这里的同步是dom4j的同步方法，与DOM的同步方法不同
        // 方法一：
        XMLWriter writer = new XMLWriter(new FileWriter(file));
        writer.write(document);
        writer.close();
        // 方法二：
//         OutputFormat format = OutputFormat.createPrettyPrint();
//         XMLWriter writer = new XMLWriter(new FileWriter(file), format);
//         writer.write( document );
//         writer.close();
        // // 方法三：
//         OutputFormat format = OutputFormat.createCompactFormat();
//          XMLWriter writer = new XMLWriter(new FileWriter(file), format);
//         writer.write( document );
//         writer.close();
    }
}
/**
 * 小结：注意，这里使用的方法都是dom4j这个jar文件里面的 在使用第三方jar时，要注意查询其api，并与java自带的api严格区分
 */
