//������֤���������еĴ�С���ͻ���ת��
//����һ���࣬��TypeConvert
class TypeConvert 
{
	//����һ��������
	public static void main(String[] args) 
	{
		//�ȴ�С����һ��һ��ת��Ϊ�����ͣ�ȡֵ��Χ��������
		//127Ϊbyte�������ֵ�������������127�󣬾ͻᷢ������
		byte b = 127;
		//��byteת��Ϊshort
		short s = b;
		//��shortת��Ϊint
		int i = s;
		//��intת��Ϊlong
		long l = i;
		//��ʱ�����������Ϊ127��Ϊlong����
		System.out.println(l);
		//����������ת��ΪС������
		float f = l;
		//���ڱ����С�������Ϊ127.0
		System.out.println(f);
		//��floatת��Ϊdouble
		double d = f;
		System.out.println(d);
		//���ڴӴ�����ǿ��ת��ΪС����
		double d1 = 3.1415926;
		//ǿ������ת������ʽΪ��ת�����type��ת��ǰ�ı�����
		float f1 = (float)d1;
		//����float���͵�ȡֵ��Χ�;��ȶ���double����С����doubleתΪfloatʱ���ܻᾫ�ȶ�ʧ
		//������Ϊ3.1415925���������ȶ�ʧ
		System.out.println(f1);
		//��float����ת��Ϊlong���ͣ�С�����ֵ�λ����ʧ��ֻȡ��������
		long tall = (long)f1;
		//���3.1415925����������3
		System.out.println(tall);
		//���int�������ֵΪ2147483647
		System.out.println(Integer.MAX_VALUE);
		//ע�⣺javaĬ���������Ͷ���int���ͣ�����Ҫ��һ������int�������ֵ����Ҫ���������l��L
		double num = 369 + 23.8F + 69.658 + 2147483648L;
		//��һ���������ʽ�а������������������ʱ��byte,short,char���ͻᱻ�Զ�������int���������ʽ�����ս�����ͱ����������ʽ����ߵ�����
		System.out.println(num);
		//int������char�����ڸ�ֵʱ�����Զ�ת��
		char c1 = 66;
		//���66��ASCII��������Ӧ���ַ�
		System.out.println(c1);
		int i1 = 'B';
		//���B��ASCII��������Ӧ������
		System.out.println(i1);
	}
}
/*
С�᣺��ǿ������ת��ʱ��ע��߽����������⡣����ᷢ�������
int������char�����ڸ�ֵʱ�Զ�ת����
��ס�������������У�ȡֵ��Χ��С�����˳��byte��char,short,int,long,float,double
*/