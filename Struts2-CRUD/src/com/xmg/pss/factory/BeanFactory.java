package com.xmg.pss.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.xmg.pss.dao.IEmployeeDAO;
import com.xmg.pss.domain.Employee;
import com.xmg.pss.service.IDepartmentService;

public class BeanFactory {

	private BeanFactory() {
	}

	private static Properties p = new Properties();
	static {
		InputStream in = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("bean.properties");
		try {
			p.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static <T> T getBean(String beanName, Class<T> requiredType) {
		//根据用户指定的名称获取到对应类的全限定名
		String className = p.getProperty(beanName);
		//使用反射创建对象
		T obj = null;
		try {
			obj = (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!requiredType.isInstance(obj)) {
			throw new RuntimeException("亲,类型不正确");
		}
		return obj;
	}

	public static void main(String[] args) {
	    IEmployeeDAO dao = (IEmployeeDAO) BeanFactory.getBean("empDAO", Employee.class);
        System.out.println(dao);
	}
}
