//需求：用set存一个班级的学生，map存一个学院的多个班级，list存一个学校的多个学院
package mapDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
//学生类
class Student{
    String name;
    int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class List_Map_Set_Combine {
    //主方法
    public static void main(String[] args) {
        //创建班级01，指定泛型，只能传入Student类的对象
        Set<Student> classroom01 = new HashSet<>();
        //创建学生对象
        Student kid01 = new Student("A", 12);
        Student kid02 = new Student("B", 13);
        Student kid03 = new Student("C", 14);
        //传入元素，班级01有三个学生
        classroom01.add(kid01);
        classroom01.add(kid02);
        classroom01.add(kid03);
        
        //创建班级02，指定泛型，只能传入Student类的对象
        Set<Student> classroom02 = new HashSet<>();
        //创建学生对象
        Student girl01 = new Student("a", 12);
        Student girl02 = new Student("b", 13);
        Student girl03 = new Student("c", 14);
        //传入元素，班级01有三个学生
        classroom02.add(girl01);
        classroom02.add(girl02);
        classroom02.add(girl03);
        
        //创建Map对象（学院01），输入课室对象
        Map<Integer,Set<Student>> college01 = new HashMap<>();
        college01.put(1, classroom01);
        college01.put(2, classroom02);
        //创建Map对象（学院02），输入课室对象
        Map<Integer,Set<Student>> college02 = new HashMap<>();
        college02.put(1, classroom01);
        college02.put(2, classroom02);
        
        //创建List对象（学校），输入学院对象
        List<Map<Integer,Set<Student>>> school = new ArrayList<>();
        school.add(college01);
        school.add(college02);
        System.out.println(school);
    }
    
/**
 * 小结：List，Map和Set视情况混合使用
 */
}
