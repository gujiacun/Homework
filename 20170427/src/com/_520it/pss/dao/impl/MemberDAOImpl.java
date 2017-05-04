// 需求：此为DAO接口的实现类，实现domain对象对应的接口及里面的CRUD方法
// 这里要把上午的运用JDBC操作数据库的知识运用
// 重构思考：（1）重构，把方法中经常需要用的数据放到成员变量中，这样所有方法都能方便调用
// （2）但是，如果有多个DAO实现类，每个里面都要有四行一样的代码，继续把它们放在一个类中
// （3）但是，在DAO的实现类中的每一个方法中，都有拿Connection对象和Statement对象的语句，这也可以抽象/省略，一会儿用PreparedStatement，所以Statement先不抽象
// 这步的目标是获取Connection对象
// (4)由于在工具类中，每次调用获取连接对象的方法时都要加载一次注册驱动进内存，所以直接用静态代码块放驱动
// 不把url，userName，password放进静态代码块，因为这三个可能会改，但确定用什么数据库时，驱动一般不改
// (5)关闭资源的代码重复严重，放进工具类里抽象成方法直接调用.由于操作DDL/DML语句时要关两个资源，DQL要关三个资源，建方法时的参数列表要有三个，必要时传null
// (6)由于在工具类中存在硬编码，驱动/url/用户名/密码以后可能会改，所以把他们放在配置文件中
// 注意配置文件要放在资源文件夹(Source Folder)里面，这样会被自动编译到classpath，类加载器才能找到
// (7)用预编译语句对象，替换所有Statement
//步骤：一。编写sql语句，里面参数值用占位符
//二。在这里，调用工具类的静态方法拿连接对象
//三。拿语句对象时，通过Connection/连接对象调用prepareStatement方法
//四。通过语句对象调用setXXX方法传入占位符的值
//五。执行sql语句
package src.com._520it.pss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import src.com._520it.pss.dao.IMemberDAO;
import src.com._520it.pss.member.Member;
import src.com._520it.pss.util.JdbcUtil;

public class MemberDAOImpl implements IMemberDAO {

    // (2)拿连接对象
    // 增加一个新成员
    @Override
    public void add(Member member) {
        Connection link = null;
        // 减PreparedStatement对象
        PreparedStatement state = null;
        // 写sql语句，由于是预编译的语句对象，sql语句里的参数值用占位符
        String sql = "INSERT INTO t_member(id,name,age) VALUES(?,?,?);";
        try {
            // (1)注册驱动
            //Class.forName(mysqlDriver);
            // (2)拿连接对象
            link = JdbcUtil.getLink();
            // (3)拿sql的预编译语句对象
            state = link.prepareStatement(sql);
            // (3.1)添加参数
            state.setLong(1,9);
            state.setString(2, "aoi");
            state.setInt(3, 16);
            // (4)执行sql语句,此时不要传入sql语句
            state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // (5)关闭资源
            JdbcUtil.close(null, state, link);
        }
    }

