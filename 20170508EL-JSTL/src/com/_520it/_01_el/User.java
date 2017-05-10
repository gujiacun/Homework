package com._520it._01_el;

import java.util.Arrays;
import java.util.HashMap;
//需求：建User类（并给它赋值），再建el.jsp，用EL表达式访问这类的对象中的属性并输出
import java.util.List;
import java.util.Map;

public class User {
    public User() {

    }

    private String name = "Mayi";
    private Integer age = 24;
    String[] hobby = { "nogizaka", "keyakizaka" };
    List<String> list = Arrays.asList(hobby);
    Map<String, String> map = new HashMap<String, String>() {
        private static final long serialVersionUID = 1L;

        {
            this.put("name", "Hirate");
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + ", hobby=" + Arrays.toString(hobby) + ", list=" + list + ", map="
                + map + "]";
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
