// 需求：创建MemberDAO的测试类，测试IMember的各种与数据库交互的方法
package com._520it.pss.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com._520it.pss.dao.IMemberDAO;
import com._520it.pss.dao.impl.MemberDAOImpl;
import com._520it.pss.member.Member;

public class MemberDAOTest {
    // 测试方法，增加一个新成员
    @Test
    public void testAdd() throws Exception {
        // 建实体类的对象
        Member member01 = new Member(6, "yuka", 21);
        // 建实现类的对象
        IMemberDAO memberDAO = new MemberDAOImpl();
        memberDAO.add(member01);
    }

    // 测试方法，删除一个退出的成员
    @Test
    public void testDelete() throws Exception {
        IMemberDAO memberDAO = new MemberDAOImpl();
        memberDAO.delete(3L);
    }

    // 修改Risa的年龄信息，改为19
    @Test
    public void testUpdate() throws Exception {
        Member member = new Member();
        IMemberDAO memberDAO = new MemberDAOImpl();
        // 先把要修改的数据通过实体类的set方法传入新建的Member对象里，这样把对象传入实现类的方法中时，对象就自带数据，方法内部可以调用
        member.setAge(17);
        memberDAO.update(2L, member);
    }

    // 根据主键（id）查Manaka的信息
    @Test
    public void testGet() throws Exception {
        IMemberDAO memberDAO = new MemberDAOImpl();
        memberDAO.get(4L);
    }

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
 * 小结：在创建方法时，要仔细考虑要不要输入参数，要输入什么类型的参数，要不要返回一个值，这个值什么类型
 * 但有时也有多种方式，最重要是理解需求
 */
