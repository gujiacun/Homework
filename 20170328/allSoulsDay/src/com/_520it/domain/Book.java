package com._520it.domain;

//类必须使用public修饰
public class Book {

    // 公共无参数构造器
    public Book() {
    }

    // 所有字段用private修饰
    private String author;
    private String name;
    private String publishing;

    // 每个字段都向外提供一对set/get方法，加入字段是boolean类型，把is方法取代get方法，set方法不变
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }
}
/**
 * 小结：把字段设为私有，保证只能在类中访问
 */