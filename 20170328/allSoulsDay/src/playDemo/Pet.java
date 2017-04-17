package playDemo;

public class Pet {
    String name;
    
    public Pet(String name) {
        this.name = name;
    }


    public void play() {
        System.out.println("女孩在和宠物" + this.name + "玩");
    }

//    public void play(Pet pet) {
//        System.out.println("女孩在和宠物" + pet + "玩");
//    }

}
