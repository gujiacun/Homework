package test;

public class MainTest {

    public static void main(String[] args) {
        Food food = new Food();
        new Thread(new Cook(food)).start();
        new Thread(new Eater(food)).start();
    }

}
