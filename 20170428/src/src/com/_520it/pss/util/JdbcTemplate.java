// 需求：一。对DML进行方法的抽取（MemberDAOImpl的save方法和update方法和delete方法）
//（1）把共同代码抽取出来
//（2）sql语句各个方法不同，由调用者传入。剩下设置参数一部分，由于参数是由sql语句决定
//也由调用者传入。由于参数个数/类型不定，用Object[]的可变参数
//二。对DQL方法（查询单个/全部）进行抽取(2b青年版本)
package src.com._520it.pss.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import src.com._520it.pss.member.Member;

public class JdbcTemplate {
    //save方法和update方法同属于DML方法，都要拿连接对象，拿语句对象，执行sql语句，关闭资源，把他们抽象到这里
    //由于参数类型不定，用Object，个数不定，用数组的可变参数
    public static void saveAndUpdate(String sql,Object...array) {
        //拿连接对象
        Connection link = null;
        // 拿语句对象
        PreparedStatement state = null;
        try {
            // 拿连接对象
            link = JdbcUtil.getLink();
            // 拿sql的预编译语句对象
            state = link.prepareStatement(sql);
            // (3.1)添加参数,由调用者传入,用循环把所有的参数由语句对象添加
            for (int i = 0; i < array.length; i++) {
                state.setObject(i+1, array[i]);
            }
            // (4)执行sql语句,此时不要传入sql语句
            state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // (5)关闭资源
            JdbcUtil.close(null, state, link);
        }
    }
    
    
    //对DQL的抽取,单/多个查询都要把结果放到List集合里
    //建sql语句，由于单个查询和全部查询的语句不同，无法整合，所以sql语句有调用者传入
    public static List<Member> query(String sql,Object...array) throws Exception{
        //拿连接对象
        Connection link = JdbcUtil.getLink();
        //拿语句对象
        PreparedStatement state = link.prepareStatement(sql);
        //循环设置参数，参数由sql语句决定，无法确定类型/数量，由调用者传入
        for (int j = 0; j < array.length; j++) {
            state.setObject(j+1, array[j]);
            
        }
        //执行语句，返回ResultSet对象
        ResultSet rs = state.executeQuery();
        List<Member> list = new ArrayList();
        //循环把结果添加至list集合
        while (rs.next()) {
            //list里存的应该是实体类的各个对象，即数据库表中的一行行
            Member member = new Member();
            //把结果集里的数据通过set方法传入到实体类的对象里
            member.setId(rs.getLong("id"));
            member.setName(rs.getString("name"));
            member.setAge(rs.getInt("age"));
            //把对象添加至list集合
            list.add(member);
        }
        //关闭资源
        JdbcUtil.close(rs, state, link);
        //由于单个查询返回实体类对象，全部查询返回List集合，统一返回List，单个的自行拿出来
        return list;
        
    }
    
}
/**
 * 小结：DML插入/更新/删除数据。DDL创建/删除表。DQL查询数据。老是忘记，加强记忆。
 */
