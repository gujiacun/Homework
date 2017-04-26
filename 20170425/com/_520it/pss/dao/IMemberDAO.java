// 需求：创建数据访问接口，里面有操作Member类的抽象方法，与数据库进行交互，减少代码重读
// 需求：编写domain对象对应的接口及里面的CRUD方法
package com._520it.pss.dao;

import java.util.List;

import com._520it.pss.member.Member;

public interface IMemberDAO {
    // 增加一个新成员,需要传入实体类的对象
    /**
     * @param member 增加一个新成员,需要传入实体类的对象
     */
    public void add(Member member);

    // 删出一个退出的成员,先得根据id（主键）找到该成员
    /**
     * @param id 删出一个退出的成员,先得根据id（主键）找到该成员
     */
  
    public void delete(Long id);

    // 修改某一个成员的某个信息，先根据主键（id）找到该成员的记录
    // 由于Member类是实体类，里面封装了大量数据，修改信息需要表中的列名（实体类的数据），所以需要传入实体类对象
    /**
     * @param id 删出一个退出的成员,先得根据id（主键）找到该成员
     * @param member 由于Member类是实体类，里面封装了大量数据，修改信息需要表中的列名（实体类的数据），所以需要传入实体类对象
     */
    public void update(Long id,Member member);

    // 根据主键（id）查某一个特定成员的信息
    /**
     * @param id根据主键（id）查某一个特定成员的信息
     */
    public void get(Long id);

    // 根据主键（id）查某一个特定成员的信息
    /**
     * @param id根据主键（id）查某一个特定成员的信息
     */
    public Member getMember(Long id);
    // 查全部成员的信息
    /**
     * @return 查全部成员的信息,用List集合包装所有的数据
     */
    public List<Member> listAll();
}
/**
 * 小结：生成某方法的文档注释，光标移动到该方法中，alt+shift+j
 * 接口都是抽象方法，没有方法体
 */
