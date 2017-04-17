package test;

enum SomeThing0000 {
    INSTANCE;
    private SomeThing0000 instance;
    public SomeThing0000 getInstance() {
        return instance;
    }

}

class Test000000{
    public static void main(String[] args) {
        SomeThing0000 instance = SomeThing0000.INSTANCE.getInstance() ;
    }
}