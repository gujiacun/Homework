// 需求：操作连接池DBCP，分为硬链接/软连接。连接池的最大目的是拿连接对象。
package src.com._520it._01_dbcp;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
//import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

import src.com._520it.pss.util.JdbcUtil;

public class DBCPTest {
    // 硬链接
    @Test
    public void testDBCP01() throws Exception {
        // （1）建Datasource对象,设置驱动/url/用户名/密码
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/dbdemo");
        ds.setUsername("root");
        ds.setPassword("73619nine40");
        // （2）通过Datasource对象拿连接对象
        Connection connection = ds.getConnection();
        // （3）获取语句对象
        // 从表中数有多少个成员
        String sql = "SELECT COUNT(id) FROM t_member";
        PreparedStatement ps = connection.prepareStatement(sql);
        // (4)执行语句
        ResultSet rs = ps.executeQuery();
        // (5)输出结果
        if (rs.next()) {
            System.out.println(rs.getLong(1));
        }
        // (6)关闭资源
        rs.close();
        ds.close();
        connection.close();
    }

    // 软链接
    @Test
    public void testDBCP02() throws Exception {
        //（1）由于驱动/url/用户名/密码都设置在properties文件中，想读取要建输入流
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
        //(2)建Properties对象加载输入流
        Properties properties = new Properties();
        properties.load(in);
        //（3）建连接池对象
        DataSource ds = BasicDataSourceFactory.createDataSource(properties);
        //（4）通过连接池对象拿连接对象
        Connection link = ds.getConnection();
        //（5）获取语句对象
        String sql = "SELECT COUNT(id) FROM t_member";
        PreparedStatement state = link.prepareStatement(sql);
        // 从表中数有多少个成员
        // (6)执行语句
        ResultSet rs = state.executeQuery();
        // (7)输出结果
        if (rs.next()) {
            System.out.println(rs.getLong(1));
        }
        // (8)关闭资源
        rs.close();
        state.close();
        link.close();
    }
/**
 * 小结：rs.getLong(int columnIndex)输入数字，表第几列
 */
}
