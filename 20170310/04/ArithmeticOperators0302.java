//�����ܽ�����������ļ��ֳ�������
//����һ���࣬��ΪArithmeticOperators0302
class ArithmeticOperators0302 
{
	//����������
	public static void main(String[] args) 
	{
		//��������ʼ��i1
		int i1 = 5;
		//ע�⣺���� ++;��++ ����;���Զ���������һ�������
		i1 ++;
		//��ӡ����ʱi1�Ѿ�������1
		System.out.println("i1= " + i1);
		//��������ʼ��i2
		int i2 = 5;
		//ע�⣺���� ++;��++ ����;���Զ���������һ�������
		++ i2;
		//��ӡ����ʱi2�Ѿ�������1
		System.out.println("i2= " + i2);
		int i3 = 5;
		//����ǰ�ã�++ i3 ��ʾi3���������ȼ�1���ٰѼ�1��õ���ֵ�ó�ȥ����
		int a = ++ i3;
		//����i3��ֵ������1��a��ֵΪi3���Ӻ��ֵ
		System.out.println("a= " + a);
		System.out.println("i3= " + i3);
		int i4 = 5;
		//�������ã�i4 ++��ʾi4���������ȼ�1����i4������1֮ǰ��ԭʼֵ�ó�ȥ����
		int b = i4 ++;
		//����i4��ֵ������1��b��ֵΪi4����ǰ��ԭʼֵ
		System.out.println("b= " + b);
		System.out.println("i4= " + i4);
	}
}
