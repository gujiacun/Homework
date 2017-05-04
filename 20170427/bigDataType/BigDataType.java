// 需求：通过Blob数据类型，把一张图片通过jdbc保存到数据库的表中，再把图片从数据库中拷贝新的到java中
//步骤：（1）由于在Statement中要先拼sql语句，但图片无法做到，选PreparedStatement
//（2）建sql语句插入，拿连接对象，拿语句对象，增添值（这里用Blob类型），执行语句，关闭资源
//（3）建sql语句搜索，拿连接对象，拿语句对象，执行语句并返回ResultSet对象，
//判断语句，如果返回的结果集有值，就取出数据，并用Files里的复制方法拷贝到新路径关闭资源
package bigDataType;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;


import src.com._520it.pss.util.JdbcUtil;

public class BigDataType {
    @Test
    public void testName() throws Exception {
        // 建sql语句插入，
        String sql = "INSERT INTO t_image(headings) VALUES(?)";
        // 拿连接对象，
        Connection link = JdbcUtil.getLink();
        // 拿语句对象，
        PreparedStatement state = link.prepareStatement(sql);
        // 增添值（这里用Blob类型），
        state.setBlob(1, new FileInputStream("D:\\classtest\\20170328\\Bday-06-20170427\\resources\\v2.jpg"));
        // 执行语句，
        state.executeUpdate();
        // 关闭资源
        JdbcUtil.close(null, state, link);
    }

    @Test
    public void testName02() throws Exception {
        // 建sql语句搜索，
        String sql = "SELECT headings FROM t_image";
        // 拿连接对象，
        Connection link = JdbcUtil.getLink();
        // 拿语句对象，
        PreparedStatement state = link.prepareStatement(sql);
        // 执行语句并返回ResultSet对象，
        ResultSet rs = state.executeQuery();
        // 判断语句，如果返回的结果集有值，就取出数据，并用Files里的复制方法拷贝到新路径
        if (rs.next()) {
            Blob blob = rs.getBlob("headings");
            Files.copy(blob.getBinaryStream(), Paths.get("v3.jpg"));
        }
        // 关闭资源
        JdbcUtil.close(null, state, link);
    }
/**
 * 小结：在表中设置Blob类型的数据的长度时，注意图片文件的大小
 * Blob接口中有此方法： InputStream getBinaryStream() 
          以流的形式获取此 Blob 实例指定的 BLOB 值。 
          
   NIO中的Files类有此方法：
   static long copy(InputStream in, Path target, CopyOption... options) 
Copies all bytes from an input stream to a file. 

static Path get(String first, String... more) 
Converts a path string, or a sequence of strings that when joined form a path string, to a Path. 
 */
}
