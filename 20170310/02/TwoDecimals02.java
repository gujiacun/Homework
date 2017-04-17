//需求：验证float和double的相关事项及数据类型之间的互相转换
//定义一个类，叫TwoDecimals02
class TwoDecimals02 
{
	//定义一个主方法
	public static void main(String[] args) 
	{
		//小数在java里被默认被默认保存为double类型，若要定义一个float类型的小数，要在其字面量后面加f或F
		float decimal1 = 63.21F;
		//打印decimal1，注意变量名要与上一句的变量名保持一致
		System.out.println(decimal1);
		//整数转换为浮点数要注意精度丢失的问题
		//在整数类型变量中，表示16进制数，要在前面加0x或0X
		int i = 0X1000001;
		//把i复制给变量f
		float f = i;
		//Integer.toBinaryString(i)表示把i的值转换为String类型的二进制数
		System.out.println(Integer.toBinaryString(i) + ":" + i);
		//注意括号的内容，(int)f表示把变量f由float转换为int
		//而Integer.toBinaryString((int)f)表示把(int)f转换为String类型的二进制数
		System.out.println(Integer.toBinaryString((int)f) + ":" + i);
		//在字面量超出int类型取值范围时，由int转换float，精度丢失
	}
}

