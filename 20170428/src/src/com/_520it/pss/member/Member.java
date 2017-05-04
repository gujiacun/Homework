// 需求：建javabean的domain类
package src.com._520it.pss.member;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Member {
    public Member() {

    }

    private long id;
    private String name;
    private int age;

    public Member(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
/**
 *小結：合理运用第三方插件，使代码可读性大幅提高
 */
