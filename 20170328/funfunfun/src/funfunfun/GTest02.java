package funfunfun;
//泛型接口
interface Father<T>{
    void say();
}
//由于是接口的实现类，可以在实现类中直接指定数据类型，也可以不指定
class Son<T> implements Father<T>{
    @Override
    public void say() {
    }
}
public class GTest02 {

    public static void main(String[] args) {
        // 在创建实现类对象时才指定数据类型
        Son<String> s = new Son();
        

    }

}
