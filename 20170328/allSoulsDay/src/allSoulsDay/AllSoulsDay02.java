//需求：做第四，第五题，复习数组，循环，调用方法的知识
package allSoulsDay;

//测试类
public class AllSoulsDay02 {
    // 主方法
    public static void main(String[] args) {
        // 第四题
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
        int x = 1;
        // 新建变量接收返回结果
        int result = AllSoulsDay02.find(array, x);
        System.out.println(result);
        // 第五题
        int[] arr1 = { 1, 3, 5, 7, 9 };
        int[] arr2 = { 2, 4, 6, 7, 8 };
        // int[][] arr3 = { arr1, arr2 };
        // 方法一：直接返回二维数组
        int[][] ret = AllSoulsDay02.arrayMerge(arr1, arr2);
        // 方法二：返回一维数组，先动态创建新数组
        int[] retArray = new int[arr1.length + arr2.length];
        // 调用静态方法，类名.方法名(参数列表);
        retArray = AllSoulsDay02.arrayMerge02(arr1, arr2, retArray);
        // 调用Arrays类的方法把数组转为String类型并输出
        String retArray1 = java.util.Arrays.toString(retArray);
        System.out.println(retArray1);
    }

    private static int[] arrayMerge02(int[] arr1, int[] arr2, int[] dest) {
        // 把旧数组元素依次赋给目标数组
        for (int i = 0; i < arr1.length; i++) {
            dest[i] = arr1[i];
        }
        // 把旧数组元素依次赋给目标数组，注意arr2的索引值为新数组索引减去arr1的索引
        for (int i = arr1.length; i < dest.length; i++) {
            dest[i] = arr2[i - arr1.length];
        }

        return dest;
    }

    private static int[][] arrayMerge(int[] arr1, int[] arr2) {
        int[][] arr3 = { arr1, arr2 };
        return arr3;
    }

    // 在类中新建方法
    static int find(int[] arr, int x) {
        // 注意小于数组长度
        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i]) {
                return i;
            }
        }
        // 方法一定要一个返回值，表示在数组中找不到所需元素，返回-1
        return -1;
    }
}
/**
 * 小结：操作数组的方法在java.util.Arrays中，注意格式
 */