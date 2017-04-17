package funfunfun;

//在泛型类这里不明确指明它的类型
class Info<T> {
    private T take;
    public T getTake() {
        return take;
    }
    public void setTake(T take) {
        this.take = take;
    }
    @Override
    public String toString() {
        return this.getTake().toString();
    }
}

public class GTest {
    public static void main(String[] args) {
        Info<String> i = new Info<String>();
        i.setTake("谈笑风生");
        // 调用tell方法，假如想在调用时才指定数据类型，在方法中用通配符
        GTest.tell(i);
    }

    // 通配符：？ 无论什么类型都能指定
    public static void tell(Info<?> i) {
        System.out.println(i);
    }
}
