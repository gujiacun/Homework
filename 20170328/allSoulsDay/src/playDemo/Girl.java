//需求：设计多个类，在女孩类中实现多态特征
package playDemo;

//女孩类
public class Girl {
    // 主方法
    public static void main(String[] args) {
        // Pet pet = new Pet();
        // pet.play();
        // 运用多态，通过构造器把子类对象赋给父类变量
        Pet petAnimal1 = new Dog("狗");
        Pet petAnimal2 = new Cat("猫");
        Pet petAnimal3 = new Rabbit("兔子");
        // 在运行时体现子类特征
        petAnimal1.play();
        petAnimal2.play();
        petAnimal3.play();
        // 用instanceof检测创建的对象是否为Pet父类的对象
        System.out.println(petAnimal1 instanceof Pet);
        System.out.println(petAnimal2 instanceof Pet);
        System.out.println(petAnimal3 instanceof Pet);
        // 用instanceof检测创建的对象是否为Dog类，Cat类，Rabbit类的对象
        System.out.println(petAnimal1 instanceof Dog);
        System.out.println(petAnimal2 instanceof Cat);
        System.out.println(petAnimal3 instanceof Rabbit);

    }

}
/**
 * 小结：在类中的方法，可以通过几个组合而实现各种不同的，原来没有的功能，要多加思考，同时掌握基本方法的作用
 */
