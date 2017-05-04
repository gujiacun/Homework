//步骤：(1)在navicat按要求建表
//(2)在java建资源文件夹，建配置文件，注意属性名字
//(3)建包，类，搞定实现关系domain,dao和impl,util和jdbcutil和jdbatemplate,
//handler和iresultsethandler和benhandler和beanlisthandler,test
//(4)写domain实体类，注意与表一一对应,toString
//(5)写DAO接口的增删改，查单/查全方法，
//(6)写Impl实现类的重写方法，DML方法指定sql语句和object数组的可变参数，调用jdbctemplate的一个方法
//DQL方法指定sql语句，指定处理结果集类的对象和domain的字节码对象，指定object数组的可变参数，调用jdbctemplate的两个方法
//(7)写jdbcutil的两个静态方法：通过druid连接池拿connection对象;判断资源为空并关闭
//(8)写jdbctemplate，DML方法，DQL方法，先设连接对象和语句对象，再用try-catch-finally包围，try里拿连接对象和语句对象，for循环给语句对象赋值，执行语句对象，在finally调idbcutil的关资源方法，
//两者得到结果集对象后，用之调用beanhandler/benlisthandler方法
//(9)写iresultsethandler的handle方法，定义泛型T，方法返回值也是T
//(10)benhandler指定泛型/重写方法返回值为domain类，声明泛型T的Class具体类型clz,建公共构造器要求传入domain类的字节码对象,赋值
//重写方法，通过反射建T类型的对象，if判断结果集对象.next(),里面用Introspector拿clz的beaninfo对象，再拿所有属性数组
//在if里(若是查全部用while)用for-e循环(所有属性数组)，用object和getName拿列名，通过列名拿结果集里某列的值rs.getObject(columnName.toString)，拿属性的set方法对象，以方法对象invoke
//在if语句外返回T类型的对象
//(11)测试类，建实现类对象，建四个方法，方法内建domain类对象并传入参数
//要传入set值，若是DML方法要指定beanhandler/beanlisthandler新对象的泛型及传入DAO的class属性
package domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {
    public Employee() {

    }

    private long id;
    private String name;
    private String email;
    private double salary;

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + "]";
    }

}
