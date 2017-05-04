// 需求：创建MemberDAO的测试类，测试IMember的各种与数据库交互的方法
// 在原有基础上，把原有的代码重构设计，把重复的代码封装成另一个类，以后要写几十个方法，操作几百张表时减少代码量
// 把Statement对象转换为PreparedStatement对象
package src.com._520it.pss.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import src.com._520it.pss.dao.IMemberDAO;
import src.com._520it.pss.dao.impl.MemberDAOImpl;
import src.com._520it.pss.member.Member;

public class MemberDAOTest {
    // 测试方法，增加一个新成员
    @Test
    public void testSave() throws Exception {
        // 建实体类的对象
        Member member01 = new Member(13, "Nanamin", 22);
        // 建实现类的对象
        IMemberDAO memberDAO = new MemberDAOImpl();
        memberDAO.save(member01);
    }

    // 测试方法，删除一个退出的成员
    @Test
    public void testDelete() throws Exception {
        IMemberDAO memberDAO = new MemberDAOImpl();
        memberDAO.delete(6L);
    }

    // 修改Risa的年龄信息，改为18
    @Test
    public void testUpdate() throws Exception {
        Member member = new Member();
        IMemberDAO memberDAO = new MemberDAOImpl();
        // 先把要修改的数据通过实体类的set方法传入新建的Member对象里，这样把对象传入实现类的方法中时，对象就自带数据，方法内部可以调用
        member.setAge(17);
        member.setId(4L);
        memberDAO.update(member);
    }

    // 根据主键（id）查Manaka的信息
//    @Test
//    public void testGet() throws Exception {
//        IMemberDAO memberDAO = new MemberDAOImpl();
//        memberDAO.get(4L);
//    }

    // 根据主键（id）查Manaka的信息
    @Test
    public void testGetMember() throws Exception {
        IMemberDAO memberDAO = new MemberDAOImpl();
        Member member = memberDAO.getMember(4L);
        System.out.println(member.toString());
    }

    // 查所有人信息
    @Test
    public void testListAll() throws Exception {
        IMemberDAO memberDAO = new MemberDAOImpl();
        List<Member> list = memberDAO.listAll();
        for (Member member : list) {
            System.out.println(member);
        }
    }
}
/**
 * 小结：
 * Statement表示静态SQL语句的对象，在建String时已经把SQL里面的参数值设置好
 * PreparedStatement表示预编译的SQL语句对象，建String时里面的参数只用占位符?表示，
 * 在后面语句中再设置具体的值
 */
