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
import src.com._520it.pss.util.JdbcTemplate;
import src.com._520it.pss.util.JdbcUtil;

public class MemberDAOImpl implements IMemberDAO {

    // (2)拿连接对象
    // 增加一个新成员
    @Override
    public void save(Member member) {

        // 写sql语句，由于是预编译的语句对象，sql语句里的参数值用占位符
        String sql = "INSERT INTO t_member(id,name,age) VALUES(?,?,?);";
        // 传入参数，数组里面的元素个数可变
        Object[] array = new Object[] { member.getId(), member.getName(), member.getAge() };
        // 调用jdbc模板的方法
        JdbcTemplate.saveAndUpdate(sql, array);

    }

    // 删除一个退出的成员
    @Override
    public void delete(Long id) {

        // 编写sql语句，里面参数用占位符，以后设置
        String sql = "DELETE FROM t_member WHERE id=?";
        // 传入参数，数组里面的元素个数可变
        Object[] array = new Object[] { id };
        // 调用jdbc模板的方法
        JdbcTemplate.saveAndUpdate(sql, array);

    }

    // 修改某一个成员的某个信息，先根据主键（id）找到该成员的记录
    @Override
    public void update(Long id, Member member) {
        // 设置sql语句
        String sql = "UPDATE t_member SET age=? WHERE id=?";
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

    // 修改某一个成员的某个信息，先根据主键（id）找到该成员的记录
    @Override
    public void update(Member member) {
        // 设置sql语句
        String sql = "UPDATE t_member SET age=? WHERE id=?";
        // 设置参数
        Object[] array = new Object[] { member.getAge(), member.getId() };
        // 调用方法
        JdbcTemplate.saveAndUpdate(sql, array);

    }

    // 根据主键（id）查某一个特定成员的信息,返回Member对象
    @Override
    public Member getMember(Long id) {
        // 新建sql语句
        String sql = new String("SELECT * FROM t_member WHERE id= ?");
        // 新建参数
        Object[] array = new Object[]{id};
        // 调用模板中的方法，接收并强转
        List<Member> list = null;
        try {
            list = JdbcTemplate.query(sql, array);
            return list.size() == 1?list.get(0):null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 由于这里是查询单人，所以用三目运算符判断是否为单人
        // 拿连接对象
        // 拿语句对象
        // 执行sql语句
        // 关闭资源
        return null;
    }

    // 查全部成员的信息
    @Override
    public List<Member> listAll() {
        // 要把所有信息添加进List集合，用add方法
        String sql = "SELECT id,name,age FROM t_member";
        // 设置参数
        Object[] array = new Object[]{};
        // 调用
        List<Member> list;
        try {
            list = JdbcTemplate.query(sql, array);
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
        // 拿连接对象
    }
}
/**
 * 小结：熟记利用JDBC操作数据库的语句，在拼接字符串时小心单引号,空格等符号的缺失 老他妈打错字，在写sql语句，注册驱动，创建连接对象时要小心
 */
