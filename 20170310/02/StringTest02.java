//���󣺲���String����ס��������ʽ����ʼ����ʽ�����ɱ���ص㡣
//����һ����StringTest02
class StringTest02 
{
	//����һ��������
	public static void main(String[] args) 
	{
		//ֱ�Ӹ�ֵ  String ������ = "����";
		String str = "Hello";
		//���Hello
		System.out.println(str);
		//�м��"+"������
		str = str + ",Mike";
		//���Hello,Mike
		System.out.println(str);
		//������������������㣬����8 + 7�õ�15��15�����ַ�������str���ӣ��õ�15Hello,Mike
		System.out.println(8 + 7 + str);
		//������������������㣬�ַ�������str�Ⱥ���7��8����
		System.out.println(str + 7 + 8);
		//������������������㣬7���ַ�������str���ӡ��ٺ�8����
		System.out.println(7 + str + 8);
	}
}
