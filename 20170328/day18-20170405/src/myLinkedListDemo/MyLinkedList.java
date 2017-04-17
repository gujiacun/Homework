//需求：此类为链表类
package myLinkedListDemo;

//表示双向链表
public class MyLinkedList {
    // 双向链表本身有字段,用private修饰
    // 表示链表第一个节点
    protected Node first;
    // 表示链表最后一个节点
    protected Node last;
    // 表示总节点个数
    private int size;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    // 双向链表中的每个节点
    public class Node {
        // 每个节点都有prev，next和所存储的数据
        Node prev;
        Node next;
        public Object ele;

        // 通过构造器把要存储的数据输入节点内
        public Node(Object ele2) {
            // TODO Auto-generated constructor stub
            this.ele = ele2;
        }
    }

    // 在主方法新建一个节点，在双向链表的末尾插入,ele表示要存储的数据
    public void addLast(Object ele) {
        // 创建节点对象
        Node node = new Node(ele);
        // 需要判断插入的节点是否为链表中唯一的一个节点
        if (size == 0) {
            // 假如为0，即新建节点是链表中唯一节点
            this.first = node;
            this.last = node;
        } else {
            // 链表中已存在节点，在原有的最后一个节点后塞进新建的节点
            // (1)原最后节点的next起先是null，现在有了值
            this.last.next = node;
            // (2)新建节点的prev现在也成为了原最后节点
            node.prev = this.last;
            // (3)把新增节点作为链表中新的最后节点
            this.last = node;
        }
        // 在有新建节点插入时，总节点数会增加1
        size++;
    }

    // 在主方法新建一个节点，在双向链表的头部插入,ele表示要存储的数据
    public void addFirst(Object ele) {
        // 创建节点对象,在类Node中通过构造器传入节点所要存储的数据
        Node node = new Node(ele);
        // 假如新建的节点是链表中唯一的对象？
        if (size == 0) {
            this.first = node;
            this.last = node;
        } else {
            // 链表中已存在节点，在原有的第一个节点前塞进新建的节点
            // （1）原先第一节点的prev是null，现在是node
            this.first.prev = node;
            // （2）原先新建节点的next是null，现为原先第一节点
            node.next = this.first;
            // (3)现在链表的第一个节点为新建节点
            this.first = node;
        }
        // 在有新建节点插入时，总节点数会增加1
        size++;
    }

    // 打印节点中所有的元素
    @Override
    public String toString() {
        // 假如总节点个数为0，返回"[]"
        if (size == 0) {
            System.out.println("[]");
        }
        // 把所有节点中存储的数据都转为StringBuilder类型，循环遍历，拼接输出
        // 由于事先不知道str的元素个数，用动态创建
        StringBuilder str = new StringBuilder(size * 2 + 1);
        str.append("[");
        // 要拼接所有节点的数据，先从第一个节点开始
        // 注意在循环开始前定义节点对象，循环里的拼接会先拼第一个节点里的数据
        Node current = this.first;
        for (int i = 0; i < size; i++) {
            // 假如当前节点不是最后一个，在两个节点之间加逗号
            str.append(current.ele);
            if (i != size - 1) {
                str.append(",");
                // 假如当前节点是最后一个，在最后节点元素后加]
            } else {
                str.append("]");
            }
            // 拼接节点中存储的元素
            // 由于要拼接所有节点的数据，current必须从第一个一直到最后一个
            current = current.next;
        }
        return str.toString();
    }

     //删除操作
    public void remove(Object ele) {
        // 由于链表没有索引，只能根据元素内容来遍历链表，先找到需要被删除的元素，再删除
        //从第一个节点去找
        Node current = this.first;
        for (int i = 0; i < size; i++) {
            //假如输入内容与当前节点的数据不符，继续找下一个节点的
            if (!current.ele.equals(ele)) {
                //假如已经找到最后一个节点，返回
                if (current.next == null) {
                    return;
                }
                current = current.next;
            }
        }
        //System.out.println("current" + current);
        
        
        //正式删除节点
        //(1)当要被删除的节点是链表的第一个节点时
        if (current == first) {
            //由于是删除，直接把删除节点的下一个节点赋给链表的第一个节点
            this.first = current.next;
            //把新的第一个节点的prev清空
            this.first.prev = null;
            //(2)当要被删除的节点是链表的最后一个节点时
        }else if (current == last){
          //由于是删除，直接把删除节点的上一个节点赋给链表的最后一个节点
            this.last = current.prev;
            //把新的最后一个节点的next清空
            this.last.next = null;
            //(3)当要被删除的节点是链表的中间节点时
        }else{
            current.next.prev = current.prev;
            current.prev.next = current.next;
        }
        //删除后，总节点数减1
        size--;
    }
}
/**
 *小结：链表时，一定要画图，可以把prev，next看成是每个节点的属性 。拼字符串输出时，把定义节点对象放在循环前
 */