//���󣺽����������Լ�������Ĳ���
//����һ���࣬��ArithmeticOperators0202
class ArithmeticOperators0202 
{
	//����һ��������
	public static void main(String[] args) 
	{
		//������ǰ��
		int num1 = 5;
		//����ǰ�ã�++ a ��ʾa���������ȼ�1���ٰѼ�1��õ���ֵ�ó�ȥ����
		int num2 = ++ num1; 
		//����������ֵ������
		System.out.println("num1= " + num1 +",num2= " + num2);
		//�����ĺ���
		int num3 = 5;
		//�������ã�a ++��ʾa���������ȼ�1����a������1֮ǰ��ԭʼֵ�ó�ȥ����
		int num4 = num3 ++;
		//����num3��ֵ������1��num4��ֵΪnum3����ǰ��ԭʼֵ
		System.out.println("num3= " + num3 +",num4= " + num4);
		//�Լ���ǰ��
		int num5 = 5;
		//�Լ�ǰ�ã�-- a ��ʾa���������ȼ�1���ٰѼ�1��õ���ֵ�ó�ȥ����
		int num6 = -- num5; 
		//����������ֵ������
		System.out.println("num5= " + num5 +",num6= " + num6);
		//�Լ��ĺ���
		int num7 = 5;
		//�Լ����ã�a --��ʾa���������ȼ�1����a������1֮ǰ��ԭʼֵ�ó�ȥ����
		int num8 = num7 --;
		//����num7��ֵ������1��num8��ֵΪnum7����ǰ��ԭʼֵ
		System.out.println("num7= " + num7 +",num8= " + num8);
	}
}
