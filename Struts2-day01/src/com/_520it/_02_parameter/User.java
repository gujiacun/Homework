package com._520it._02_parameter;

public class User {
    public User() {
    }

    private String username;
    private Integer age;
    @Override
    public String toString() {
        return "User [username=" + username + ", age=" + age + "]";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
