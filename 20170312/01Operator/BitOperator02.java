//需求：操作逻辑运算符，进行二进制之间的转换
class BitOperator02 {
	public static void main(String[] args) {
		//带符号左移 <<
		int d = 3;
		//3的二进制数左移3位，变为24
		System.out.println(3 << 3);
		//-15的二进制数右移2位，变为-4
		System.out.println(-15 >> 2);
		//-16的二进制数无符号右移2位，右移后的空位由 0 填补，变为1073741820
		System.out.println(-16 >>> 2);
		//16的二进制数无符号右移2位，右移后的空位由 0 填补，由2的4次方变为2的2次方
		System.out.println(16 >>> 2);
	}
}
/*
小结：>>> 无符号右移，负数会变为正数。
*/