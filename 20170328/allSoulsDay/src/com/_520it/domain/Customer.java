//创建类，记忆javaBen规范
/**
 * 1):类必须使用public修饰.
   2):必须保证有公共无参数构造器.
   3):所有字段用private修饰
   4):并且每个字段都向外提供一对set/get方法
 */
package com._520it.domain;

//类必须使用public修饰
public class Customer {
    // 公共无参数构造器
    public Customer() {

    }

    // 所有字段用private修饰
    private String name;
    private String company;
    private String address;

    // 每个字段都向外提供一对set/get方法，加入字段是boolean类型，把is方法取代get方法，set方法不变
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
/**
 * 小结：有了IDE后，生成set/get方法变得方便，但规范仍然要记住并理解
 */