    // 删除一个退出的成员
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        // (2)拿连接对象
        // (3)拿语句对象
        Connection link = null;
        PreparedStatement statement = null;
        // 编写sql语句，里面参数用占位符，以后设置
        String sql = "DELETE FROM t_member WHERE id=?";
        try {
            // 获取连接对象
            link = JdbcUtil.getLink();
            // 获取语句对象
            statement = link.prepareStatement(sql);
            // 设置参数,删除id为5的信息
            statement.setLong(1, id);
            // (4)执行sql语句
            int ret = statement.executeUpdate();
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
         // (5)关闭资源
            JdbcUtil.close(null, statement, link);
        }
    }

    // 修改某一个成员的某个信息，先根据主键（id）找到该成员的记录
    @Override
    public void update(Long id, Member member) {
        // 设置sql语句
        String sql = "UPDATE t_member SET age=? WHERE id=?" ;
        // 拿连接对象
        Connection link = null;
        // 拿语句对象
        PreparedStatement state = null;
        try {
            // 拿连接对象
            link = JdbcUtil.getLink();
            // 拿语句对象
            state = link.prepareStatement(sql);
            // 设置1属性值
            state.setInt(1, member.getAge());
            state.setLong(2, id);
            // 执行sql语句
            state.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
         // (5)关闭资源
            JdbcUtil.close(null, state, link);
        }
    }

    // 根据主键（id）查某一个特定成员的信息,没有返回值，直接打印
    @Override
    public void get(Long id) {
        // 新建sql语句
        StringBuilder sbSQL = new StringBuilder("SELECT * FROM t_member WHERE id=");
        sbSQL.append(id);
        Connection link = null;
        Statement state = null;
        ResultSet rs = null;
        // 加载注册驱动
        try {
            //Class.forName(mysqlDriver);
            link = JdbcUtil.getLink();
            state = link.createStatement();
            rs = state.executeQuery(sbSQL.toString());
            // 上一步已经返回ResultSet的对象，要把它里面的列全部打印
            while (rs.next()) {
                System.out.println(rs.getLong("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 由于要关闭连接对象和语句对象，如果这两个放在try子句里面，finally子句就拿不到，所以要放在try前面
         // (5)关闭资源
            JdbcUtil.close(rs, state, link);
        }
        // 拿连接对象
        // 拿语句对象
        // 执行sql语句
        // 关闭资源
    }

    // 根据主键（id）查某一个特定成员的信息,返回Member对象
    @Override
    public Member getMember(Long id) {
        // 新建sql语句
        StringBuilder sbSQL = new StringBuilder("SELECT * FROM t_member WHERE id=");
        sbSQL.append(id);
        Connection link = null;
        Statement state = null;
        ResultSet rs = null;
        // 加载注册驱动
        try {
            //Class.forName(mysqlDriver);
            link = JdbcUtil.getLink();
            state = link.createStatement();
            rs = state.executeQuery(sbSQL.toString());
            // 上一步已经返回ResultSet的对象，要把它里面的列全部塞进一个新的Member对象里
            Member member = new Member();
            while (rs.next()) {
                member.setId(rs.getLong("id"));
                member.setAge(rs.getInt("age"));
                member.setName(rs.getString("name"));
            }
            return member;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 由于要关闭连接对象和语句对象，如果这两个放在try子句里面，finally子句就拿不到，所以要放在try前面
         // (5)关闭资源
            JdbcUtil.close(rs, state, link);
        }
        return null;
        // 拿连接对象
        // 拿语句对象
        // 执行sql语句
        // 关闭资源
    }

    // 查全部成员的信息
    @Override
    public List<Member> listAll() {
        // 要把所有信息添加进List集合，用add方法
        // 建sql语句,里面值用占位符
        String sql = "SELECT ?,?,? FROM t_member";
        Connection link = null;
        PreparedStatement statement = null;
        ResultSet rSet = null;
        List<Member> list = new ArrayList<>();
        // 加载注册驱动
        try {
            //拿连接对象
            link = JdbcUtil.getLink();
            //拿语句对象
            statement = link.prepareStatement(sql);
            //设置属性值
            statement.setString(1, "id");
            statement.setString(2, "name");
            statement.setString(3, "age");
            rSet = statement.executeQuery();
            while (rSet.next()) {
                Member member = new Member();
                member.setId(rSet.getLong("id"));
                member.setName(rSet.getString("name"));
                member.setAge(rSet.getInt("age"));
                list.add(member);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
         // (5)关闭资源
            JdbcUtil.close(rSet, statement, link);
        }
        // return null;
        // 拿连接对象
        return list;
    }
}
/**
 * 小结：熟记利用JDBC操作数据库的语句，在拼接字符串时小心单引号,空格等符号的缺失 老他妈打错字，在写sql语句，注册驱动，创建连接对象时要小心
 */
