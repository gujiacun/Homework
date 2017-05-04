// 需求：操作连接池Druid，分为硬链接/软连接。连接池的最大目的是拿连接对象。
package src.com._520it._02_druid;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

//import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidTest {
    // 硬链接
    @Test
    public void testDruid01() throws Exception {
        // （1）建Datasource对象,设置驱动/url/用户名/密码
        
        // （2）通过Datasource对象拿连接对象
        // （3）获取语句对象
        // 从表中数有多少个成员
        // (4)执行语句
        // (5)输出结果
        // (6)关闭资源
    }

    @Test
    public void testDruid02() throws Exception {
        // （1）由于驱动/url/用户名/密码都设置在properties文件中，想读取要建输入流
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
        // (2)建Properties对象加载输入流
        Properties properties = new Properties();
        properties.load(in);
        // （3）建连接池对象
        DataSource ds = new DruidDataSourceFactory().createDataSource(properties);
        // （4）通过连接池对象拿连接对象
        Connection link = ds.getConnection();
        // （5）获取语句对象
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
}
/**
 * 小结：rs.getLong(int columnIndex)输入数字，表第几列
 */
