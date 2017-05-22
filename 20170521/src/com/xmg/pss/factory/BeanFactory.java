package com.xmg.pss.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.xmg.pss.dao.IDepartmentDAO;
import com.xmg.pss.dao.IEmployeeDAO;
import com.xmg.pss.dao.impl.DepartmentDAOImpl;
import com.xmg.pss.dao.impl.EmployeeDAOImpl;
import com.xmg.pss.domain.Employee;

import lombok.Setter;

//在action中，假如有多个EmployeeServiceImpl要实现接口并创建对象，那么action中的代码就要改
//用工厂设计方法，把需要创建对象的类放在配置文件中，用DAOFactory加载配置文件的内容并创建对象，需要哪个就创建哪个
//（1）建factory包，DAOFactory类，设计为单例
//（2）私有化构造器，提供公共静态的返回DAO的方法，方法参数为DAO类的名字，假如用户输入DAO类的名字与本地的相匹配，返回该DAO实现类的对象
//(3)由于在上面的步骤中DAO类的名字是有限而且修改很麻烦，放进配置文件中
//（4）建bean.properties,里面放       DAO类的名字简写=类的全限定名
//（5）在工厂类getDAO方法中，用静态代码块加载属性配置文件，在getDAO方法中根据用户传入的类名拿类的全限定名返回该类的对象
//(6)在EmployeeServiceImpl中private IEmployeeDAO dao = DAOFactory.getDAO("employee",IEmployeeDAO.class);
//以后只需改变bean.properties中的配置
//额外补充：(7)建beans.xml，建<beans><bean>,放id，class全限定名，
//<bean id="department" class="com.xmg.pss.dao.impl.DepartmentDAOImpl" type="singleton">
//<property id="employee" ref="employee" />
//</bean>
//额外补充：(8)在DepartmentDAOImpl 建IEmployeeDAO employeeDAO;提供@Setter方法


public class BeanFactory {
    private BeanFactory() {
    }

    // 一定要加static，因为只有成员字段才能被非静态成员使用
    static Properties p = new Properties();
    static {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("bean.properties");
        try {
            p.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 让用户传入该类的类型
    public static <T> T getBean(String daoName, Class<T> clz)
            {
        // if ("employee".equals(daoName)) {
        // return new EmployeeDAOImpl();
        // } else if ("department".equals(daoName)) {
        // return new DepartmentDAOImpl();
        // }
        // return null;
        String className = p.getProperty(daoName);
        T obj = null;
        try {
            obj = (T) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (!clz.isInstance(obj)) {
            throw new RuntimeException("类型错误");
        }
        return obj;
    }

    // 测试
    public static void main(String[] args)
            throws Exception {
        IEmployeeDAO dao = (IEmployeeDAO) BeanFactory.getBean("employee", Employee.class);
        System.out.println(dao);
    }

}
