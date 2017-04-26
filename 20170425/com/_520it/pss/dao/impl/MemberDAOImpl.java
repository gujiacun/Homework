// 需求：此为DAO接口的实现类，实现domain对象对应的接口及里面的CRUD方法
// 这里要把上午的运用JDBC操作数据库的知识运用
package com._520it.pss.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com._520it.pss.dao.IMemberDAO;
import com._520it.pss.member.Member;

public class MemberDAOImpl implements IMemberDAO {
    // 增加一个新成员
    @Override
    public void add(Member member) {
        // (2)拿连接对象
        Connection link = null;
        Statement state = null;
        String sql = "INSERT INTO t_member(id,name,age) VALUES('" + member.getId() + "','" + member.getName() + "','"
                + member.getAge() + "')";
        try {
            // (1)注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // (2)拿连接对象
            link = DriverManager.getConnection("jdbc:mysql:///dbdemo", "root", "73619nine40");
            // (3)拿sql语句对象
            state = link.createStatement();
            // (4)执行sql语句
            state.executeUpdate(sql);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // (5)关闭资源
            try {
                if (state != null) {
                    state.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 删除一个退出的成员
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        // (2)拿连接对象
        // (3)拿语句对象
        Connection link = null;
        Statement statement = null;
        String sql = "DELETE FROM t_member WHERE id=" + id;
        try {
            // (1)注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            link = DriverManager.getConnection("jdbc:mysql:///dbdemo", "root", "73619nine40");
            statement = link.createStatement();
            // (4)执行sql语句
            int ret = statement.executeUpdate(sql);
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // (5)关闭资源
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 修改某一个成员的某个信息，先根据主键（id）找到该成员的记录
    @Override
    public void update(Long id, Member member) {
        // 设置sql语句
        String sql = "UPDATE t_member SET " + "age=" + member.getAge() + " WHERE id=" + id;
        // 拿连接对象
        Connection link = null;
        // 拿语句对象
        Statement state = null;
        try {
            // 加载注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 执行sql语句
            link = DriverManager.getConnection("jdbc:mysql:///dbdemo", "root", "73619nine40");
            state = link.createStatement();
            state.executeUpdate(sql);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // 释放资源
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (link != null) {
                try {
                    link.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
            Class.forName("com.mysql.jdbc.Driver");
            link = DriverManager.getConnection("jdbc:mysql:///dbdemo", "root", "73619nine40");
            state = link.createStatement();
            rs = state.executeQuery(sbSQL.toString());
            //上一步已经返回ResultSet的对象，要把它里面的列全部打印
            while (rs.next()) {
                System.out.println(rs.getLong("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 由于要关闭连接对象和语句对象，如果这两个放在try子句里面，finally子句就拿不到，所以要放在try前面
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (state != null) {
                    state.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
            Class.forName("com.mysql.jdbc.Driver");
            link = DriverManager.getConnection("jdbc:mysql:///dbdemo", "root", "73619nine40");
            state = link.createStatement();
            rs = state.executeQuery(sbSQL.toString());
            //上一步已经返回ResultSet的对象，要把它里面的列全部塞进一个新的Member对象里
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
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (state != null) {
                    state.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        // 建sql语句
        String sql = "SELECT id,name,age FROM t_member";
        Connection link = null;
        Statement statement = null;
        ResultSet rSet = null;
        List<Member> list = new ArrayList<>();
        // 加载注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            link = DriverManager.getConnection("jdbc:mysql:///dbdemo","root","73619nine40");
            statement = link.createStatement();
            rSet = statement.executeQuery(sql);
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
        }finally {
            if (rSet != null) {
                try {
                    rSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
            }
            if (link != null) {
                try {
                    link.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
            }
        }
        //return null;
        // 拿连接对象
        return list;
    }
}
/**
 * 小结：熟记利用JDBC操作数据库的语句，在拼接字符串时小心单引号,空格等符号的缺失 老他妈打错字，在写sql语句，注册驱动，创建连接对象时要小心
 */
