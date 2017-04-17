package funfunfun;

public class GenericMethodDemo {

    public static void main(String[] args) {
        String[] array = { "a", "s", "d" };
        tell(array);
    }

    public static <T> void tell(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
