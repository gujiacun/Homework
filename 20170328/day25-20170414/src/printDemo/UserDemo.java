package printDemo;

import java.io.Serializable;

public class UserDemo implements Serializable{

    private static final long serialVersionUID = 3527509191671163421L;
    
    private String name;
    // 当我们不希望密码也做序列化时，用transient瞬态来修饰字段
    // 加上后，密码没有被从测试类主方法中加载进User类中，显示为null
    transient private String password;
    private int age;
    public UserDemo(String name,String password,int age){
        this.name = name;
        this.password = password;
        this.age = age;
    }
    //重写toString方法
    @Override
    public String toString() {
        return "User: name=" + name + " password=" + password + " age" + age;
    }
}
