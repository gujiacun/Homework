package dao;

import java.util.List;

import domain.Employee;

public interface IEmployeeDAO {
    //增,插入一个domain类的对象
    void save(Employee employee);
    //删，删去指定id的一条数据
    void delete(Long id);
    //改，更新雇员的某些信息，在测试类中要用set传入待更新的数据
    void update(Employee employee);
    //查单个,根据id返回雇员的单个对象
    Employee get(Long id);
    //查全部
    List<Employee> listAll();
}
/**
 * 小结：生成某方法的文档注释，光标移动到该方法中，alt+shift+j
 * 接口都是抽象方法，没有方法体
 */
