//需求：获取以hello开头的文件的后缀名
//步骤：先用正则表达式把字符串内容分拆并装成数组，用split方法
//先用startswith方法获取以hello开头的文件,由于返回值为boolean，用选择语句以此为条件。
//由于一个数组有多个元素，用for each来循环上一步的操作，逐个元素地判断
//文件名中可能有多个顿号，选最后一个后的内容，用lastIndexOf方法从最后开始搜索到最后一个顿号出现的索引号。
//用substring方法从string内容中抽取出来，开始的索引号为上一步得出的索引号
package homeworkTest;

//创建类
public class StringExercise {
    // 主方法
    public static void main(String[] args) {
        String str = "abc.java;hello.will.txt;hello.java;hello.class";
        String[] array = str.split(";");
        for (String x : array) {
            if (x.startsWith("hello")) {
                System.out.println(x.substring(x.lastIndexOf(".")));
            }
        }
       
    //把ultimatefightingchampionship的三个首字母大写并组合成一个新的单词
    //步骤：先把u，f，c三个字母用substring抽取出来并拼成一个新单词，由于StringBuilder没有转换为大写的方法，所以先转为String，再转大写
    StringBuilder oldWord = new StringBuilder("ultimatefightingchampionship");
    //创建StringBulider对象时，默认容量为16.可以手动给他配置容量，节省性能
    StringBuilder newWord = new StringBuilder(3);
    //抽取特定位置的字符串
    newWord.append(oldWord.substring(0,1));
    newWord.append(oldWord.substring(8,9));
    newWord.append(oldWord.substring(16,17));
    System.out.println(newWord.toString().toUpperCase()); 
    System.out.println(newWord.capacity());
    }
}
/**
 * 小结：在写一行复杂代码是，可以遵循从内向外，从最小功能到最大功能的方法
 */
