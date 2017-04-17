//需求：BasketballPlayer类中的方法，其他球类运动员也可以用到
//所以我们把共同的方法抽取出来，形成数组结构工具类，以后其他球类运动员从工具类中调用方法
//把工具类的方法定义为实例方法，以后其他类创建对象来调用
package arrayTest;

import java.util.Arrays;

//工具类
public class PlayerList {
    // 用新建数组，模拟上场球员的球衣编号的存储,实例方法
    private Integer[] team = null;// 先声明
    // 建变量，存储球队的人数,默认为0
    private int amount = 0;

    // 1):初始容量为initialCapacity的线性列表,准备用来存储场上的球衣号码.
    // 分析：由于此时球员没上场（没添加元素），动态创建数组
    public void init(int initialCapacity) {
        // 检测索引值
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("请重新输入");
        }
        // 动态创建数组格式为 数组类型[] 数组名 = new 数组类型[元素个数];
        team = new Integer[initialCapacity];
    }

    // 2):逐个安排球员上场，给数组添加元素，playerNum为球员球衣编号
    public void add(Integer playerNum) {
        if (amount == team.length) {
            Integer[] temp = Arrays.copyOf(team, team.length * 2);
            team = temp;
        }
        // 注意形式参数的名称，不要犯低级错误
        team[amount] = playerNum;
        // 由于定义了球员人数为0，而添加元素会令数组索引加1，新元素不断在数组的新位置被添加
        amount++;
    }

    // 3):查询指定位置的球员的球衣号码是多少.查询索引位置为4的球衣号码是:55.
    public int find(int i) {
        // 检测索引值，若小于0或大于人数，抛出错误
        if (i < 0 || i > +amount) {
            throw new IllegalArgumentException("请重新输入");
        }
        int playerNumber = team[i];
        return playerNumber;
    }

    // 4):根据球衣号码查询该球员在场上的索引位置
    public int findIndex(Integer playerNum) {
        // 用equals把传入内容与数组中的所有内容作比较，用for循环逐个判断
        for (int i = 0; i < amount; i++) {
            // 如果传入元素与数组中的某个元素相等，输出某元素的索引
            if (playerNum.equals(team[i])) {
                return i;
            }
        }
        return -1;
    }

    // 5):替换场上索引位置为index的球员,替换之后该位置的球衣编号为newPlayerNum. 给数组元素重新赋值
    public void change(int index, Integer newPlayerNum) {
        if (index < 0 || index > +amount) {
            throw new IllegalArgumentException("请重新输入");
        }
        team[index] = newPlayerNum;
    }

    // 6):替换球衣号码为oldPlayerNum的球员,替换之后为newPlayerNum.
    public void update(Integer oldPlayerNum, Integer newPlayerNum) {
        int index = findIndex(oldPlayerNum);
        change(index, newPlayerNum);
    }

    // 7):把场上索引位置为index的球衣罚下场(注意:罚下,没有补位.).
    public void delete(int index) {
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
    public void print() {
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

    }
}
/**
 * 小结：把数组工具类中的主要方法自己模拟一边，还有些重载方法，不仅要会用工具，还知道工具的原理，以防
 * 以后需要自行搭建工具类
 */
