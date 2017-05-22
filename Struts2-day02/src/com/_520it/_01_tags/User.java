package com._520it._01_tags;

import lombok.Data;

//需求：把实体类User的对象在iterator.jsp中塞进list集合，在jsp中显示
//（1）建User类，建字段和set/get方法
//（2）在jsp中，用<% %>写java代码，最后把list集合放进request中
//（3）用struts2的标签，迭代，导标签库，两种方法
//一。迭代出的元素放在context里；二。迭代出的元素放在root里
@Data
public class User {
    private long id;
    private String name;
    private int age;
    public User(long id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
