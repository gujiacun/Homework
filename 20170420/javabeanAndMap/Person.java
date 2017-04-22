package javabeanAndMap;
// 创建Person类，符合javabean规范
public class Person {

    public Person() {

    }
    private long id;
    private int age;
    private String name;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(long id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", age=" + age + ", name=" + name + "]";
    }

}
/**
 * 小结：一定要抓住Map和javabean的相识点，map的key相当于javabean的属性，map的value相当于javabean的属性值
 * 两个互换，就是通过反射获取字节码对象，据此获得BeanInfo对象，据此获得PropertyDescriptor[]，以数组每个元素
 * 得到javabean类中每个属性的名称和set/get方法，把方法invoke，在进行下一步
 */