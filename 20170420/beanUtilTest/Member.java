package beanUtilTest;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Member {
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public long getAge() {
//        return age;
//    }
//
//    public void setAge(long age) {
//        this.age = age;
//    }

    public Member() {

    }

    private String name;
    private long age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member [name=" + name + ", age=" + age + "]";
    }
    
}
