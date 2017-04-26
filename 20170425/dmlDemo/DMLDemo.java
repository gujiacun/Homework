// 需求：插入，更新，删除数据
package dmlDemo;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

public class DMLDemo {
    @Test
    public void testName() throws Exception {
        //(1)加载注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //(2)新建连接/sql语句对象，建sql语句
        Connection link = null;
        // 假如连接的数据库的主机是本机，而且端口是默认的3306，url可简写
        String url = "jdbc:mysql:///dbdemo";
        String user = "root";
        String password = "73619nine40";
        Statement state = null;
        // 插入
        String sql = "INSERT INTO t_member(id,name,age) VALUES(1,'Hirate',15)";
        // 更新
        String sql02 = "UPDATE t_member SET name= 'Yurina' WHERE age=15";
        // 删除
        String sql03 = "DELETE FROM t_member WHERE name='Yurina'";
        try{
            link = DriverManager.getConnection(url,user,password);
            state =link.createStatement();
            //(4)执行sql语句
            int ret = state.executeUpdate(sql03);
            System.out.println(ret);
        } catch (Exception e) {
            //(5)关闭资源
            e.printStackTrace();
        }finally{
            try {
                if (state != null) {
                    state.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (link != null) {
                    link.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //(6)
        //(1)
    }
}
/**
 * 小结：当我要输入大量代码时，很容易出现输入错误/漏空格。要仔细，要对代码格式烂熟于心
 */
