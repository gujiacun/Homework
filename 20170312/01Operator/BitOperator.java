//需求：把所有位运算符号操作一遍
//声明一个类，叫BitOperator 
class BitOperator {
	//声明主方法
	public static void main(String[] args) {
		//先操作按位与 & ，有0为0，全1为1
		int a = 52;
		int b = 98;
		int c = a & b;
		System.out.println(c);
		//再操作按位或 | ，有1为1，全0为0
		c = a | b;
		System.out.println(c);
		//操作按位异或 ^ ，相同为0，不同为1
		c = a ^ b;
		System.out.println(c);
		//操作按位取反 ~  ，0转为1，1转为0
		System.out.println(~a);
		//带符号左移 <<
		int d = 2;
		//2的二进制数左移3位，变为2的4次方
		System.out.println(2 << 3);
		//-16的二进制数右移2位，-2的4次方变为-2的2次方
		System.out.println(-16 >> 2);
		//-16的二进制数无符号右移2位，右移后的空位由 0 填补，变为1073741820
		System.out.println(-16 >>> 2);
		//16的二进制数无符号右移2位，右移后的空位由 0 填补，由2的4次方变为2的2次方
		System.out.println(16 >>> 2);
	}
}
/*
小结：>>> 无符号右移，负数会变为正数。
位运算符号操作的是二进制数。位运算符号的~与逻辑运算符的！完全不同
*/