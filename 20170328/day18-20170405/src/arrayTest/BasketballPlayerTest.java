//需求：模拟一支篮球队，教练存储队员信息，查询，替换球员，球员被罚下场
//实质是对数组进行初始化，添加数组元素，根据元素索引/元素内容 返回  元素内容/元素索引，替换元素，打印数组等
package arrayTest;

import java.util.Arrays;

//测试类
public class BasketballPlayerTest {
    // 用新建数组，模拟上场球员的球衣编号的存储,用static修饰，表示字段属于类，在下方的方法直接访问
    private static Integer[] team = null;// 先声明
    // 建变量，存储球队的人数,默认为0
    private static int amount = 0;

    // 1):初始容量为5的线性列表,准备用来存储场上的5个球衣号码.
    // 分析：由于此时球员没上场（没添加元素），动态创建数组
    public static void init(int initialCapacity) {
        // 动态创建数组格式为 数组类型[] 数组名 = new 数组类型[元素个数];
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("请重新输入");
        }
        team = new Integer[initialCapacity];
    }

    // 2):安排5个球员上场:[11,22,33,44,55].给数组添加元素
    public static void add(Integer playerNum) {
        if (amount == team.length) {
            Integer[] temp = Arrays.copyOf(team, team.length * 2);
            team = temp;
        }
        // 注意形式参数的名称，不要犯低级错误
        team[amount] = playerNum;
        // 由于定义了人数为0，而添加元素会令数组索引加1，新元素不断在数组的新位置被添加
        amount++;
    }

    // 3):查询指定位置的球员的球衣号码是多少.查询索引位置为4的球衣号码是:55.
    public static int find(int i) {
        if (i < 0 || i > +amount) {
            throw new IllegalArgumentException("请重新输入");
        }
        int playerNumber = team[i];
        return playerNumber;
    }

    // 4):根据球衣号码查询该球员在场上的索引位置. 44球衣号的球员在场上的索引位置是:3.
    public static int findIndex(Integer playerNum) {
        // 用equals把传入内容与数组中的所有内容作比较，用for循环逐个判断
        for (int i = 0; i < amount; i++) {
            // 如果传入元素与数组中的某个元素相等，输出某元素的索引
            if (playerNum.equals(team[i])) {
                return i;
            }
        }
        return -1;
    }

    // 5):替换场上索引位置为2的球员,替换之后该位置的球衣编号为333. 333把33替换了.
    public static void change(int index, Integer newPlayerNum) {
        if (index < 0 || index > +amount) {
            throw new IllegalArgumentException("请重新输入");
        }
        team[index] = newPlayerNum;
    }

    // 6):替换球衣号码为22的球员,替换之后为222.
    public static void update(Integer oldPlayerNum, Integer newPlayerNum) {
        int index = findIndex(oldPlayerNum);
        change(index, newPlayerNum);
    }

    // 7):把场上索引位置为2的球衣罚下场(注意:罚下,没有补位.).
    public static void delete(int index) {
        if (index < 0 || index > +amount) {
            throw new IllegalArgumentException("请重新输入");
        }
        // 步骤：（1）把index后面的元素集体向前移动1位
        // （2）最后的元素设为null
        // （3）上场球员个数减1
        // 由于最后一个元素要被设置为null，所以i < amount - 1
        for (int i = index; i < amount - 1; i++) {
            team[i] = team[i + 1];
        }
        team[amount - 1] = null;
        amount--;
    }

    // 8):按照球员在场上的位置,打印出球衣号码,打印风格:[11,22,33,44,55].
    public static void print() {
        // 假如数组为空，返回null，假如数组还没传入元素，返回[]
        if (team == null) {
            System.out.println("Null");
        }
        if (amount == 0) {
            System.out.println("[]");
        }
        // 数组不空，先动态新建StringBuilder
        // StringBuilder底层是char数组，一个字符是一个位置
        StringBuilder str = new StringBuilder(amount * 3 + 1);
        str.append("[");
        // 用for循环把数组元素全都循环出来，并拼接到str中
        for (int i = 0; i < amount; i++) {
            str.append(team[i]);
            // 假如不是最后一个元素，就在此元素与下一个元素之间加逗号
            if (i != amount - 1) {
                str.append(",");
            } else {
                // 是最后一个元素就加]
                str.append("]");
            }

        }
        // 循环结束后，把数组转为String类型并打印
        System.out.println(str.toString());
    }
    // 主方法

    public static void main(String[] args) {
        // 调用1）的方法，球队有5人，设为静态方法，用类名掉用
        // 调用初始化方法，传入数组的长度
        BasketballPlayerTest.init(5);
        // 调用2）的方法，安排身穿不同球衣号码的球员上场，即为数组添加元素
        BasketballPlayerTest.add(11);
        BasketballPlayerTest.add(22);
        BasketballPlayerTest.add(33);
        BasketballPlayerTest.add(44);
        BasketballPlayerTest.add(55);
        // 调用3）方法，查询索引位置为4的球衣号码是多少？
        // int result = BasketballPlayerTest.find(4);
        // System.out.println(result);
        // 调用4）方法，根据元素内容获取该元素的索引，传入元素内容，返回int类型的索引
        // int retIndex = BasketballPlayerTest.findIndex(44);
        // System.out.println(retIndex);
        // 调用5）方法，把某索引的旧元素替换为新元素
        // BasketballPlayerTest.change(2, 333);
        // BasketballPlayerTest.print();
        // System.out.println();
        // 调用6）方法，
        // BasketballPlayerTest.update(22, 222);
        // BasketballPlayerTest.print();
        // 调用7）方法
        // BasketballPlayerTest.delete(2);
        // 调用8）方法
        BasketballPlayerTest.print();

        // 若传入的索引值不合法，抛出异常

        // 新需求：当前数组只能存储5个元素，且已经塞满，此时要再增添一个元素
        // 步骤：（1）在调用2）方法，为数组增添元素时判断容量是否等于数组长度
        // 若是，则表示数组需要扩容
        // （2）把旧数组元素全部拷贝到新数组中（Arrays.copyOf方法）
        // （3）把新数组传回给旧数组，再添加新元素
        BasketballPlayerTest.add(505);
        // 打印增添新元素后的新数组
        BasketballPlayerTest.print();

    }
}

/**
 *小结：操作数组这一数据结构，实施增删查改，要注意对数组索引值进行检测，以防越界 
 */