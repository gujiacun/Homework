package com._520it.domain;

//类必须使用public修饰
public class EmployeeTest {

    // 公共无参数构造器
    public EmployeeTest() {
    }

    // 所有字段用private修饰
    private String name;
    private String gender;
    private String idCard;
    private String job;

    // 每个字段都向外提供一对set/get方法，加入字段是boolean类型，把is方法取代get方法，set方法不变
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}
/**
 * 小结：有了IDE后，生成set/get方法变得方便，但规范仍然要记住并理解
 */